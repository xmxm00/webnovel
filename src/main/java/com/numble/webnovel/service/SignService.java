package com.numble.webnovel.service;

import com.numble.webnovel.config.JwtTokenProvider;
import com.numble.webnovel.dto.SignInInfo;
import com.numble.webnovel.dto.SignInResultDto;
import com.numble.webnovel.dto.SignUpResultDto;
import com.numble.webnovel.entity.User;
import com.numble.webnovel.entity.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SignService {
    private UserRepository userRepository;
    private JwtTokenProvider jwtTokenProvider;
    private PasswordEncoder passwordEncoder;

    public SignService(UserRepository userRepository, JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    public SignUpResultDto signUp(User user) {
        userRepository.findByEmail(user.getEmail()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
        User processed = User.builder().email(user.getEmail()).name(user.getName()).nickname(user.getNickname()).password(passwordEncoder.encode(user.getPassword())).ticket(0).role("USER").build();
        User savedUser = userRepository.save(processed);

        if (savedUser.getName().isEmpty()) {
            return SignUpResultDto.builder().success(false).msg("Fail").build();
        } else {
            return SignUpResultDto.builder().success(true).msg("Success").build();
        }
    }

    public SignInResultDto signIn(SignInInfo signInInfo) {
        Optional<User> optUser = userRepository.findByEmail(signInInfo.getEmail());
        if (optUser.isEmpty()) {
            throw new IllegalStateException("가입된 계정이 없습니다.");
        }
        User user = optUser.get();

        if (!passwordEncoder.matches(signInInfo.getPassword(), user.getPassword())) {
            throw new IllegalStateException("비밀번호가 틀렸습니다");
        }

        SignInResultDto signInResultDto = SignInResultDto.builder().token(jwtTokenProvider.createToken(String.valueOf(user.getEmail()), List.of(user.getRole()))).build();
        signInResultDto.setSuccess(true);
        signInResultDto.setMsg("로그인 완료");

        return signInResultDto;
    }
}

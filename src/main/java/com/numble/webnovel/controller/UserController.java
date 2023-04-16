package com.numble.webnovel.controller;

import com.numble.webnovel.config.JwtTokenProvider;
import com.numble.webnovel.dto.SignInInfo;
import com.numble.webnovel.dto.SignInResultDto;
import com.numble.webnovel.dto.SignUpResultDto;
import com.numble.webnovel.entity.User;
import com.numble.webnovel.entity.repository.UserRepository;
import com.numble.webnovel.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final SignService signService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public UserController(SignService signService) {
        this.signService = signService;
    }

    @PostMapping("/sign-in")
    public SignInResultDto signin(SignInInfo signInInfo) {
        try {
            return signService.signIn(signInInfo);
        } catch (IllegalStateException e) {
            return SignInResultDto.builder().token(null).success(false).msg(e.getMessage()).build();
        }
    }

    @PostMapping("/sign-up")
    public SignUpResultDto signup(User user) {
        try {
            return signService.signUp(user);
        } catch (IllegalStateException e) {
            return SignUpResultDto.builder().success(false).msg(e.getMessage()).build();
        }
    }

}

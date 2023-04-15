package com.numble.webnovel.service;

import com.numble.webnovel.entity.User;
import com.numble.webnovel.entity.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long saveUser(User user) {
        validateAccount(user);
        user.setRole("USER");
        User result = userRepository.save(user);
        return result.getId();
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    private void validateAccount(User user) {
        userRepository.findByEmail(user.getEmail()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    public User updateUser(Long id, User user) {
        Optional<User> optSavedUser = userRepository.findById(id);
        if (optSavedUser.isEmpty()) {
            throw new IllegalStateException("회원이 없습니다.");
        }
        User savedUser = optSavedUser.get();
        savedUser.setName(user.getName());
        savedUser.setPassword(user.getPassword());
        savedUser.setNickname(user.getNickname());
        savedUser.setRole(user.getRole());
        return userRepository.save(savedUser);
    }
}

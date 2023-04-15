package com.numble.webnovel.controller;

import com.numble.webnovel.entity.Novel;
import com.numble.webnovel.entity.User;
import com.numble.webnovel.service.NovelService;
import com.numble.webnovel.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private UserService userService;
    private NovelService novelService;

    public AdminController(UserService userService, NovelService novelService) {
        this.userService = userService;
        this.novelService = novelService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUser();
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable("userId") Long id, User user) {
        try {
            return userService.updateUser(id, user);
        } catch (IllegalStateException e) {
            return User.builder().build();
        }
    }

    @GetMapping("/novels")
    public List<Novel> getNovels() {
        return novelService.getAllNovels();
    }

    @PostMapping("/novels/create")
    public Long addNovel(Novel novel) {
        return novelService.addNovel(novel).getId();
    }
}

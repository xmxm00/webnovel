package com.numble.webnovel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my")
public class MyController {

    @GetMapping("/preference")
    public String getPreference() {
        return "Hello";
    }
}

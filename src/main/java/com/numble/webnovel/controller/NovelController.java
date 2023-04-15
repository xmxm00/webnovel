package com.numble.webnovel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/novels")
public class NovelController {

    @GetMapping("/{novelId}")
    public String getNovelDetail(@PathVariable("novelId") Long novelId) {
        String ret = "Hello World!\n" + novelId;
        return ret;
    }

    @GetMapping
    public String getNovels() {

        return "Fetched All Novels!";
    }
}

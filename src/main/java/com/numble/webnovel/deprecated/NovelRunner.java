package com.numble.webnovel.deprecated;

import com.numble.webnovel.entity.Novel;
import com.numble.webnovel.entity.repository.NovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


public class NovelRunner implements ApplicationRunner {

    @Autowired
    NovelRepository novelRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Novel novel = new Novel();
//        novel.setAuthor("Baek");
//        novel.setName("NumbleNeuron");
//        novel.setDescription("Eternal Return is Back!");
//        novel.setGenre("Fantasy");
//
//        novelRepository.save(novel);
    }

    @RestController
    public static class TestController {

        @GetMapping("/hello")
        public String hello(String name) {
            return "Hello " + name;
        }
    }
}

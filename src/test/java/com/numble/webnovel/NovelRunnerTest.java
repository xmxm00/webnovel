package com.numble.webnovel;

import com.numble.webnovel.entity.Novel;
import com.numble.webnovel.entity.repository.NovelRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NovelRunnerTest {
    @Autowired
    NovelRepository novelRepository;

    @Test
    void testCreation(){
        Novel novel = new Novel();
        novel.setAuthor("Baek");
        novel.setName("NumbleNeuron");
        novel.setDescription("Eternal Return is Back!");
        novel.setGenre("Fantasy");

        novelRepository.save(novel);
        System.out.println("ID: " + novel.getId());
        Novel numbleNeuron = novelRepository.findById(1).get();
        Assertions.assertThat(numbleNeuron.getId()).isEqualTo(novel.getId());
    }
}

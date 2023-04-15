package com.numble.webnovel.service;

import com.numble.webnovel.entity.Novel;
import com.numble.webnovel.entity.repository.NovelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NovelService {
    private final NovelRepository novelRepository;

    public NovelService(NovelRepository novelRepository) {
        this.novelRepository = novelRepository;
    }

    public List<Novel> getAllNovels() {
        return novelRepository.findAll();
    }

    public Novel addNovel(Novel novel) {
        Novel save = novelRepository.save(novel);
        return save;
    }
}

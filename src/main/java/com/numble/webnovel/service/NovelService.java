package com.numble.webnovel.service;

import com.numble.webnovel.entity.Novel;
import com.numble.webnovel.entity.repository.NovelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Novel updateNovel(Long id, Novel novel) {
        Optional<Novel> optionalNovel = novelRepository.findById(id);
        if (optionalNovel.isEmpty()) {
            throw new IllegalStateException("소설이 없습니다.");
        }
        Novel savedNovel = optionalNovel.get();

        savedNovel.setTitle(novel.getTitle());
        savedNovel.setAuthor(novel.getAuthor());
        savedNovel.setDescription(novel.getDescription());
        savedNovel.setGenre(novel.getGenre());

        return novelRepository.save(savedNovel);
    }

    public Novel getNovel(Long novelId) {
        Optional<Novel> optionalNovel = novelRepository.findById(novelId);
        if (optionalNovel.isEmpty()) {
            throw new IllegalStateException("No Such Novel with id " + novelId);
        }
        Novel novel = optionalNovel.get();
        return novel;
    }

    public Long saveNovel(Novel novel) {
        Novel savedNovel = novelRepository.save(novel);
        return savedNovel.getId();
    }
}

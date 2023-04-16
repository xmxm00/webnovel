package com.numble.webnovel.service;

import com.numble.webnovel.entity.Novel;
import com.numble.webnovel.entity.Series;
import com.numble.webnovel.entity.repository.NovelRepository;
import com.numble.webnovel.entity.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeriesService {
    private final SeriesRepository seriesRepository;
    @Autowired
    private NovelRepository novelRepository;

    public SeriesService(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }


    public List<Series> getAllSeries(Long novelId) {
        return seriesRepository.findAllByNovel(novelId);
    }

    public Series getSeries(Long novelId, Long seriesId) {
        Novel novel = getNovel(novelId);

        Optional<Series> optionalSeries = seriesRepository.findById(seriesId);
        if (optionalSeries.isEmpty()) {
            throw new IllegalStateException("해당하는 시리즈가 없습니다");
        }

        Series series = optionalSeries.get();
        if (series.getNovel().equals(novel)) {
            return series;
        }
        throw new IllegalStateException("ERROR");
    }

    private Novel getNovel(Long novelId) {
        Optional<Novel> optionalNovel = novelRepository.findById(novelId);
        if (optionalNovel.isEmpty()) {
            throw new IllegalStateException("해당하는 소설이 없습니다.");
        }

        Novel novel = optionalNovel.get();
        return novel;
    }


    public Long saveSeries(Long novelId, Series series) {
        Novel novel = getNovel(novelId);
        series.setNovel(novel);
        if (series.getNovel().equals(novel)) {
            Series savedSeries = seriesRepository.save(series);
            return savedSeries.getId();
        }
        throw new IllegalStateException("novel_id와 시리즈에 표기된 정보가 다릅니다.");
    }
}

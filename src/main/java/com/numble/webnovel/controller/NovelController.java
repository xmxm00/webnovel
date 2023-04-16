package com.numble.webnovel.controller;

import com.numble.webnovel.entity.Novel;
import com.numble.webnovel.entity.Series;
import com.numble.webnovel.service.NovelService;
import com.numble.webnovel.service.SeriesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/novels")
public class NovelController {

    private final NovelService novelService;
    private final SeriesService seriesService;

    public NovelController(NovelService novelService, SeriesService seriesService) {
        this.novelService = novelService;
        this.seriesService = seriesService;
    }

    /**
     * 전체 소설 목록을 조회하는 API
     *
     * @return List
     */
    @GetMapping("")
    public List<Novel> getAllNovels() {
        return novelService.getAllNovels();
    }

    /**
     * 소설의 정보를 조회하는 API
     *
     * @param novelId
     * @return Novel
     */
    @GetMapping("/{novelId}")
    public Novel getNovelDetail(@PathVariable("novelId") Long novelId) {
        return novelService.getNovel(novelId);
    }

    /**
     * 소설의 Series의 전체 정보를 조회하는 API (몇몇의 정보들은 masking 되어야함)
     *
     * @param novelId
     * @return List
     */
    @GetMapping("/{novelId}/series")
    public List<Series> getSeries(@PathVariable("novelId") Long novelId) {
        return seriesService.getAllSeries(novelId);
    }

    /**
     * 각 시리즈의 Detail 정보를 조회하는 API
     *
     * @param novelId
     * @param seriesId
     * @return
     */
    @GetMapping("/{novelId}/{seriesId}")
    public Series getseriesDetail(@PathVariable("novelId") Long novelId, @PathVariable("sereisId") Long seriesId) {
        return seriesService.getSeries(novelId, seriesId);
    }
}

package com.numble.webnovel.entity.repository;

import com.numble.webnovel.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeriesRepository extends JpaRepository<Series, Long> {
    List<Series> findAllByNovel(Long novelId);
}

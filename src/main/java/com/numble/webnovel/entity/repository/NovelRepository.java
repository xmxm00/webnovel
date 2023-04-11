package com.numble.webnovel.entity.repository;

import com.numble.webnovel.entity.Novel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovelRepository extends JpaRepository<Novel, Long> {
}

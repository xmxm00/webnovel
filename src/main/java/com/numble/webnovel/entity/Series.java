package com.numble.webnovel.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Column(nullable = false)
    private Long novelId;

    @Column(nullable = false)
    private Integer episode;

    @Column(nullable = false)
    private String thumbnail;
    @Column(nullable = false)
    private String filePath;
    @Column(nullable = false)
    private Integer price;
}

package com.numble.webnovel.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}

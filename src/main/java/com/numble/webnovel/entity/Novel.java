package com.numble.webnovel.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class Novel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String author;
    private String description;
    @ManyToOne
    private Long genreId;
}

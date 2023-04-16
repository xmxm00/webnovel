package com.numble.webnovel.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "genre", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Novel> novelList = new ArrayList<>();
}
package com.numble.webnovel.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "novel")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Novel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    private String description;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
}

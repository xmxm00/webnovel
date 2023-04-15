package com.numble.webnovel.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Series extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "novelId")
    private Novel novel;

    @Column(nullable = false)
    private Integer episode;

    @Column(nullable = false)
    private String thumbnail;
    @Column(nullable = false)
    private String filePath;
    @Column(nullable = false)
    private Integer price;
}

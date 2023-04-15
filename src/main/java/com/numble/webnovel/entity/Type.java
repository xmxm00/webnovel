package com.numble.webnovel.entity;

import lombok.Data;

import javax.persistence.*;

/*
 * Log의 Type에 관한 Entity
 *
 */

@Entity
@Table(name = "log_type")
@Data
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}

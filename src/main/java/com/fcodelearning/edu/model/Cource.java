package com.fcodelearning.edu.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cources")
public class Cource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "author_id")
    private Integer authorId;

    @Column(name = "fee", length = 45)
    private String fee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "level_id")
    private Level level;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "photo_id")
    private Photo photo;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "duration", length = 45)
    private String duration;

    @Column(name = "issertified")
    private Byte issertified;

    @Column(name = "videocount")
    private Integer videocount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;

}
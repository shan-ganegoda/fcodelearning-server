package com.fcodelearning.edu.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Cources {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "author_id")
    private Integer authorId;

    @Basic
    @Column(name = "fee")
    private String fee;

    @ManyToOne
    @JoinColumn(name = "level_id", referencedColumnName = "id")
    private Level level;

    @ManyToOne
    @JoinColumn(name = "main_category_id", referencedColumnName = "id")
    private MainCategory mainCategory;

    @ManyToOne
    @JoinColumn(name = "sub_category_id", referencedColumnName = "id")
    private SubCategory subCategory;

    @ManyToOne
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    private Photos photo;

}

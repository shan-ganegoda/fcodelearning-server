package com.fcodelearning.edu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "duration")
    private String duration;

    @Basic
    @Column(name = "issertified")
    private Boolean issertified;

    @Basic
    @Column(name = "videocount")
    private Integer videocount;

    @Basic
    @Column(name = "fee")
    private String fee;

    @ManyToOne
    private Level level;

    @ManyToOne
    private SubCategory subCategory;

    @ManyToOne
    private MainCategory mainCategory;

    @ManyToOne
    private Photos photo;

    @OneToMany(mappedBy = "cources")
    private List<Lesson> lessonList;


}

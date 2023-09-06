package com.fcodelearning.edu.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Photos {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "imageurl")
    private String imageurl;

    @Basic
    @Column(name = "name")
    private String name;

//    @Basic
//    @Column(name = "image")
//    private String image;

}

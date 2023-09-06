package com.fcodelearning.edu.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "sub_category", schema = "fcodelearning", catalog = "")
public class SubCategory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;

//    @OneToMany(mappedBy = "subCategories")
//    private Collection<MainCategoryHasSubCategory> mainCategoryHasSubCategoriesById;

}

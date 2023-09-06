//package com.fcodelearning.edu.entity;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "main_category_has_sub_category", schema = "fcodelearning", catalog = "")
//public class MainCategoryHasSubCategory {
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "main_category_id", referencedColumnName = "id", nullable = false)
//    private MainCategory mainCategories;
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "sub_category_id", referencedColumnName = "id", nullable = false)
//    private SubCategory subCategories;
//
//    public MainCategory getMainCategories() {
//        return mainCategories;
//    }
//
//    public void setMainCategories(MainCategory mainCategories) {
//        this.mainCategories = mainCategories;
//    }
//
//    public SubCategory getSubCategories() {
//        return subCategories;
//    }
//
//    public void setSubCategories(SubCategory subCategories) {
//        this.subCategories = subCategories;
//    }
//}

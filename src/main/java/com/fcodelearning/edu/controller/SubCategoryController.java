package com.fcodelearning.edu.controller;

import com.fcodelearning.edu.dao.MainCategoryDao;
import com.fcodelearning.edu.dao.SubCategoryDao;
import com.fcodelearning.edu.entity.MainCategory;
import com.fcodelearning.edu.entity.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/subcategories")
public class SubCategoryController {

    @Autowired
    private SubCategoryDao subcategoryDao;

    @GetMapping
    public List<SubCategory> getAllCources(){

        return subcategoryDao.findAll();
    }
}

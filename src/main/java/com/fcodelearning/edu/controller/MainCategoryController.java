package com.fcodelearning.edu.controller;

import com.fcodelearning.edu.dao.MainCategoryDao;
import com.fcodelearning.edu.entity.MainCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/maincategories")
public class MainCategoryController {

    @Autowired
    private MainCategoryDao maincategoryDao;

    @GetMapping
    public List<MainCategory> getAllCources(){
        return maincategoryDao.findAll();
    }
}

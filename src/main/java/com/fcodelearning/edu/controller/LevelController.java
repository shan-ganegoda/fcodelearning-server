package com.fcodelearning.edu.controller;

import com.fcodelearning.edu.dao.CourceDao;
import com.fcodelearning.edu.dao.LevelDao;
import com.fcodelearning.edu.entity.Cources;
import com.fcodelearning.edu.entity.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/levels")
public class LevelController {

    @Autowired
    private LevelDao levelDao;

    @GetMapping
    public List<Level> getAllCources(){
        return levelDao.findAll();
    }
}

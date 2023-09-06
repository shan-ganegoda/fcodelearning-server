package com.fcodelearning.edu.controller;

import com.fcodelearning.edu.dao.CourceDao;
import com.fcodelearning.edu.entity.Cources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cources")
public class CourceController {

    @Autowired
    private CourceDao courceDao;

    @GetMapping
    public List<Cources> getAllCources(){

        return courceDao.findAll();
    }
}

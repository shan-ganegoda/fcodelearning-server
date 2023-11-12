package com.fcodelearning.edu.controller;

import com.fcodelearning.edu.dao.PhotosDao;
import com.fcodelearning.edu.entity.Photos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/photos")
public class PhotosController {

    @Autowired
    private PhotosDao photosDao;

    @GetMapping
    public List<Photos> getAllCources(){
        return photosDao.findAll();
    }
}

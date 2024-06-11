package com.fcodelearning.edu.controller;

import com.fcodelearning.edu.dto.PhotoDTO;
import com.fcodelearning.edu.model.Level;
import com.fcodelearning.edu.model.Photo;
import com.fcodelearning.edu.repository.PhotoRepository;
import com.fcodelearning.edu.services.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/photos")
public class PhotoController {

    private final PhotoRepository photoRepository;
    private final PhotoService photoService;

    @GetMapping("/{id}")
    public Photo getLevelById(@PathVariable int id) {
        return photoService.getPhotoById(id);
    }

    @GetMapping
    public List<PhotoDTO> getAllPhotos() {
        return photoService.getAllPhotos();
    }

}

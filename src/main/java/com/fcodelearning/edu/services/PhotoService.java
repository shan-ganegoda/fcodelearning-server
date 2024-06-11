package com.fcodelearning.edu.services;

import com.fcodelearning.edu.dto.PhotoDTO;
import com.fcodelearning.edu.model.Level;
import com.fcodelearning.edu.model.Photo;

import java.util.List;

public interface PhotoService {
    Photo getPhotoById(int id);

    List<PhotoDTO> getAllPhotos();
}

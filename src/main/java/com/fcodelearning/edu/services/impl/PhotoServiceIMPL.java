package com.fcodelearning.edu.services.impl;

import com.fcodelearning.edu.dto.PhotoDTO;
import com.fcodelearning.edu.exception.ResourceNotFoundException;
import com.fcodelearning.edu.model.Photo;
import com.fcodelearning.edu.repository.PhotoRepository;
import com.fcodelearning.edu.services.PhotoService;
import com.fcodelearning.edu.util.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoServiceIMPL implements PhotoService {

    private final PhotoRepository photoRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Photo getPhotoById(int id) {

        Photo photo = photoRepository.findById(id).get();

        if(photo!=null){
            return photo;
        }else{
            throw new ResourceNotFoundException("Photo Not Found!");
        }
    }

    @Override
    public List<PhotoDTO> getAllPhotos() {

        List<Photo> photos = photoRepository.findAll();

        if(!photos.isEmpty()){
            List<PhotoDTO> photoDTOList = objectMapper.PhotoListToDtoList(photos);
            return photoDTOList;
        }else{
            throw new ResourceNotFoundException("Photos Not Found!");
        }
    }
}

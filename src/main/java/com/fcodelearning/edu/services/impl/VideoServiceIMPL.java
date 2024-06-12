package com.fcodelearning.edu.services.impl;

import com.fcodelearning.edu.dto.VideoDTO;
import com.fcodelearning.edu.exception.ResourceNotFoundException;
import com.fcodelearning.edu.model.Video;
import com.fcodelearning.edu.repository.VideoRepository;
import com.fcodelearning.edu.services.VideoService;
import com.fcodelearning.edu.util.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoServiceIMPL implements VideoService {

    private final VideoRepository videoRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<VideoDTO> getAllVideos() {

        List<Video> videos = videoRepository.findAll();

        if(!videos.isEmpty()){
            return objectMapper.videoListToDtoList(videos);
        }else{
            throw new ResourceNotFoundException("No videos found");
        }
    }
}

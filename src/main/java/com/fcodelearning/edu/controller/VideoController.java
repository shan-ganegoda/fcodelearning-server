package com.fcodelearning.edu.controller;

import com.fcodelearning.edu.dto.VideoDTO;
import com.fcodelearning.edu.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/videos")
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;

    @GetMapping
    public List<VideoDTO> getAllVideos(){
        return videoService.getAllVideos();
    }
}

package com.fcodelearning.edu.repository;

import com.fcodelearning.edu.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {
}

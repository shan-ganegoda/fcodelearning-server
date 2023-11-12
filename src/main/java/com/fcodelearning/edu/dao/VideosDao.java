package com.fcodelearning.edu.dao;

import com.fcodelearning.edu.entity.Cources;
import com.fcodelearning.edu.entity.Videos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideosDao extends JpaRepository<Videos,Integer> {
}

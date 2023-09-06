package com.fcodelearning.edu.dao;

import com.fcodelearning.edu.entity.Level;
import com.fcodelearning.edu.entity.Photos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotosDao extends JpaRepository<Photos,Integer> {
}

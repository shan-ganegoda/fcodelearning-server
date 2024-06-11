package com.fcodelearning.edu.repository;

import com.fcodelearning.edu.model.Level;
import com.fcodelearning.edu.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> {
}

package com.fcodelearning.edu.dao;

import com.fcodelearning.edu.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonDao extends JpaRepository<Lesson,Integer> {
}

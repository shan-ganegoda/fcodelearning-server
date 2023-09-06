package com.fcodelearning.edu.dao;

import com.fcodelearning.edu.entity.Level;
import com.fcodelearning.edu.entity.MainCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainCategoryDao extends JpaRepository<MainCategory,Integer> {
}

package com.fcodelearning.edu.dao;

import com.fcodelearning.edu.entity.MainCategory;
import com.fcodelearning.edu.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryDao extends JpaRepository<SubCategory,Integer> {
}

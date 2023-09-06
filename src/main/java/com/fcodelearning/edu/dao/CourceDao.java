package com.fcodelearning.edu.dao;

import com.fcodelearning.edu.entity.Cources;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourceDao extends JpaRepository<Cources,Integer> {
}

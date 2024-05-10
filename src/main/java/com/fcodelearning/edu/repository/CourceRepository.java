package com.fcodelearning.edu.repository;

import com.fcodelearning.edu.model.Cource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourceRepository extends JpaRepository<Cource, Integer> {

}

package com.fcodelearning.edu.repository;

import com.fcodelearning.edu.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Integer> {
}

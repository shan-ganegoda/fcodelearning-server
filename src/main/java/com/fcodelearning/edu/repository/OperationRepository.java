package com.fcodelearning.edu.repository;

import com.fcodelearning.edu.entity.Module;
import com.fcodelearning.edu.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Integer> {
}

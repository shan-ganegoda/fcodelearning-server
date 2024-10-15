package com.fcodelearning.edu.repository;

import com.fcodelearning.edu.entity.Authority;
import com.fcodelearning.edu.entity.Module;
import com.fcodelearning.edu.entity.Operation;
import com.fcodelearning.edu.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    boolean existsByRolesAndModuleAndOperation(Role role, Module module, Operation operation);
}

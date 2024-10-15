package com.fcodelearning.edu.repository;

import com.fcodelearning.edu.entity.Module;
import com.fcodelearning.edu.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}

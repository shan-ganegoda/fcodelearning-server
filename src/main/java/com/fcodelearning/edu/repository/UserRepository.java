package com.fcodelearning.edu.repository;

import com.fcodelearning.edu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByUsername(String username);
    boolean existsByNic(String nic);
    boolean existsByEmail(String email);
}

package com.fcodelearning.edu.repository;

import com.fcodelearning.edu.entity.Module;
import com.fcodelearning.edu.entity.Userstatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStatusRepository extends JpaRepository<Userstatus, Integer> {
}

package com.fcodelearning.edu.controller;

import com.fcodelearning.edu.model.Level;
import com.fcodelearning.edu.repository.LevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/levels")
public class LevelController {

    private final LevelRepository levelRepository;

    @GetMapping("/{id}")
    public Level getLevelById(@PathVariable int id) {

        return levelRepository.findById(id).get();
    }

}

package com.fcodelearning.edu.controller;

import com.fcodelearning.edu.dto.CourceDTO;
import com.fcodelearning.edu.model.Cource;
import com.fcodelearning.edu.repository.CourceRepository;
import com.fcodelearning.edu.security.CourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cources")
public class CourceController {

    private final CourceService courceService;
    private final CourceRepository courceRepository;

    @GetMapping
    public List<CourceDTO> getAllCources() {
        return courceService.getAllCources();
//        return courceRepository.findAll();
    }

    @GetMapping("/{id}")
    public CourceDTO getCourceById(@PathVariable int id) {
      return courceService.getCourceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourceDTO createCource(@RequestBody CourceDTO courceDTO) {
        return courceService.createCource(courceDTO);
    }

    @PutMapping
    public CourceDTO updateCource(@RequestBody CourceDTO courceDTO) {
        System.out.println(courceDTO.getId());
        return courceService.updateCource(courceDTO);
    }
}

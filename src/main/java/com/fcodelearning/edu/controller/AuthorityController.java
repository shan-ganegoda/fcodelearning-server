package com.fcodelearning.edu.controller;

import com.fcodelearning.edu.dto.AuthorityDTO;
import com.fcodelearning.edu.dto.StandardResponse;
import com.fcodelearning.edu.repository.AuthorityRepository;
import com.fcodelearning.edu.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/authorities")
@RequiredArgsConstructor
public class AuthorityController {

    private final AuthorityService authorityService;

    @GetMapping
    public List<AuthorityDTO> getAll(@RequestParam HashMap<String,String> params) {
        return authorityService.getAll(params);
    }

    @PostMapping
    public AuthorityDTO create(@RequestBody AuthorityDTO authorityDTO) {
        return authorityService.save(authorityDTO);
    }

    @PutMapping
    public AuthorityDTO update(@RequestBody AuthorityDTO authorityDTO) {
        return authorityService.update(authorityDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable Integer id) {
        String message = authorityService.delete(id);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Deleted",message), HttpStatus.OK
        );
    }
}

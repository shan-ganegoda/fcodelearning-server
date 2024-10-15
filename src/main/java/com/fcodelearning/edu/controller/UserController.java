package com.fcodelearning.edu.controller;

import com.fcodelearning.edu.dto.StandardResponse;
import com.fcodelearning.edu.dto.UserDTO;
import com.fcodelearning.edu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDTO> getAll(@RequestParam HashMap<String,String> params){
        return userService.getAll(params);
    }

    @PostMapping
    public UserDTO create(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }

    @PutMapping
    public UserDTO update(@RequestBody UserDTO userDTO){
        return userService.update(userDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable Integer id){

        String message = userService.delete(id);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Deleted!",message), HttpStatus.OK
        );
    }
}

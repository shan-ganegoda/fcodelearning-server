package com.fcodelearning.edu.service;

import com.fcodelearning.edu.dto.UserDTO;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    List<UserDTO> getAll(HashMap<String, String> params);

    UserDTO save(UserDTO userDTO);

    UserDTO update(UserDTO userDTO);

    String delete(Integer id);
}

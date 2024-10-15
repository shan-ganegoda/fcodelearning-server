package com.fcodelearning.edu.service;

import com.fcodelearning.edu.dto.AuthorityDTO;

import java.util.HashMap;
import java.util.List;

public interface AuthorityService {
    List<AuthorityDTO> getAll(HashMap<String, String> params);

    AuthorityDTO save(AuthorityDTO authorityDTO);

    AuthorityDTO update(AuthorityDTO authorityDTO);

    String delete(Integer id);
}

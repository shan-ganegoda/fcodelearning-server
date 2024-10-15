package com.fcodelearning.edu.service.IMPL;

import com.fcodelearning.edu.dto.RoleDTO;
import com.fcodelearning.edu.entity.Role;
import com.fcodelearning.edu.exception.ResourceNotFoundException;
import com.fcodelearning.edu.repository.RoleRepository;
import com.fcodelearning.edu.service.RoleService;
import com.fcodelearning.edu.util.mapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceIMPL implements RoleService {

    private final RoleRepository roleRepository;
    private final ObjectMapper objectMapper;


    @Override
    public List<RoleDTO> getAll() {
        List<Role> roles = roleRepository.findAll();
        if(!roles.isEmpty()) {
            return objectMapper.roleListToDtoList(roles);
        }else{
            throw new ResourceNotFoundException("Roles Not Found!");
        }
    }
}

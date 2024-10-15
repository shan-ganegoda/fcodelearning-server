package com.fcodelearning.edu.service.IMPL;

import com.fcodelearning.edu.dto.UserStatusDTO;
import com.fcodelearning.edu.entity.Userstatus;
import com.fcodelearning.edu.exception.ResourceNotFoundException;
import com.fcodelearning.edu.repository.UserStatusRepository;
import com.fcodelearning.edu.service.UserStatusService;
import com.fcodelearning.edu.util.mapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserStatusServiceIMPL implements UserStatusService {

    private final UserStatusRepository userStatusRepository;
    private final ObjectMapper objectMapper;


    @Override
    public List<UserStatusDTO> getAll() {
        List<Userstatus> userStatusList = userStatusRepository.findAll();
        if(!userStatusList.isEmpty()){
            return objectMapper.userStatusListToDtoList(userStatusList);
        }else{
            throw new ResourceNotFoundException("UserStatus List Not Found!");
        }
    }
}

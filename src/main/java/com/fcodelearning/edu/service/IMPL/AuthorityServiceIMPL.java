package com.fcodelearning.edu.service.IMPL;

import com.fcodelearning.edu.dto.AuthorityDTO;
import com.fcodelearning.edu.entity.Authority;
import com.fcodelearning.edu.exception.ResourceAlreadyExistException;
import com.fcodelearning.edu.exception.ResourceNotFoundException;
import com.fcodelearning.edu.repository.AuthorityRepository;
import com.fcodelearning.edu.service.AuthorityService;
import com.fcodelearning.edu.util.mapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class AuthorityServiceIMPL implements AuthorityService {

    private final AuthorityRepository authorityRepository;
    private final ObjectMapper objectMapper;


    @Override
    public List<AuthorityDTO> getAll(HashMap<String, String> params) {
        List<Authority> authorities = authorityRepository.findAll();
        if(!authorities.isEmpty()){
            List<AuthorityDTO> dtos = objectMapper.authorityListToDtoList(authorities);
            if(params.isEmpty()){
                return dtos;
            }else{

                String roleid = params.get("roleid");
                String operationid = params.get("operationid");
                String moduleid = params.get("moduleid");

                Stream<AuthorityDTO> stream = dtos.stream();

                if(roleid != null) stream = stream.filter(e-> e.getRoles().getId() == Integer.parseInt(roleid));
                if(operationid != null) stream = stream.filter(e-> e.getOperation().getId() == Integer.parseInt(operationid));
                if(moduleid != null) stream = stream.filter(e-> e.getModule().getId() == Integer.parseInt(moduleid));

                return stream.collect(Collectors.toList());
            }
        }else{
            throw new ResourceNotFoundException("Authorities Not Found!");
        }
    }

    @Override
    public AuthorityDTO save(AuthorityDTO authorityDTO) {

        if (authorityRepository.existsByRolesAndModuleAndOperation(authorityDTO.getRoles(), authorityDTO.getModule(), authorityDTO.getOperation())){
            throw new ResourceAlreadyExistException("Authority Already Exists!");
        }

        Authority authority = objectMapper.authorityDtoToAuthority(authorityDTO);
        authorityRepository.save(authority);
        return authorityDTO;

    }

    @Override
    public AuthorityDTO update(AuthorityDTO authorityDTO) {
        if (authorityRepository.existsByRolesAndModuleAndOperation(authorityDTO.getRoles(), authorityDTO.getModule(), authorityDTO.getOperation())){
            throw new ResourceAlreadyExistException("Authority Already Exists!");
        }

        Authority authority = objectMapper.authorityDtoToAuthority(authorityDTO);
        authorityRepository.save(authority);
        return authorityDTO;
    }

    @Override
    public String delete(Integer id) {
        Authority authority = authorityRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Authority Not Found!"));
        authorityRepository.delete(authority);
        return "Authority Deleted!";
    }
}

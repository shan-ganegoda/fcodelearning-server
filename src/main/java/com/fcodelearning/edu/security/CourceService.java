package com.fcodelearning.edu.security;

import com.fcodelearning.edu.dto.CourceDTO;
import com.fcodelearning.edu.exception.ResourceNotFoundException;
import com.fcodelearning.edu.model.Cource;
import com.fcodelearning.edu.repository.CourceRepository;
import com.fcodelearning.edu.util.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourceService {

    private final CourceRepository courceRepository;
    private final ObjectMapper objectMapper;

    public List<CourceDTO> getAllCources() {

        List<Cource> courceList = courceRepository.findAll();

        if(!courceList.isEmpty()) {
            List<CourceDTO> courceDTOList = objectMapper.courceListToCourceDTOList(courceList);
            return courceDTOList;
        }else{
            throw new ResourceNotFoundException("Cources List is empty");
        }
    }

    public CourceDTO getCourceById(int id) {

       if(courceRepository.existsById(id)) {

           Cource cource = courceRepository.findById(id).get();
           return objectMapper.courceToCourceDTO(cource);
       }else{
           throw new ResourceNotFoundException("Cource Not Found!");
       }

    }

    public CourceDTO createCource(CourceDTO courceDTO) {

        Cource cource = objectMapper.courceDTOToCource(courceDTO);
        courceRepository.save(cource);
        return courceDTO;
    }

    public CourceDTO updateCource(CourceDTO courceDTO) {

        if(courceRepository.existsById(courceDTO.getId())) {
            Cource cource = objectMapper.courceDTOToCource(courceDTO);
            courceRepository.save(cource);
            return courceDTO;
        }else{
            throw new ResourceNotFoundException("Cources Not Found");
        }
    }
}

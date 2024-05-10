package com.fcodelearning.edu.util;

import com.fcodelearning.edu.dto.CourceDTO;
import com.fcodelearning.edu.dto.UserDTO;
import com.fcodelearning.edu.model.Cource;
import com.fcodelearning.edu.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ObjectMapper {

    UserDTO userToUserDTO(User user);

    List<CourceDTO> courceListToCourceDTOList(List<Cource> courceList);

    CourceDTO courceToCourceDTO(Cource cource);

    Cource courceDTOToCource(CourceDTO courceDTO);
}

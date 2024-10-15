package com.fcodelearning.edu.util.mapper;

import com.fcodelearning.edu.dto.AuthorityDTO;
import com.fcodelearning.edu.dto.RoleDTO;
import com.fcodelearning.edu.dto.UserDTO;
import com.fcodelearning.edu.dto.UserStatusDTO;
import com.fcodelearning.edu.entity.Authority;
import com.fcodelearning.edu.entity.Role;
import com.fcodelearning.edu.entity.User;
import com.fcodelearning.edu.entity.Userstatus;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ObjectMapper {
    List<UserDTO> userListToDtoList(List<User> users);

    User userDtoToUser(UserDTO userDTO);

    List<UserStatusDTO> userStatusListToDtoList(List<Userstatus> userStatusList);

    List<RoleDTO> roleListToDtoList(List<Role> roles);

    List<AuthorityDTO> authorityListToDtoList(List<Authority> authorities);

    Authority authorityDtoToAuthority(AuthorityDTO authorityDTO);
}

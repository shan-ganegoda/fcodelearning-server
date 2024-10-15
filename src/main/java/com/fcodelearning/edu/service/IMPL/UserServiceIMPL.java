package com.fcodelearning.edu.service.IMPL;

import com.fcodelearning.edu.dto.UserDTO;
import com.fcodelearning.edu.entity.User;
import com.fcodelearning.edu.exception.ResourceAlreadyExistException;
import com.fcodelearning.edu.exception.ResourceNotFoundException;
import com.fcodelearning.edu.repository.UserRepository;
import com.fcodelearning.edu.service.UserService;
import com.fcodelearning.edu.util.mapper.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> getAll(HashMap<String, String> params) {
        List<User> users = userRepository.findAll();
        if(!users.isEmpty()){
            List<UserDTO> dtos = objectMapper.userListToDtoList(users);
            if(params.isEmpty()){
                return dtos;
            }else{

                String username = params.get("username");
                String nic = params.get("nic");

                Stream<UserDTO> stream = dtos.stream();

                if(username != null) stream = stream.filter(u -> u.getUsername().equals(username));
                if(nic != null) stream = stream.filter(u -> u.getNic().equals(nic));

                return stream.collect(Collectors.toList());
            }
        }else{
            throw new ResourceNotFoundException("Users Not Found!");
        }
    }

    @Override
    public UserDTO save(UserDTO userDTO) {

        if(userRepository.existsByUsername(userDTO.getUsername())){
            throw new ResourceAlreadyExistException("Username Already Exists");
        }

        if(userRepository.existsByEmail(userDTO.getEmail())){
            throw new ResourceAlreadyExistException("Email Already Exists");
        }

        if(userRepository.existsByNic(userDTO.getNic())){
            throw new ResourceAlreadyExistException("Nic Already Exists");
        }

        User user = objectMapper.userDtoToUser(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(user);
        return userDTO;
    }

    @Override
    public UserDTO update(UserDTO userDTO) {

        User userrec = userRepository.findById(userDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));

        if(userRepository.existsByUsername(userDTO.getUsername()) && !userDTO.getUsername().equals(userrec.getUsername())){
            throw new ResourceAlreadyExistException("Username Already Exists");
        }

        if(userRepository.existsByEmail(userDTO.getEmail()) && !userDTO.getEmail().equals(userrec.getEmail())){
            throw new ResourceAlreadyExistException("Email Already Exists");
        }

        if(userRepository.existsByNic(userDTO.getNic()) && !userDTO.getNic().equals(userrec.getNic())){
            throw new ResourceAlreadyExistException("Nic Already Exists");
        }

        User user = objectMapper.userDtoToUser(userDTO);

        if(!userrec.getPassword().equals(userDTO.getPassword())){
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }
        userRepository.save(user);
        return userDTO;
    }

    @Override
    public String delete(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        userRepository.delete(user);
        return "User Deleted Successfully";
    }
}

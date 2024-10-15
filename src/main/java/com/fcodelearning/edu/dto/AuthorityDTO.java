package com.fcodelearning.edu.dto;

import com.fcodelearning.edu.entity.Module;
import com.fcodelearning.edu.entity.Operation;
import com.fcodelearning.edu.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityDTO {
    private Integer id;
    private Role roles;
    private Module module;
    private Operation operation;
}

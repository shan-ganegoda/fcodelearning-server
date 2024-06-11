package com.fcodelearning.edu.dto;

import com.fcodelearning.edu.model.Role;
import com.fcodelearning.edu.model.Userstatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Integer id;
    private String username;
    private String password;
    private Userstatus userstatus;
    private String firstname;
    private String lastname;
    private LocalDate datejoined;
    private String nic;
    private String address;
    private LocalDate dob;
    private String description;
    private LocalDateTime lastupdated;
    private Set<Role> roles;
}

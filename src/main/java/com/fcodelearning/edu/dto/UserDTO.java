package com.fcodelearning.edu.dto;

import com.fcodelearning.edu.entity.Role;
import com.fcodelearning.edu.entity.Userstatus;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Userstatus userstatus;
    private String firstname;
    private String lastname;
    private LocalDate datejoined;
    private String nic;
    private String address;
    private LocalDate dob;
    private String description;
    private Instant lastupdated;
    private Role roles;
}

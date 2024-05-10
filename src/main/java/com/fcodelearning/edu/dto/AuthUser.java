package com.fcodelearning.edu.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthUser {

    private UserDTO user;
    private List<String> authorities;
}

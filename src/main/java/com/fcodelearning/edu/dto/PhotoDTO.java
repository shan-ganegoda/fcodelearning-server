package com.fcodelearning.edu.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fcodelearning.edu.model.Cource;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDTO {

    private Integer id;
    private String name;
    private String imageurl;
}



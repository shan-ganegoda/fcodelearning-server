package com.fcodelearning.edu.dto;

import com.fcodelearning.edu.model.Lesson;
import com.fcodelearning.edu.model.Level;
import com.fcodelearning.edu.model.Photo;
import com.fcodelearning.edu.model.SubCategory;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourceDTO {

    private Integer id;
    private String name;
    private Integer authorId;
    private String fee;
    private Level level;
    private Photo photo;
    private String description;
    private String duration;
    private Byte issertified;
    private Integer videocount;
    private SubCategory subCategory;
    private Set<Lesson> lessons;
}

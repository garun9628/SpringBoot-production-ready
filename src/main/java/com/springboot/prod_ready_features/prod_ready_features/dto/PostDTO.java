package com.springboot.prod_ready_features.prod_ready_features.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private long id;
    private String title;
    private String description;
}

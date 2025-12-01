package com.demo.LearnRestApi.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data  // (constructor, getters and setters will replace all the codes with the boiler plate)
@AllArgsConstructor
@NoArgsConstructor
// this will create all arg constructor
public class StudentDto {
    private long id;
    private String name;
    private String email;
}


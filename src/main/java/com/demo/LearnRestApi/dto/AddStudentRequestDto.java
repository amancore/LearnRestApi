package com.demo.LearnRestApi.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data  // (constructor, getters and setters will replace all the codes with the boiler plate)
public class AddStudentRequestDto {
    @NotBlank(message = "Name is required")
    @Size(min = 3,max = 30, message = "Name should be 3 to 30 chars")
    private String name;
    @Email
    @NotBlank(message = "Email is required")
    private String email;
}


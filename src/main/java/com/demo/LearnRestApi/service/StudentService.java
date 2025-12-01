package com.demo.LearnRestApi.service;
import com.demo.LearnRestApi.dto.AddStudentRequestDto;
import com.demo.LearnRestApi.dto.StudentDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDto> getAllStudents();
    StudentDto getStudentById(Long id);
    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);
    void deleteStudentById(Long id);
    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);
    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}



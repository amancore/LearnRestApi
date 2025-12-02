package com.demo.LearnRestApi.service.implementation;
import com.demo.LearnRestApi.dto.AddStudentRequestDto;
import com.demo.LearnRestApi.dto.StudentDto;
import com.demo.LearnRestApi.entity.Student;
import com.demo.LearnRestApi.respository.StudentRepository;
import com.demo.LearnRestApi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    
    private final ModelMapper modelMapper;
    
    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(student -> modelMapper.map(student,StudentDto.class))
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id){
        Student student =  studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student now found with id : "+ id));
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto,Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not exists by id : " + id);
        }
        studentRepository.deleteById(id);
    }

    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student =  studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student now found with id : "+ id));
        modelMapper.map(addStudentRequestDto,student);
        student = studentRepository.save(student);
        return modelMapper.map(student,StudentDto.class);
    };

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student =  studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student now found with id : "+ id));
        updates.forEach((field,value)->{
            if (field.equals("name")) {
                student.setName((String) value);
            } else if (field.equals("email")) {
                student.setEmail((String) value);
            } else {
                throw new IllegalArgumentException("Unknown field: " + field);
            }
        });
        Student saved = studentRepository.save(student);
        return modelMapper.map(saved, StudentDto.class);
    }
}
//model mapper library



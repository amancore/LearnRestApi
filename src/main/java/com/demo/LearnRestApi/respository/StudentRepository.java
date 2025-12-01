package com.demo.LearnRestApi.respository;

import com.demo.LearnRestApi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// data access queries are written here
// new queries or any manipulation
// i can get the methods like create, update, delete
// this implementation is already handled by the spring boot
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}

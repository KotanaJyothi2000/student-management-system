package com.jyothi.StudentManagementSystem.repository;

import com.jyothi.StudentManagementSystem.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}

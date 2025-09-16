package com.jyothi.StudentManagementSystem.service;

import com.jyothi.StudentManagementSystem.entities.Student;

import java.util.List;

public interface StudentServiceInterface {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Integer id);
    void deleteStudentById(Integer id);
    Student updateStudent(Student student);
}

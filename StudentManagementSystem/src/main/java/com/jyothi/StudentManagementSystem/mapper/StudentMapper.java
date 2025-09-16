package com.jyothi.StudentManagementSystem.mapper;

import com.jyothi.StudentManagementSystem.entities.Student;
import com.jyothi.StudentManagementSystem.dto.StudentDTO;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDTO studentToStudentDTO(Student student);
    Student studentDTOToStudent(StudentDTO dto);
    List<StudentDTO> studentListToDTOList(List<Student> studentList);

}
package com.jyothi.StudentManagementSystem.mapper;

import com.jyothi.StudentManagementSystem.dto.StudentDTO;
import com.jyothi.StudentManagementSystem.entities.Student;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-05T21:35:55+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.15 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentDTO studentToStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setStudentId( student.getStudentId() );
        studentDTO.setStudentName( student.getStudentName() );
        studentDTO.setEmail( student.getEmail() );
        studentDTO.setDob( student.getDob() );
        studentDTO.setPhoneNumber( student.getPhoneNumber() );
        studentDTO.setSkills( student.getSkills() );
        studentDTO.setAddress( student.getAddress() );
        studentDTO.setStatus( student.getStatus() );

        return studentDTO;
    }

    @Override
    public Student studentDTOToStudent(StudentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Student student = new Student();

        student.setStudentId( dto.getStudentId() );
        student.setStudentName( dto.getStudentName() );
        student.setEmail( dto.getEmail() );
        student.setDob( dto.getDob() );
        student.setPhoneNumber( dto.getPhoneNumber() );
        student.setSkills( dto.getSkills() );
        student.setAddress( dto.getAddress() );
        student.setStatus( dto.getStatus() );

        return student;
    }

    @Override
    public List<StudentDTO> studentListToDTOList(List<Student> studentList) {
        if ( studentList == null ) {
            return null;
        }

        List<StudentDTO> list = new ArrayList<StudentDTO>( studentList.size() );
        for ( Student student : studentList ) {
            list.add( studentToStudentDTO( student ) );
        }

        return list;
    }
}

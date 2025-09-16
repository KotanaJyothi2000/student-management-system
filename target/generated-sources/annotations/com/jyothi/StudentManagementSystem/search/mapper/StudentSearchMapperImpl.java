package com.jyothi.StudentManagementSystem.search.mapper;

import com.jyothi.StudentManagementSystem.dto.StudentDTO;
import com.jyothi.StudentManagementSystem.search.dto.StudentSearchDTO;
import com.jyothi.StudentManagementSystem.search.model.StudentSearchDocument;
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
public class StudentSearchMapperImpl implements StudentSearchMapper {

    @Override
    public StudentSearchDocument studentSearchDTOToStudentSearchDocument(StudentSearchDTO dto) {
        if ( dto == null ) {
            return null;
        }

        StudentSearchDocument studentSearchDocument = new StudentSearchDocument();

        studentSearchDocument.setStudentId( dto.getStudentId() );
        studentSearchDocument.setStudentName( dto.getStudentName() );
        studentSearchDocument.setEmail( dto.getEmail() );
        studentSearchDocument.setDob( dto.getDob() );
        studentSearchDocument.setPhoneNumber( dto.getPhoneNumber() );
        studentSearchDocument.setSkills( dto.getSkills() );
        studentSearchDocument.setAddress( dto.getAddress() );
        studentSearchDocument.setStatus( dto.getStatus() );

        return studentSearchDocument;
    }

    @Override
    public StudentSearchDTO studentSearchDocumentToStudentSearchDTO(StudentSearchDocument document) {
        if ( document == null ) {
            return null;
        }

        StudentSearchDTO studentSearchDTO = new StudentSearchDTO();

        studentSearchDTO.setStudentId( document.getStudentId() );
        studentSearchDTO.setStudentName( document.getStudentName() );
        studentSearchDTO.setEmail( document.getEmail() );
        studentSearchDTO.setDob( document.getDob() );
        studentSearchDTO.setPhoneNumber( document.getPhoneNumber() );
        studentSearchDTO.setSkills( document.getSkills() );
        studentSearchDTO.setAddress( document.getAddress() );
        studentSearchDTO.setStatus( document.getStatus() );

        return studentSearchDTO;
    }

    @Override
    public StudentSearchDTO studentDTOToStudentSearchDTO(StudentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        StudentSearchDTO studentSearchDTO = new StudentSearchDTO();

        studentSearchDTO.setStudentId( dto.getStudentId() );
        studentSearchDTO.setStudentName( dto.getStudentName() );
        studentSearchDTO.setEmail( dto.getEmail() );
        studentSearchDTO.setDob( dto.getDob() );
        studentSearchDTO.setPhoneNumber( dto.getPhoneNumber() );
        studentSearchDTO.setSkills( dto.getSkills() );
        studentSearchDTO.setAddress( dto.getAddress() );
        studentSearchDTO.setStatus( dto.getStatus() );

        return studentSearchDTO;
    }

    @Override
    public List<StudentSearchDTO> studentSearchDocumentListTOStudentSearchDTOList(List<StudentSearchDocument> documents) {
        if ( documents == null ) {
            return null;
        }

        List<StudentSearchDTO> list = new ArrayList<StudentSearchDTO>( documents.size() );
        for ( StudentSearchDocument studentSearchDocument : documents ) {
            list.add( studentSearchDocumentToStudentSearchDTO( studentSearchDocument ) );
        }

        return list;
    }
}

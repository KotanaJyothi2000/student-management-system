package com.jyothi.StudentManagementSystem.search.mapper;

import com.jyothi.StudentManagementSystem.dto.StudentDTO;
import com.jyothi.StudentManagementSystem.search.dto.StudentSearchDTO;
import com.jyothi.StudentManagementSystem.search.model.StudentSearchDocument;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentSearchMapper {

    StudentSearchDocument studentSearchDTOToStudentSearchDocument(StudentSearchDTO dto);
    StudentSearchDTO studentSearchDocumentToStudentSearchDTO(StudentSearchDocument document);
    StudentSearchDTO studentDTOToStudentSearchDTO(StudentDTO dto);
    List<StudentSearchDTO> studentSearchDocumentListTOStudentSearchDTOList(List<StudentSearchDocument> documents);

}

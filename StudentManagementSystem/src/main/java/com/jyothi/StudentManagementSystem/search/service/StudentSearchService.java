package com.jyothi.StudentManagementSystem.search.service;


import com.jyothi.StudentManagementSystem.search.dto.StudentSearchDTO;
import com.jyothi.StudentManagementSystem.search.mapper.StudentSearchMapper;
import com.jyothi.StudentManagementSystem.search.model.StudentSearchDocument;
import com.jyothi.StudentManagementSystem.search.repository.StudentSearchRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentSearchService implements StudentSearchServiceinterface {

    @Autowired
    StudentSearchRepository studentSearchRepository;
    @Autowired
    StudentSearchMapper studentSearchMapper;

    @Override
    public StudentSearchDTO saveToElasticsearch(StudentSearchDTO studentSearchDTO){
        StudentSearchDocument document = studentSearchMapper.studentSearchDTOToStudentSearchDocument(studentSearchDTO);
        StudentSearchDocument savedDoc=studentSearchRepository.save(document);
        return studentSearchMapper.studentSearchDocumentToStudentSearchDTO(savedDoc);
    }

    @Override
    public void deleteById(String id) {
        studentSearchRepository.deleteById(id);
    }

    @Override
    public List<StudentSearchDTO> searchByKeyword(String keyword) {
        log.info("Searching for: {}", keyword);
        List<StudentSearchDocument> documents = studentSearchRepository.fullTextSearch(keyword);
//        List<StudentSearchDocument> documents= studentSearchRepository
//                .findByStudentNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrSkillsContainingIgnoreCaseOrAddressContainingIgnoreCaseOrStatusContainingIgnoreCaseOrPhoneNumberContainingIgnoreCase
//                        (keyword,keyword,keyword,keyword,keyword,keyword
//                        );
        return studentSearchMapper.studentSearchDocumentListTOStudentSearchDTOList(documents);
    }
}

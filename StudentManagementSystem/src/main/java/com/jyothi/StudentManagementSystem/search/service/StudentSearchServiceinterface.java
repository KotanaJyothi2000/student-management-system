package com.jyothi.StudentManagementSystem.search.service;

import com.jyothi.StudentManagementSystem.search.dto.StudentSearchDTO;
import com.jyothi.StudentManagementSystem.search.model.StudentSearchDocument;

import java.util.List;

public interface StudentSearchServiceinterface {

    StudentSearchDTO saveToElasticsearch(StudentSearchDTO dto); //for creating student idex
     void deleteById(String id);  //remove from elastic
    List<StudentSearchDTO> searchByKeyword(String keyword);  //conetent based search
}

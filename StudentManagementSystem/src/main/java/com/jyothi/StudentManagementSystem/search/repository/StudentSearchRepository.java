package com.jyothi.StudentManagementSystem.search.repository;

import com.jyothi.StudentManagementSystem.search.model.StudentSearchDocument;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentSearchRepository extends ElasticsearchRepository<StudentSearchDocument, String> {
    @Query("""
    {
      "multi_match": {
        "query": "?0",
        "type": "phrase",
        "fields": ["studentName", "email", "dob", "phoneNumber", "skills", "address", "status"]
      }
    }
    """)
    List<StudentSearchDocument> fullTextSearch(String keyword);

//    List<StudentSearchDocument> findByStudentNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrSkillsContainingIgnoreCaseOrAddressContainingIgnoreCaseOrStatusContainingIgnoreCaseOrPhoneNumberContainingIgnoreCase(
//            String studentName,
//            String email,
//            String skills,
//            String address,
//            String status,
//            String phoneNumber
//    );
}

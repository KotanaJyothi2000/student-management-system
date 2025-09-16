package com.jyothi.StudentManagementSystem.service;

import com.jyothi.StudentManagementSystem.dto.StudentDTO;
import com.jyothi.StudentManagementSystem.entities.Student;
import com.jyothi.StudentManagementSystem.mapper.StudentMapper;
import com.jyothi.StudentManagementSystem.repository.StudentRepo;
import com.jyothi.StudentManagementSystem.search.dto.StudentSearchDTO;
import com.jyothi.StudentManagementSystem.search.mapper.StudentSearchMapper;
import com.jyothi.StudentManagementSystem.search.service.StudentSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService  {

    @Autowired
    StudentRepo studentRepo;
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    StudentSearchService studentSearchService;

    @Autowired
    StudentSearchMapper studentSearchMapper;

    public StudentDTO saveStudent(StudentDTO dto) {
        Student student = studentMapper.studentDTOToStudent(dto); //  convert DTO → Entity
        Student saved = studentRepo.save(student);
        StudentDTO savedDTO = studentMapper.studentToStudentDTO(saved);
        StudentSearchDTO searchDTO = studentSearchMapper.studentDTOToStudentSearchDTO(savedDTO);
        studentSearchService.saveToElasticsearch(searchDTO);
        return savedDTO;
    }

    public List<StudentDTO> getAllStudentsDTO(){
        List<Student> students = studentRepo.findAll();
        return studentMapper.studentListToDTOList(students);

    }

    public StudentDTO getStudentById(Integer id){
         Student student= studentRepo.findById(id).orElse(null);
         return (student!= null)? studentMapper.studentToStudentDTO(student) : null;
    }

    public void deleteStudentById(Integer id){
        studentRepo.deleteById(id);
        studentSearchService.deleteById(id.toString()); //also remove from elastic search,it use id.toString() because Elasticsearch uses String as document ID.
    }

    public StudentDTO updateStudent(StudentDTO dto){
        Student student = studentMapper.studentDTOToStudent(dto);
         Student updated= studentRepo.save(student);
        StudentDTO savedDTO = studentMapper.studentToStudentDTO(updated);
        StudentSearchDTO searchDTO = studentSearchMapper.studentDTOToStudentSearchDTO(savedDTO);
        studentSearchService.saveToElasticsearch(searchDTO);
         return savedDTO;
    }

    //sync all the data in db to elasticsearch
    public void syncAllStudentsToElasticsearch() {
        List<StudentDTO> studentDTOList = getAllStudentsDTO();
        for (StudentDTO dto : studentDTOList) {
            StudentSearchDTO searchDTO = studentSearchMapper.studentDTOToStudentSearchDTO(dto);
            studentSearchService.saveToElasticsearch(searchDTO);
        }
    }
}

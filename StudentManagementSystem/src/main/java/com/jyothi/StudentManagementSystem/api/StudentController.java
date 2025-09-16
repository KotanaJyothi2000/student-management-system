package com.jyothi.StudentManagementSystem.api;

import com.jyothi.StudentManagementSystem.dto.StudentDTO;
import com.jyothi.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(value="/add")
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO dto){
        StudentDTO savedStudent= studentService.saveStudent(dto);
        return new ResponseEntity<>(savedStudent, HttpStatusCode.valueOf(200));
    }

    @GetMapping(value="/all")
    public ResponseEntity<List<StudentDTO>> getStudents(){
        List<StudentDTO> allStudents = studentService.getAllStudentsDTO();
        return new ResponseEntity<>(allStudents,HttpStatusCode.valueOf(200));
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("id") Integer id){
       StudentDTO studentById= studentService.getStudentById(id);
       return new ResponseEntity<>(studentById,HttpStatusCode.valueOf(200));
    }

    @PutMapping(value="/update")
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO dto){
       StudentDTO updatedStudent= studentService.updateStudent(dto);
       return new ResponseEntity<>(updatedStudent,HttpStatusCode.valueOf(200));
    }

    @DeleteMapping(value="/delete/{id}")
    public void deleteStudent(@PathVariable("id") Integer id){
        studentService.deleteStudentById(id);

    }
}

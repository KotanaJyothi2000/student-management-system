package com.jyothi.StudentManagementSystem.api;

import com.jyothi.StudentManagementSystem.dto.StudentDTO;
import com.jyothi.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UIStudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student-ui")
    public String showStudentList(Model model){
        List<StudentDTO> students = studentService.getAllStudentsDTO();
        model.addAttribute("students", students);
        return "student-list";
    }

    @GetMapping(value="/student-ui/new")
    public String showNewStudentForm(Model model){
        model.addAttribute("students", new StudentDTO());
        return "student-form";
    }

    @PostMapping(value="/student-ui/save")
    public String saveStudent(@ModelAttribute("students") StudentDTO dto){
        studentService.saveStudent(dto);
        return "redirect:/student-ui";
    }

    @GetMapping(value="/student-ui/edit/{id}")
    public String showEditStudentForm(@PathVariable("id") Integer id, Model model){
        StudentDTO dto= studentService.getStudentById(id);
        model.addAttribute("students", dto);
        return "student-form";
    }

    @GetMapping(value="/student-ui/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id){
        studentService.deleteStudentById(id);
        return "redirect:/student-ui";
    }

}

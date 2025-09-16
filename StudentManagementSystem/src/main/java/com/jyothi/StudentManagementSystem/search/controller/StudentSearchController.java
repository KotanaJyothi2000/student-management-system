package com.jyothi.StudentManagementSystem.search.controller;

import com.jyothi.StudentManagementSystem.search.dto.StudentSearchDTO;
import com.jyothi.StudentManagementSystem.search.model.StudentSearchDocument;
import com.jyothi.StudentManagementSystem.search.service.StudentSearchService;
import com.jyothi.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentSearchController {
    @Autowired
    private StudentSearchService studentSearchService;

    @Autowired
    StudentService studentService;

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        List<StudentSearchDTO> results = studentSearchService.searchByKeyword(keyword);
        model.addAttribute("searchResults", results);
        model.addAttribute("keyword", keyword);
        return "search-results";
    }

    @GetMapping("/elastic/sync")
    @ResponseBody
    public String syncToElastic() {
        studentService.syncAllStudentsToElasticsearch();
        return "Synced!";
    }

}
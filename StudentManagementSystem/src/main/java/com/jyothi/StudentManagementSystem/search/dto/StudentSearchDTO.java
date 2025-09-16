package com.jyothi.StudentManagementSystem.search.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSearchDTO {

    private Integer studentId;
    private String studentName;
    private String email;
    private LocalDate dob;
    private String phoneNumber;
    private String skills;
    private String address;
    private String status;
}

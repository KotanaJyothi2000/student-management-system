package com.jyothi.StudentManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Integer studentId;
    private String studentName;
    private String email;
    private LocalDate dob;
    private String phoneNumber;
    private String skills;
    private String address;
    private String status;
}

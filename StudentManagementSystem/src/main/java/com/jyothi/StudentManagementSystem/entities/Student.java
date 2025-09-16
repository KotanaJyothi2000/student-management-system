package com.jyothi.StudentManagementSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name ="STUDENT_DETAILS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Column(name ="S_ID")
    @Id
    @GeneratedValue
    private Integer studentId;

    @Column(name = "S_NAME")
    private String studentName;

    @Column(name="S_EMAIL")
    private String email;

    @Column(name="S_DOB")
    private LocalDate dob;

    @Column(name="S_PHONE_NUMBER")
    private String phoneNumber;

    @Column(name="SKILLS")
    private String skills;

    @Column(name="S_ADDRESS")
    private String address;

    @Column(name="STATUS")
    private String status;

}




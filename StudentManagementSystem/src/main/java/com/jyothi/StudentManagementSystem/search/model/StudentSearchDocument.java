package com.jyothi.StudentManagementSystem.search.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Document(indexName="students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentSearchDocument {

    @Id
    private Integer studentId;
    private String studentName;
    @Field(type = FieldType.Keyword)
    private String email;

    @Field(type = FieldType.Date, format = DateFormat.date)
    private LocalDate dob;
    private String phoneNumber;
    private String skills;
    private String address;
    private String status;


}


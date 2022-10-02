package com.tungdev.springexcelexport.service;

import com.tungdev.springexcelexport.entity.Student;

import java.util.List;

public interface IStudentService {
    void addStudent(Student student);
    List<Student> getTheListStudent();
}

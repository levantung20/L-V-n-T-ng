package com.tungdev.springexcelexport.service;

import com.tungdev.springexcelexport.entity.Student;
import com.tungdev.springexcelexport.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
     StudentRepository studentRepository;

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getTheListStudent() {
        return studentRepository.findAll();
    }
}

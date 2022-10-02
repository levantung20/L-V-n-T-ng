package com.tungdev.springexcelexport.controller;

import com.tungdev.springexcelexport.entity.Student;
import com.tungdev.springexcelexport.excel.ExcelGenerator;
import com.tungdev.springexcelexport.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/web")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/export-to-excel")
    public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_ HH:mm:ss");
        String currentDateTime = dateFormat.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename = student" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Student> listOfStudent = studentService.getTheListStudent();
        ExcelGenerator generator = new ExcelGenerator(listOfStudent);
        generator.generateExcelFile(response);
    }
}

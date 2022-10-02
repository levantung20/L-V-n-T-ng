package com.tungdev.springexcelexport;


import com.tungdev.springexcelexport.entity.Student;
import com.tungdev.springexcelexport.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class SpringExcelExportApplication implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(SpringExcelExportApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i <= 10; i++) {
            Student student = new Student();
            student.setCode("ffage11054");
            student.setNames("Tùng");
            student.setEmail("tunglv@mail.com");
            student.setAges(22);
            student.setAddress("Thái Bình");
            studentService.addStudent(student);
        }
    }
}

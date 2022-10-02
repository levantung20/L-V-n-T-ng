package com.tungdev.springexcelexport.repository;

import com.tungdev.springexcelexport.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student , Integer> {

}

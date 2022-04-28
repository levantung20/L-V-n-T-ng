package com.vti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//tự động scan tất cả các component của spring về khởi tạo, config giúp mình
@SpringBootApplication     
public class FinalExamAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalExamAdvancedApplication.class, args);
	}

}

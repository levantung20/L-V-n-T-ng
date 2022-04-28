package com.vti.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 		// định nghĩa 1 class tự cung cấp bean
public class ComponentConfiguration {
		
	@Bean
	public ModelMapper initModelMapper() {
		return new ModelMapper();     // tự động cung cấp bean cho ModelMapper
	}
	

}


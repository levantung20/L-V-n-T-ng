package com.vti.form.department;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.vti.entity.Department;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentFilterForm {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date minCreateDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date maxCreateDate;

	private Department.Type type;
}
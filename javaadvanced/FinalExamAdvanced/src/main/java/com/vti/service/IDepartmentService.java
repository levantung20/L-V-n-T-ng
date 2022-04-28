package com.vti.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Department;
import com.vti.form.department.CreatingDepartmentForm;
import com.vti.form.department.DepartmentFilterForm;
import com.vti.form.department.UpdatingDepartmentForm;

public interface IDepartmentService {
	public Page<Department> getAllDepartments(Pageable pageable, String search, DepartmentFilterForm filterForm);

	public Department getDepartmentByName(String name);

	public Department getDepartmentById(int id);

	public void createDepartment(CreatingDepartmentForm form);

	public boolean isDepartmentExistsByName(String name);

	public void updateDepartment(int id, UpdatingDepartmentForm form);

	public void deleteDepartment(int id);
	public void deleteDepartments(List<Integer> ids);

	
//	public int getDepartmentTotalMemberById(int id);
}

package com.vti.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.DTO.account.AccountDTO;
import com.vti.DTO.department.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.form.department.CreatingDepartmentForm;
import com.vti.form.department.DepartmentFilterForm;
import com.vti.form.department.UpdatingDepartmentForm;
import com.vti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class DepartmentController {

	@SuppressWarnings("unused")
	@Autowired
	private IDepartmentService service;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping()
	public Page<DepartmentDTO> getAllDepartments(Pageable pageable,
			@RequestParam(value = "search", required = false) String search, DepartmentFilterForm filterForm) {
		Page<Department> entityPages = service.getAllDepartments(pageable, search, filterForm);

		// convert entitiess ==) dtos
		List<DepartmentDTO> dtos = modelMapper.map(entityPages.getContent(), new TypeToken<List<DepartmentDTO>>() {
		}.getType());

		Page<DepartmentDTO> dtoPages = new PageImpl<>(dtos, pageable, entityPages.getTotalElements());

		return dtoPages;
	}

	@GetMapping(value = "/name/{name}")
	public void getDepartmentByName(@PathVariable(name = "name") String name) {
		Department entity = service.getDepartmentByName(name);
		DepartmentDTO dto = modelMapper.map(entity, DepartmentDTO.class);
	}

	@GetMapping(value = "/{id}")
	public DepartmentDTO getDepartmentById(@PathVariable(name = "id") int id) {
		Department entity = service.getDepartmentById(id);

		DepartmentDTO dto = modelMapper.map(entity, DepartmentDTO.class);
		return dto;
	}

	@GetMapping(value = "/name/{name}/exists")
	public boolean existsByName(@PathVariable(name = "name") String name) {
		return service.isDepartmentExistsByName(name);
	}

	@PostMapping()
	public void createDepartment(@RequestBody CreatingDepartmentForm form) {
		service.createDepartment(form);
	}

	@PutMapping(value = "/{id}")
	public void updateDepartment(@PathVariable(name = "id") int id, @RequestBody UpdatingDepartmentForm form) {
		form.setId(id);	
		service.updateDepartment(id, form);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteDepartment(@PathVariable(name = "id")int id) {
		service.deleteDepartment(id);
	}
	@DeleteMapping
	public void deleteDepartments(@RequestParam(name = "ids")List<Integer>ids) {
		service.deleteDepartments(ids);
	}
}

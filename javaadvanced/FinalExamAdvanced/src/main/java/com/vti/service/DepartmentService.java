package com.vti.service;

import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Department.Type;
import com.vti.form.department.CreatingDepartmentForm;
import com.vti.form.department.DepartmentFilterForm;
import com.vti.form.department.UpdatingDepartmentForm;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.specification.Department.DepartmentSpeification;

@Service
@Transactional
public class DepartmentService implements IDepartmentService {

	@SuppressWarnings("unused")
	@Autowired
	private IDepartmentRepository departmentRepository;

	@Autowired
	private IAccountRepository accountRepository;
	@Autowired
	private ModelMapper modelMapper;

	public Page<Department> getAllDepartments(Pageable pageable, String search, DepartmentFilterForm filterForm) {
		Specification<Department> where = DepartmentSpeification.buildWhere(search, filterForm);
		return departmentRepository.findAll(where, pageable);
	}

	public Department getDepartmentByName(String name) {
		return departmentRepository.findByName(name);
	}

	public Department getDepartmentById(int id) {
		return departmentRepository.findById(id).get();
	}

	public boolean isDepartmentExistsByName(String name) {
		return departmentRepository.existsByName(name);
	}

	public void createDepartment(CreatingDepartmentForm form) {
		Department department = modelMapper.map(form, Department.class);

		List<Integer> accountIds = form.getAccountIds();
		List<Account> accounts = new ArrayList<>();
		if (accountIds != null && !accountIds.isEmpty()) {
			for (Integer accountId : accountIds) {
				Account account = accountRepository.findById(accountId).get();
				accounts.add(account);
			}
			// add account
			department.setAccounts(accounts);

		}
		departmentRepository.save(department);
	}

	public void updateDepartment(int id, UpdatingDepartmentForm form) {
		Department department = getDepartmentById(id);

		Department newDepartment = modelMapper.map(form, Department.class);
		newDepartment.setName(department.getName());
		newDepartment.setTotalMember(department.getTotalMember());
		newDepartment.setCreateDate(department.getCreateDate());
		departmentRepository.save(newDepartment);
	}

	public void deleteDepartment(int id) {
		departmentRepository.deleteById(id);
	}

	@Override
	public void deleteDepartments(List<Integer> ids) {
		departmentRepository.deleteByIds(ids);
	}

}

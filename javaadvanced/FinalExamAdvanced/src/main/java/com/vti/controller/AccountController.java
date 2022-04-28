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
import com.vti.DTO.account.DepartmentsDTO;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.form.Account.CreatingAccountForm;
import com.vti.form.Account.UpdatingAccountForm;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AccountController {

	@Autowired
	private IAccountService service;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping()
	public Page<AccountDTO> getAllAccounts(Pageable pageable,
			@RequestParam(value = "search", required = false) String search,
			com.vti.form.Account.AccountFilterForm filterForm) {

		Page<Account> entityPages = service.getAllAccounts(pageable, search, filterForm);

		// convert entities --> dtos (convert 1 list ra 1 list)
		List<AccountDTO> dtos = modelMapper.map(entityPages.getContent(), new TypeToken<List<AccountDTO>>() {
		}.getType());

		Page<AccountDTO> dtoPages = new PageImpl<>(dtos, pageable, entityPages.getTotalElements());

		return dtoPages;
	}

	@GetMapping(value = "/{id}")
	public AccountDTO getAccountByID(@PathVariable(name = "id") int id) {
		Account entity = service.getAccountByID(id);

		// convert entity to dto(convert 1 Object ra 1 object)
		AccountDTO dto = modelMapper.map(entity, AccountDTO.class);
		return dto;
	}
	
	@GetMapping("/departments")
	public Page<DepartmentsDTO> getAllDepartmentsForSearch(Pageable pageable,
			@RequestParam(value = "search", required = false) String search) {

		Page<Department> entityPages = service.getAllDepartmentsForSearch(pageable, search);

		// convert entities --> dtos
		List<DepartmentsDTO> dtos = modelMapper.map(entityPages.getContent(), new TypeToken<List<DepartmentsDTO>>() {
		}.getType());

		Page<DepartmentsDTO> dtoPages = new PageImpl<>(dtos, pageable, entityPages.getTotalElements());

		return dtoPages;

	}


	@GetMapping(value = "/username/{username}")
	public void getAccountByName(@PathVariable(name = "username") String username) {
		Account entity = service.getAccountByName(username);

		// convert entity to dto
		AccountDTO dto = modelMapper.map(entity, AccountDTO.class);
	}

	@GetMapping(value = "/username/{username}/exists")
	public boolean existsByUsername(@PathVariable(name = "username") String username) {
		return service.isAccountExistByUsername(username);
	}
	
	
	@GetMapping(value ="/department/null")
	public Page<AccountDTO> getAccountsByDepartmentIsNull(Pageable pageable) {

		Page<Account> entityPages = service.getAccountsByDepartmentIsNull(pageable);

		// convert entities --> dtos
		List<AccountDTO> dtos = modelMapper.map(entityPages.getContent(), new TypeToken<List<AccountDTO>>() {
		}.getType());

		Page<AccountDTO> dtoPages = new PageImpl<>(dtos, pageable, entityPages.getTotalElements());

		return dtoPages;

	}


	@PostMapping()
	public void createAccount(@RequestBody CreatingAccountForm form) {
		service.createAccount(form);
	}

	@PutMapping(value = "/{id}")
	public void updateAccount(@PathVariable(name = "id") int id, @RequestBody UpdatingAccountForm form) {
		form.setId(id);
		service.updateAccount( id, form);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteAccount(@PathVariable(name = "id") int id) {
		service.deleteAccount(id);
	}

	@DeleteMapping
	public void deleteAccounts(@RequestParam(name = "ids") List<Integer> ids) {
		service.deleteAccounts(ids);
	}
}

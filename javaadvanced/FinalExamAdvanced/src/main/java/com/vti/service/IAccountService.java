package com.vti.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.form.Account.CreatingAccountForm;
import com.vti.form.Account.UpdatingAccountForm;

public interface IAccountService extends UserDetailsService{
//	Có thể chia nhỏ interfaces ra để dễ quản lý 
//	còn ít thì k cần chia ra (chia theo mục đích ) 
	public Page<Account> getAllAccounts(Pageable pageable, String search,
			com.vti.form.Account.AccountFilterForm filterForm);

	public void createAccount(CreatingAccountForm form);

	public void updateAccount(int id, UpdatingAccountForm form);

	public void deleteAccount(int id);

	public void deleteAccounts(List<Integer> ids);

	public Account getAccountByID(int id);

	public Account getAccountByName(String username);

	public boolean isAccountExistByUsername(String username);

	public Page<Department> getAllDepartmentsForSearch(Pageable pageable, String search);

	public Page<Account> getAccountsByDepartmentIsNull(Pageable pageable);

	public Account getAccountByUsername(String username);






}

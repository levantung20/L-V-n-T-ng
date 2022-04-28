package com.vti.service;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.form.Account.CreatingAccountForm;
import com.vti.form.Account.UpdatingAccountForm;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.specification.account.AccountSpecification;
import com.vti.specification.account.DepartmentSpecificationForSearch;

@Service
@Transactional
public class AccountService implements IAccountService {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private IAccountRepository accountrepository;

	@Autowired
	private IDepartmentRepository departmentRepository;

	public Page<Account> getAllAccounts(Pageable pageable, String search,
			com.vti.form.Account.AccountFilterForm filterForm) {
		Specification<Account> where = AccountSpecification.buildWhere(search, filterForm);
		return accountrepository.findAll(where, pageable);
	}

	@Override
	public Page<Department> getAllDepartmentsForSearch(Pageable pageable, String search) {
		Specification<Department> where = DepartmentSpecificationForSearch.buidWhere(search);
		return departmentRepository.findAll(where, pageable);
	}

	public void createAccount(CreatingAccountForm form) {
		TypeMap<CreatingAccountForm, Account> typeMap = modelMapper.getTypeMap(CreatingAccountForm.class,
				Account.class);
		if (typeMap == null) { // if not already added
			// skip field
			modelMapper.addMappings(new PropertyMap<CreatingAccountForm, Account>() {
				@Override
				protected void configure() {
					skip(destination.getId());
				}
			});

		}
		// convert form to entity
		Account account = modelMapper.map(form, Account.class);

		accountrepository.save(account);
	}

	public Account getAccountByID(int id) {
		return accountrepository.findById(id).get();
	}

	public void updateAccount(int id, UpdatingAccountForm form) {
		Account account = getAccountByID(id);

		// convert form to entity
		Account newAccount = modelMapper.map(form, Account.class);
		newAccount.setUsername(account.getUsername());
		newAccount.setFirstName(account.getFirstName());
		newAccount.setLastName(account.getLastName());
		newAccount.setPassword(account.getPassword());

		accountrepository.save(newAccount);
	}

	// delete 1
	public void deleteAccount(int id) {
		accountrepository.deleteById(id);
	}

	// delete all
	public void deleteAccounts(List<Integer> ids) {
		accountrepository.deleteByIds(ids);
	}

	@Override
	public Account getAccountByName(String username) {
		return accountrepository.findByUsername(username);
	}

	@Override
	public boolean isAccountExistByUsername(String username) {
		return accountrepository.existsByUsername(username);
	}

	@Override
	public Page<Account> getAccountsByDepartmentIsNull(Pageable pageable) {
		return accountrepository.getAccountsByDepartmentIsNull(pageable);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountrepository.findByUsername(username);

		// error 401
		if (account == null) {
			throw new UsernameNotFoundException(username);
		}
		
		// nếu tìm thấy thông tin thì return ra 
		return new User(account.getUsername(), account.getPassword(),
				AuthorityUtils.createAuthorityList(account.getRole().toString()));
	}

	@Override
	public Account getAccountByUsername(String username) {
		return accountrepository.findByUsername(username);
	}
}

package com.vti.test;

import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Group;
import com.vti.entity.GroupAccount;
import com.vti.repository.AccountRepository;
import com.vti.repository.GroupRepository;

public class GroupTest {

	public static void main(String[] args) {
		GroupRepository repository = new GroupRepository();
		AccountRepository accountRepository = new AccountRepository();

		System.out.println("***********GET ALL***********");

		List<Group> groups = repository.getAllGroups();

		for (Group group : groups) {
			System.out.println(group);
		}
		Account account = (Account) accountRepository.getAllAccounts();
		Group groupss = new Group();
		groupss.setName("Lê Văn Tùng");
		groupss.setId((short)10);
//		groupss.setCreator(account);
		repository.createGroup(groupss);
	}
	
		
}

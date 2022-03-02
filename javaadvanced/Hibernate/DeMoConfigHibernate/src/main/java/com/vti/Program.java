package com.vti;

import java.util.List;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;

/**
 * Hello world!
 *
 */
public class Program 
{
	public static void main(String[] args) {
			AccountRepository acRepository = new AccountRepository();
			
			System.out.println("***********GET ALL ACCOUNT***********");

			List<Account> accounts = acRepository.getAllAccounts();

			for (Account account : accounts) {
				System.out.println(account);
			}
			
			
			System.out.println("\n\n***********CREATE DEPARTMENT***********");

			Account accountCreate = new Account();
			accountCreate.setFullName("Le Văn Tùng");
			accountCreate.setFirstName("Le");
			accountCreate.setLastName("Tung");
			accountCreate.setEmali("ltung@7436.com");
			accountCreate.setUserName("vihecal100");
			acRepository.createAccount(accountCreate);
			
	}
			
	
	
}

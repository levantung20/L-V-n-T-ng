package com.vti.Entity.Ex1;


import java.time.LocalDateTime;
import java.util.Date;

import com.vti.Entity.Ex2.Account;

public class Group {
	int groupId;
	String groupName;
	Account creator;
	LocalDateTime createDate;
	Account[] accounts;
	
	public Group() {
		
	}
		
	// b
	public Group(String groupName, Account creator, LocalDateTime createDate, Account[] accounts) {
		this.groupName = groupName;
		this.creator = creator;
		this.createDate = createDate;
		this.accounts = accounts;
	}

	// c
	public Group(String groupName, Account creator, LocalDateTime createDate,String[] username) {
		this.groupName = groupName;
		this.creator = creator;
		this.createDate = createDate;
		
		// tạo account
		Account[] useraccounts = new Account[username.length];
		for (int i = 0; i < useraccounts.length; i++) {
			useraccounts[i]  =  new Account(1, username[i], null, null, null);
		}
		
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Account getCreator() {
		return creator;
	}

	public void setCreator(Account creator) {
		this.creator = creator;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}
	
	
}

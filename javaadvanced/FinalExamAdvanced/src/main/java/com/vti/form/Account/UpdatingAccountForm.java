package com.vti.form.Account;

import com.vti.entity.Account;
import com.vti.entity.Account.Role;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdatingAccountForm {
	private int id;

	private Account.Role role;

	private int departmentId;
}

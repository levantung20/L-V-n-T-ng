package com.vti.specification.account;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.vti.Utils.Utils;
import com.vti.entity.Account;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//AccountSpecification(để sử dụng kết hợp vào với nhau)
public class AccountSpecification {

	@SuppressWarnings("deprecation")
	public static Specification<Account> buildWhere(String search, com.vti.form.Account.AccountFilterForm filterForm) {

		Specification<Account> where = null;

		if (!StringUtils.isEmpty(search)) {
			search = Utils.formatSearch(search);
			CustomSpecification name = new CustomSpecification("username", search);
			CustomSpecification fullName = new CustomSpecification("fullName", search);
			where = Specification.where(name).or(fullName);
		}

		if (filterForm != null && filterForm.getRole() != null) {
			CustomSpecification Role = new CustomSpecification("role", filterForm.getRole());
			if (where == null) {
				where = Role;
			} else {
				where = where.and(Role);
			}
		}

		if (filterForm != null && filterForm.getDepartmentName() != null) {
			CustomSpecification departmentName = new CustomSpecification("departmentName",
					filterForm.getDepartmentName());
			if (where == null) {
				where = departmentName;
			} else {
				where = where.and(departmentName);
			}
		}

		return where;
	}
}

// CustomSpecification( định nghĩa điều kiện từng  trường lẻ )
@SuppressWarnings("serial")
@RequiredArgsConstructor
class CustomSpecification implements Specification<Account> {

	@NonNull
	private String field;
	@NonNull
	private Object value;

	@Override
	public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		if (field.equalsIgnoreCase("username")) {
			return criteriaBuilder.like(root.get("username"), "%" + value.toString() + "%");
		}

		if (field.equalsIgnoreCase("fullName")) {
			return criteriaBuilder.like(root.get("fullName"), "%" + value.toString() + "%");
		}

		if (field.equalsIgnoreCase("role")) {
			return criteriaBuilder.equal(root.get("role"), value);
		}

		if (field.equalsIgnoreCase("departmentName")) {
			return criteriaBuilder.equal(root.get("department").get("name"), value);
		}

		return null;
	}
}

package com.vti.specification.account;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.vti.Utils.Utils;
import com.vti.entity.Department;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class DepartmentSpecificationForSearch {

	@SuppressWarnings("deprecation")
	public static Specification<Department> buidWhere(String search) {
		Specification<Department> where = null;

		if (!StringUtils.isEmpty(search)) {
			search = Utils.formatSearch(search);
			CustomSpecification2 name = new CustomSpecification2("name", search);
			where = Specification.where(name);
		}

		return where;
	}
}

@SuppressWarnings("serial")
@RequiredArgsConstructor
class CustomSpecification2 implements Specification<Department> {
	@NonNull
	private String field;
	@NonNull
	private Object value;

	@Override
	public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if (field.equalsIgnoreCase("name")) {
			return criteriaBuilder.like(root.get("name"), "%" + value.toString() + "%");
		}
		return null;
	}
}

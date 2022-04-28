package com.vti.specification.Department;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.vti.entity.Department;
import com.vti.form.department.DepartmentFilterForm;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;

public class DepartmentSpeification {

	@SuppressWarnings("deprecation")
	public static Specification<Department> buildWhere(String search, DepartmentFilterForm filterForm) {

		Specification<Department> where = null;
		if (!StringUtils.isEmpty(search)) {
			search = search.trim();
			CustomSpecification name = new CustomSpecification("name", search);
			where = Specification.where(name);
		}
			// if there is filter by min id

			if (filterForm != null && filterForm.getMinCreateDate() != null) {
				CustomSpecification minCreateDate = new CustomSpecification("minCreateDate",
						filterForm.getMinCreateDate());
				if (where == null) {
					where = minCreateDate;
				} else {
					where = where.and(minCreateDate);
				}
			}

			if (filterForm != null && filterForm.getMaxCreateDate() != null) {
				CustomSpecification maxCreateDate = new CustomSpecification("maxCreateDate",
						filterForm.getMaxCreateDate());
				if (where == null) {
					where = maxCreateDate;
				} else {
					where = where.and(maxCreateDate);
				}

			}
		
			if (filterForm != null && filterForm.getType() != null) {
				CustomSpecification type = new CustomSpecification("type", filterForm.getType());
				if (where == null) {
					where = type;
				} else {
					where = where.and(type);
				}

			}

		
		return where;

	}
}

	@SuppressWarnings("serial")
	@RequiredArgsConstructor
	class CustomSpecification implements Specification<Department> {
		@NonNull
		private String field;
		@NonNull
		private Object value;

		public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

			if (field.equalsIgnoreCase("name")) {
				return criteriaBuilder.like(root.get("name"), "%" + value.toString() + "%");
			}

			if (field.equalsIgnoreCase("minCreateDate")) {
				return criteriaBuilder.lessThanOrEqualTo(root.get("createDate").as(java.sql.Date.class), (Date) value);
			}

			if (field.equalsIgnoreCase("maxCreateDate")) {
				return criteriaBuilder.lessThanOrEqualTo(root.get("createDate").as(java.sql.Date.class), (Date) value);

			}
	
			if (field.equalsIgnoreCase("type")) {
				return criteriaBuilder.equal(root.get("type"), value);
			}
			return null;
		}

	}

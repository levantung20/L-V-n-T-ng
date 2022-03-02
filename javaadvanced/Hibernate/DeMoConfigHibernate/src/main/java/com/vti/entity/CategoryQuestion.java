package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CategoryQuestion")
public class CategoryQuestion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = " CategoryID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	@Column(name = "CategoryName", length = 50, nullable = false, unique = true)
	private String categoryName;

	public CategoryQuestion() {

	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
		@Override
		public String toString() {

			return "CategoryName " + " |"  + "id " + id + "|" + "categoryName " + "|" + categoryName;
		}
}

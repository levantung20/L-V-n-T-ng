package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// tạo file config
@Entity
@Table(name = "`Group`")
public class Group implements Serializable {
	private static final long serialVersionUID = 1l;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "`name`", length = 50, nullable = false, unique = true)
	private String name;
	@Column(name = "`create_Date`", nullable = false)
	private Date create_Date;

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreate_Date() {
		return create_Date;
	}

	public void setCreate_Date(Date create_Date) {
		this.create_Date = create_Date;
	}

	@Override
	public String toString() {
		return "Group" + "|" + "id" + this.id + "|" + " name " + "|" + this.name + "|" + " create_Date" + "|"
				+ this.create_Date;
	}

}

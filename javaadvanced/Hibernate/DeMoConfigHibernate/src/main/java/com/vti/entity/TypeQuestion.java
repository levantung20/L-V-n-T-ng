package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vti.entity.enumrate.TypeName;
import com.vti.entity.enumrate.TypeNameConvert;

@Entity
@Table(name = "TypeQuestion")
public class TypeQuestion {
	@Column(name = "TypeID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	@Column(name = "TypeName", nullable = false, unique = true)
	@Convert(converter = TypeNameConvert.class)
	private TypeName name;

	public TypeQuestion() {

	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public TypeName getName() {
		return name;
	}

	public void setName(TypeName name) {
		this.name = name;
	}
		@Override
		public String toString() {
			return "TypeQuesiton { " + "ID = " + id + ", Name = '" + name.getValue() + '\'' + '}';
		}
}

package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vti.entity.enumrate.PositionName;
import com.vti.entity.enumrate.PositionNameConvert;

@Entity
@Table(name = "`Position`")
public class Position implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "PositionID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short positionId;
	@Column(name = "PositionName", nullable = false, unique = true)
	@Convert(converter = PositionNameConvert.class)
	private PositionName name;

	public Position() {

	}

	public short getPositionId() {
		return positionId;
	}

	public void setPositionId(short positionId) {
		this.positionId = positionId;
	}

	public PositionName getName() {
		return name;
	}

	public void setName(PositionName name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Position { " + "ID = " + "id" + ", Name = '" + "PositionName" + '\'' + '}';
	}
}

package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Answer")
public class Answer {
	@Column(name = "Answers")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	@Column(name = "Content", length = 100, nullable = false, unique = true)
	private String content;
	@Column(name = "isCorrect")
	private Boolean isconrrect;

	public Answer() {

	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getIsconrrect() {
		return isconrrect;
	}

	public void setIsconrrect(Boolean isconrrect) {
		this.isconrrect = isconrrect;
	}
		@Override
		public String toString() {

			return  "Answers " +  " | " + " id" + " | " + id +  " | " + "content" +  " | " + content   + " | " +  "isCorrect" +  " | " + isconrrect  ;
		}
}

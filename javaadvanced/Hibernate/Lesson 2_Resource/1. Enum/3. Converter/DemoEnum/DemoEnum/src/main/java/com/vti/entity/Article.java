package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Article")
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "title", length = 50, nullable = false, unique = true)
	private String title;

	@Column(name = "`status`", nullable = false)
	@Convert(converter = ArticleStatusConverter.class)
	private Status status;

	public Article() {
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", status=" + status + "]";
	}

	public enum Status {
		OPEN("O"), REVIEW("REV"), APPROVED("A"), REJECTED("REJ");

		private String status;

		private Status(String status) {
			this.status = status;
		}

		public String getStatus() {
			return status;
		}

		public static Status toEnum(String sqlStatus) {
			for (Status item : Status.values()) {
				if (item.getStatus().equals(sqlStatus)) {
					return item;
				}
			}
			return null;
		}
	}
}

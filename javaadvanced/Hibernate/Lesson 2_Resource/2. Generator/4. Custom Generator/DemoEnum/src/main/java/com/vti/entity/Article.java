package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Article")
public class Article implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "`code`", length = 50)
	@Id
	@GenericGenerator(
			name = "article-code-generator", 
			strategy = "com.vti.entity.ArticleCodeGenerator"
	)
	@GeneratedValue(generator = "article-code-generator")
	private String code;

	@Column(name = "title", length = 50, nullable = false, unique = true)
	private String title;

	@Column(name = "`type`", length = 50, nullable = false)
	private String type;

	public Article() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Article [code=" + code + ", title=" + title + ", type=" + type + "]";
	}
	
}

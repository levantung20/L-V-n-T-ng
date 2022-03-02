package com.vti.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.vti.entity.Article.Status;

@Converter(autoApply = true)
public class ArticleStatusConverter implements AttributeConverter<Article.Status, String> {

	public String convertToDatabaseColumn(Status status) {
		if (status == null) {
			return null;
		}
		return status.getStatus();
	}

	public Status convertToEntityAttribute(String sqlStatus) {
		if (sqlStatus == null) {
			return null;
		}
		return Article.Status.toEnum(sqlStatus);
	}

}

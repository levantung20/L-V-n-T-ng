package com.vti.entity.enumrate;

import javax.persistence.AttributeConverter;

public class TypeNameConvert implements  AttributeConverter<TypeName, String> {
	public String convertToDatabaseColumn(TypeName name) {
		if (name == null) {
			return null;
		}

		return name.getValue();
	}

	/*
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.
	 * Object)
	 */
	public TypeName convertToEntityAttribute(String value) {
		return TypeName.of(value);
	}

}

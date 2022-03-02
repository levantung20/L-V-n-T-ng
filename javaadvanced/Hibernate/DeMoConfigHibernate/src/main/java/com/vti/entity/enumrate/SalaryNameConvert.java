package com.vti.entity.enumrate;

import javax.persistence.AttributeConverter;

public class SalaryNameConvert  implements  AttributeConverter<SalaryName, String>{
	public String convertToDatabaseColumn(SalaryName name) {
		if (name == null) {
			return null;
		}

		return name.getValue();
	}

	/*
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.
	 * Object)
	 */
	public SalaryName convertToEntityAttribute(String value) {
		return SalaryName.of(value);
	}

}	

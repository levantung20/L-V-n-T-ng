package com.vti.entity.enumrate;

public enum TypeName {
		TITLE("0") , DEV("1") , SCRUM_MASTER("2") , PM("3");
	
		private String value;

		private TypeName(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
			public static TypeName of(String value) {
				if (value == null) {
					return null;
					}
				
				for (TypeName name : TypeName.values()) {
					if (name.getValue().equals(value)) {
						return name;
						}
				}
				return null;
			}
		
}

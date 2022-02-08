package entitye;

public enum Gender {
	NAM("nam"), NU("nu"), KHAC("khac");

	String gender;

	Gender(String gender) {
		this.gender = gender;
	}
	public static Gender fromValue(String gender) {
		for (Gender category : values()) {
			if (category.gender.equalsIgnoreCase(gender)) {
				return 	category;
			}
		}
		
		 throw new IllegalArgumentException("không phải là loại ENUM tương ứng");
		
	}
}

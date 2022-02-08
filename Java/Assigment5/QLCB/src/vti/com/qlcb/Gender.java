package vti.com.qlcb;

public enum Gender {
	NAM("nam"), NU("nữ"), KHÁC("khác");
	
	
	String gender;
	Gender(String gender) {
		this.gender = gender;
	}
	public static Gender fromValue(String gender) {
		for (Gender category : values()) {
			if(category.gender.equalsIgnoreCase(gender)) {
				return category;
			}
		}
		throw new IllegalArgumentException("Khong phai loai ENUM tuong ung");
	}
}

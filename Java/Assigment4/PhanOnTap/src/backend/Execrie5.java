package backend;

import entity.HighSchoolStudent;

public class Execrie5 {
		public static void main(String[] args) {
			HighSchoolStudent highSchoolStudent1 = new HighSchoolStudent("Tung", 1, "Chuyên Văn", "Đại Học Công Nghiệp");
			
			System.out.println(highSchoolStudent1.getName());
			System.out.println(highSchoolStudent1.getId());
			System.out.println(highSchoolStudent1.getClazz());
			System.out.println(highSchoolStudent1.getDesiredUniversity());
		}
}

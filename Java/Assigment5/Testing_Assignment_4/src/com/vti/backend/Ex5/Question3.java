package com.vti.backend.Ex5;

import com.vti.Entity.Ex5.HightSchool;

public class Question3 {
		public static void main(String[] args) {
			HightSchool strSchool = new HightSchool("Tung", 1, "VTI001", "Đại Học Công Nghiệp");

				System.out.println(strSchool.getName());
				System.out.println(strSchool.getId());
				System.out.println(strSchool.getClazz());
				System.out.println(strSchool.getDesiredUniversity());
		}
}

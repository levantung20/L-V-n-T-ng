package com.vti.enttity.Ex2;

public class Student {
		private final int id;
		private String name;
		
		public Student(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public final void study() {
			System.out.println("Đang học bài....");
		}
}

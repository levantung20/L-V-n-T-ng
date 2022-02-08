package com.vti.enttity.Ex1;

public class PrimaryStudent extends Student {
		public 	static int countPrimary = 0;
		
			public PrimaryStudent(int id ,String name) {
				super(id , name);
				countPrimary++;
			}
}

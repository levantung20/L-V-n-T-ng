package com.vti.enttity.Ex1;

public class SecondaryStudent extends Student {
		public static  int	countSe =0;
		
		public SecondaryStudent(int id , String name) {
			super(id , name);
			countSe ++;
		}
}

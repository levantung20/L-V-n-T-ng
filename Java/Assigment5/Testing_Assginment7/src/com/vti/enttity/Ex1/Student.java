	package com.vti.enttity.Ex1;

public class Student {
		private int id;
		private String name;
		private static  String college;
		private static int COUNT = 0;
		private static 	int moneyGroup;
		
		
		public Student(int id, String name) {
			this.id = id;
			this.name = name;
			this.moneyGroup += 100;
			COUNT++;
		}
		
		public Student() {
		}
		public void nopTien(int amount) {
			this.moneyGroup += amount;
		}
		public void layTien(int amount) {
			this.moneyGroup -= amount;
			 
		}

		public static int getMoneyGroup() {
			return moneyGroup;
		}
		public static void setMoneyGroup(int moneyGroup) {
			Student.moneyGroup = moneyGroup;
		}
		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public static String getCollege() {
			return college;
		}


		public static void setCollege(String college) {
			Student.college = college;
		}


		public static int getCOUNT() {
			return COUNT;
		}
		public static void setCOUNT(int cOUNT) {
			COUNT = cOUNT;
		}
//		@Override
//		public String toString() {
//		return "id " + this.id + ", name " + this.name + ", college " + this.college ;
//		}
		@Override
		public String toString() {
		return "id " + this.id + ", name " + this.name ;
		}
		
}	

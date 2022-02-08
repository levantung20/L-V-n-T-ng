//package com.vti.entity.Ex3;
//
//import java.beans.Expression;
//import java.util.Iterator;
//import java.util.Scanner;
//
//public class ScannerUtils {
//		private static Scanner scanner = new Scanner(System.in);
//		
//		public static int inputId() {
//			while (true) {
//				int id = inputInt("bạn nhập vào số");
//				if(id > 0) {
//					return id;
//				}
//				System.out.println(" bạn phải nhập số lớn 0 , vui lòng nhập lại");
//			}
//	
//		}
//		public static String inputName() {
//			return inputString();
//		}
//		public static int inputInt() {
//			return inputInt("hãy nhập vào số , vui lòng nhập lại ");
//		}
//		public static int inputInt(String errorMessage) {
//			while (true) {
//				try {
//					return Integer.parseInt(scanner.nextLine().trim());
//				} catch (Exception e) {
//					System.out.println(errorMessage);
//				}
//			}
//		}
//		public static float inputFloat(String errorMessage) {
//			while ( true ) {
//				try {
//					return Float.parseFloat(scanner.nextLine().trim());
//				} catch (Exception e) {
//				System.out.println(errorMessage);
//				}
//			}
//		}
//		public static double inputDouble(String errorMessage) {
//			while (true) {
//				try {
//					return Double.parseDouble(scanner.nextLine().trim());
//				} catch (Exception e) {
//					System.out.println(errorMessage);
//				}
//			}
//		}
//		public static String inputString() {
//			while (true) {
//			
//					String input =  scanner.nextLine().trim();
//					if (!input.isEmpty()) {
//						return input;
//					} else if(input.length() < 6) {
//						System.out.println("Bạn phải nhập vào chuỗi lớn hơn 6 ký tự");
//					
//				}
//			}
//		
//		}
//		public static int inputAge() {
//				while(true) {
//					int age = inputInt("wrong input! hãy nhập vào số, vui lòng nhập lại :");
//					if (age <=0) {
//						System.out.println("wrong inputing! tuổi phải lớn hơn 0 , vui lòng nhập lại ");
//					} else {
//						return age;
//					}
//							
//				}
//		}
//		public static String  email(String errorMessage) {
//			while (true ) {
//				try {
//					String email = scanner.nextLine().toLowerCase().replaceAll("\\s+" , " ").trim();
//					if (!email.contains("@")) {
//						System.out.println(errorMessage);
//					} else {
//						return email;
//					}
//				} catch (Exception e) {
//				System.out.println(errorMessage);
//				}
//			}
//		}
//		public static String Password(String errorMessage) throws Exception  {
//				while (true) {
//					String password = ScannerUtils.inputString();
//					
//					if (password == null || password.length() < 6 || password.length() > 12) {
//						System.out.println(errorMessage);
//					}else {
//						boolean Strpass = false;
//						for (int i = 0; i < password.length(); i++) {
//							if (Character.isUpperCase(password.charAt(i)) == true) {
//								
//								Strpass = true;
//								break;
//							}
//						}
//						if (Strpass == true) {
//							return password;
//						} else {
//							System.out.println("bạn hãy nhập 1 ký tự viết hoa");
//						}
//					}
//				}
//		}
//}
//	

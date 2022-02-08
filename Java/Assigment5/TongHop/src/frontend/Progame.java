package frontend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import entity.Student;

public class Progame {
	 static Scanner scanner = new Scanner(System.in);
		public static void main(String[] args) {
	Map<String, Integer> chuoiPart = new HashMap<>();
	chuoiPart.put("05268", 14);
	chuoiPart.put("05268", 14);
	chuoiPart.put("Hà", 14);
	chuoiPart.put("0483", 14);
	chuoiPart.put("Tung", 14);
	
	 for (String i : chuoiPart.keySet()) {
		System.out.println("Key "  +  i  + " value " + chuoiPart.get(i));
	}
		}
//	public static void main(String[] args) {
////		Map<Integer, Float>soFloat = new HashMap<>();
////		soFloat.put(10, 80.f);
////		soFloat.put(10, 80.f);
////		soFloat.put(15, 147.f);
////		soFloat.put(15, 147.f);
////		soFloat.put(20, 10.f);
////		soFloat.put(147, 357.f);
////		soFloat.size();
////		System.out.println(soFloat);
//
//	int a = 10;
//	int b = 15;
//	int c = 20;
//	Scanner scanner = new Scanner(System.in);
//	System.out.println("nhập số đi : ");
//	a = scanner.nextInt();
//	b = scanner.nextInt();
//	c = scanner.nextInt();
//	if (a <=10) {
//		System.out.println("nhập sai rồi");
//		
//	} else if (b > 15) {
//		System.out.println("nhập lớn hơn số đầu rồi");
//	} else if (c > 20) {
//		System.out.println("chúc mừng đã nhập đúng");
//	
//	} else {
//		System.out.println(".....");
//	}
//		
////					System.out.println(a);
//			 }	
//			
//				
//		
////			System.out.println(n);
//	
	
}


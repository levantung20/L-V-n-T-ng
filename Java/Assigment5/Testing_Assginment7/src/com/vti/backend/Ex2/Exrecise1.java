package com.vti.backend.Ex2;

import java.util.Scanner;

import com.vti.enttity.Ex2.MyMath;

public class Exrecise1 {
		public static void main(String[] args) {
			MyMath math  = new MyMath();
			Scanner sc = new Scanner( System.in);
			System.out.println("Mời bạn nhập vào a : ");
			int a = sc.nextInt();
			System.out.println(math.sum(a));
					
		}
}

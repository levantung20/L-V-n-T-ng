package com.vti.backend;
// Question3
public class MyMath {
	public static void main(String[] args) {
		int result = MyMath.max(5, 7);
		System.out.println(result);

		int results = MyMath.min(10, 20);
		System.out.println(results);
		
		int tong = MyMath.sum(10, 30);
		System.out.println(tong);

	}

	private static int max(int a, int b) {
		if (a >= b) {
			return a;
		} else {
			return b;
		}
	}

	private static int min(int a, int b) {
		if (a <= b) {
			return a;
		} else {
			return b;
		}

	}
	private static int sum(int a, int b) {
		return a + b;
	}
}

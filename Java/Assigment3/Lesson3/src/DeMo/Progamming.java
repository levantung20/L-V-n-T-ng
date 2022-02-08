package DeMo;

import java.util.Scanner;

public class Progamming {
	public static final char SPACE = ' ';
	public static final char TAB  = '\t';
	public static final char BREAK_LINE = '\n';	
//	Bài 1: Hãy viết chương trình hàm tính tổng các chữ số của một số nguyên bất kỳ.
//	Ví dụ: Số  8545604 có tổng các chữ số là: 8+5+4+5+6+0+4= 32.	
//	public static void main(String[] args) {
//		int  nhap = 'a';
//	 int tong = tong(nhap);
//	 System.out.println(tong);
//	 
//	}
//	public static int tong(int nhap) {
//	int tong = 0;
//			do {
//				int d = nhap /10;
//				int c = nhap % 10;
//				tong = tong + c;
//				nhap = d;
//			} while (nhap % 10 !=0);
//			return tong;
//	}
	
//	Bài 2: Viết chương trình nhập vào một mảng số nguyên, viết hàm lấy ra số xuất hiện 
//	trong mảng nhiều hơn 1 lần
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao chuoi can dem :");
		String input = scanner.nextLine();
		int conut = countChars(input);
		System.out.println("so phan tu cua chuoi la : " + conut);
		scanner.close();
		
	}
	public static int countChars(String input) {
		if(input == null) {
			return 0;
		}
		int count = 0;
		int size = input.length();
		boolean notCount = true; 
		for(int i = 0; i < size; i++) {
			if(input.charAt(i) != SPACE && input.charAt(i) != TAB && input.charAt(i) != BREAK_LINE) {
				if(notCount == true) {
					count++;
					notCount = false;
				}
			}else {
				notCount = true;
			}
		}
		return count;
	}
	
	public static void main1(String[] args) {
		String ten1 = new String("minh anh");
		String ten2 = new String("minh anh");
		if (ten1 == ten2) {
			System.out.println("bằng nhau");
		} else {
				System.out.println("không bằng nhay");
		}
	}
}
	
//	Bài 3: Nhập một xâu ký tự. Đếm số từ của xâu ký tự đó. Thí dụ "   Trường    học  " có 2 từ.
//	public static void main(String[] args) {
//	String input = " 		Chao mung		cac thanh		vien		lop railway12"
//				+ "		\n cac ban		co khoe khong 		";
//	int count = countChars(input);
//	System.out.println("so phan tu cua chuoi la :" + count);
//		
//	}
//	public static int countChars(String input) {
//		if(input == null) {
//			return 0;
//		}
//		int count = 0;
//		int size = input.length();
//		boolean notCount = true;
//		for (int i = 0; i < size; i++) {
//			if(input.charAt(i) != SPACE && input.charAt(i)!= TAB && input.charAt(i) != BREAK_LINE) {
//				if(notCount == true) {
//					count++;
//						notCount = false;
//				}
//			}else{
//			notCount = true;
//			}
//		}
//		return 0;
//	}
	
	
//	Bài 4: Viết chương trình nhập một số nguyên dương n và thực hiện các chức năng sau:
//		a)	Liệt kê n số nguyên tố đầu tiên.
//		b)	Liệt kê n số Fibonaci đầu tiên. 
	
//	public static void main(String[] args) {
//		System.out.println("nhap n");
//		int n = nhap();
//		lietKeSNT(n);
//		int[] f = new int [n];
//		f[0] = 1; f[1] = 1;
//		int i =1;
//		System.out.println("Cac so Fibonanci nho hon "+n+ "La : \n 1");
//		while(f[i]<n) {
//			System.out.println(" " +f[i]);
//			i++;
//			f[i]= f[i-1] + f[i-2];
//		}
//		System.out.println("\n Co "+i+" so thoa man ");
//	}
//	public static int nhap() {
//		Scanner input = new Scanner(System.in);
//		boolean check = false;
//		int n = 0;
//		while (!check) {
//			System.out.println(" ");
//			try {
//				n = input.nextInt();
//				check = true;
//			} catch(Exception e ) {
//				System.out.println("moi ban nhap so!nhap lai di....");
//				input.nextLine();
//			}
//			
//		}
//		return (n);
//	}
//	public static boolean checkSNT(int n ) {
//		if(n>1) {
//			for(int i = 2; i <= Math.sqrt(n); i++) {
//				if(n%i==0) 
//					return false;
//			}
//			return true;
//		}
//		else return false;
//	}
//	public static void lietKeSNT(int n) {
//		int  i =1 ,count=0;
//		System.out.println("Cac so nguyen to nho hon "+n+" la : ");
//		while(i<n) {
//			if(checkSNT(i)) {
//				System.out.println(" " +i);
//				count++;
//			}
//			i++;
//		}
//		System.out.println("\n Co " +count+" so thoa man");
//	}
//	
	

	
		

			 



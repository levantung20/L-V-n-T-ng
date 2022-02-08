package DeMo;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Scanner;

public class Progamed {
	public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Mời bạn nhập vào a");
			int a = scanner.nextInt();
			System.out.println("Mời bạn nhập vào b ");
			int b = scanner.nextInt();
			System.out.println("Mời bạn nhập vào c ");
			int c = scanner.nextInt();
			giaiPhuongTring(a, b, c);
			scanner.close();
	}
	public static void giaiPhuongTring( int a , int b , int c ) {
		if (a == 0) {
		if (b == 0) {
		if (c == 0) {
			
		}	
			System.out.println("Phương trình vô nghiệm");
		}else {
			System.out.println("phương trình có một nghiệm x " + -(c/b));
		}
		return;
		}
		float delta =  b*b - 4 *a*c;
		float x1; 
		float x2;
		if (delta > 0) {
			x1 = (float)((-b + Math.sqrt(delta)) / (2 *a));
			x2 = (float)((-b - Math.sqrt(delta)) / (2 *a));
			System.out.println("Phương trình có 2 nghiệm : x1  = " +  x1  + " x2 = " + x2  );
		} else if (delta == 0) {
			System.out.println("phương trình  có một nghiệm : x = " + (-b/(2*a)));
		} else {
			System.out.println("Phương trình vô nghiệm");
		}
		
		
	}
	
}
//	public static void main(String[] args) {
//		int a = 1; 
//		int b = 2;
//		if(a == 1 && b == 2) {
//			
//		}
//		if(a == 1 || b ==3 ) {
//		
//		}
//		
//		for (int i = 100; i > 0; i= i -1) {
//			if(i %2 !=0) {
//				continue;
//			}
//			System.out.println(i);
//		}
//		

	// vòng lặp do while
//		int i = 0;
//		do {
//			System.out.println(i);
//			i = i + 2;
//		} while (i < 10);
//		
	// break

	// vòng lặp while
//		int  i = 0;
//		while ( i < 10) {
//			System.out.println(i);
//			i = i + 2; 
//		}

//		vòng lặp for 
//		int [] danhSachDiem = {9 , 7 , 8 , 6 , 9 , 7 , 10 ,8 , 6};

	// for each
//		for (int diem : danhSachDiem) {
//			System.out.println(diem);
//		}
//		
//		// for theo index;
//		for (int i =100; i < danhSachDiem.length; i++) {
//			if(i > 5) {
//			System.out.println(danhSachDiem);
//	}
//		

//		System.out.println("So phan tu mang: "  + danhSachDiem.length);
//		for (int i = 0; i < danhSachDiem.length; i++) {
//			System.out.println("Phan tu thu" + i + "la :" + danhSachDiem[i]);
//			
//		}

//		Switch...case
//		String ten = "dung";
//		switch (ten) {
//		case "Tham": 
//			System.out.println("day la ban tham ");
//			break;
//		case "luong": 
//			System.out.println("day la ban luong ");
//			break;
//		case "Tung": 
//			System.out.println("day la ban tung ");
//			break;
//			default:
//			System.out.println("ban nao k quen ");
//			break;
//		}
//		

//		vd:1
//		int index = 7;
//		switch (index) {
//		case 1: 
//			System.out.println("day la so 1 ");
//			break;
//		case 2: 
//			System.out.println("day la so 2 ");
//			break;
//		case 3: 
//			System.out.println("day la so 3 ");
//			break;
//		case 4: 
//			System.out.println("day la so 4 ");
//			break;
//		case 5: 
//			System.out.println("day la so 5 ");
//			break;
//		case 6: 
//			System.out.println("day la so 6 ");
//			break;
//			default:
//			System.out.println("đây là số khác từ 1-5");
//			break;
//		}

//	 if else
//		vd 2;
//		String hoTen = "Le Van Tung";
//		if(hoTen == "Le Van Tung") {
//			System.out.println("Hello world:" + hoTen);
//		} else{
//			 System.out.println("day khong phai la ban Tung " + hoTen);
//		}

//		vd 1;
//	public static void main(String[] args) {
//		int a = 20 , y = 10; 
//		if (a  > y) {
//			System.out.println("a lớn hơn y");
//		} else if (y > a ) {
//			System.out.println("y  lớn  hơn a");
//			
//		} else {
//			System.out.println("bằng nhau  ");
//		}

//		int index = 10;
//		switch (index) {
//		case 1: 	
//			System.out.println("đây là số 1 ");
//			break;
//			case 2 :
//			System.out.println("đây là số 2 ");
//			break;
//			case 3 : 
//				System.out.println("đây là số 5");
//				break;
//			case 10 : 
//				System.out.println("đây là số 10");
//				break;
//				default:
//					System.out.println("không có số nào ở trong phạm vi này là số 10 cả ");
//					break;
//				
//		}
//		
//	}
//		public static void main(String[] args) {
//			Scanner scanner = new Scanner(System.in);
//			
//			System.out.print("Mời bạn nhập vào một số ");
//			int a = scanner.nextInt();
//			System.out.println("bạn vừa nhập vào số " + a );
//			scanner.close();
//			
////		}
//	public static void main(String[] args) {
//					 int a = 3;  // ép kiểu từ float về số nguyên
//					 int b = 2;
//					 float c = (float)a/b;
//					 System.out.println(c);
//					 float soThuc = 25.0987f;
//					 int phanNguyen = (int) soThuc;
//					 System.out.println(phanNguyen);

		// ép kiểu từ chuổi sang kiểu số
		
//							 String chuoi = "1258423";
//							 int  chuoiToInt = Integer.parseInt(chuoi);
//							 int ketQua = chuoiToInt*2;
//							 System.out.println(ketQua);
		// ép kiểu từ kiểu chữ về chuỗi
		
//					int a = 12345;
//					String intToString = String.valueOf(a);
//					String congChuoi = intToString +  "Vân";
//					System.out.println(congChuoi);	
//			String ten1 = new String ("Vân");
//			String ten2 = new String ("Vân");
//			if (ten1.equals(ten2)) {
//				System.out.println("bằng nhau");
//			} else { 
//				System.out.println("không bằng nhau ");
//			}
		
		
////	}
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Mời bạn nhập vào n ");
//		int n = scanner.nextInt();
//		int giaiThua = tinhGiaiThua(n);
//		System.out.print("kết quả tính giai thừa " +  n +  "là " + giaiThua);
//		scanner.close();
//	}
//	
//	public static int tinhGiaiThua(int n ) {
//		int giaiThua = 1;
//		if (n == 0 || n ==1 ) {
//			giaiThua = n;
//			return n;
//		} else {
//			for (int i = 2; i <= n; i++) {
//				giaiThua = giaiThua*i;
//			}
//		}
//		return giaiThua;
//	}
//}
		
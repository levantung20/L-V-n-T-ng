package DeMo;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Progam {
	// config
	static int tiGiaDe = 70; 
	static float tiGiaDiem = 24.5f; 
	static int tiGiaDanhLo = 80;
	static	String username = "LeVanTung";
	static	float taiKhoan = 1000; // don vi 
	 
			static	Scanner scanner = new Scanner(System.in);
			static  Random random = new Random();
			
			//	random giải7
			 static int [] giai7 = new int [4];
			 static int [] giai6 = new int [3];
			 static int [] giai5 = new int [8];
			 static int [] giai4 = new int [4];
			 static int [] giai3 = new int [6];
			 static int [] giai2 = new int [2];
			 static int  giai1;
			 static int  giaiDacBiet ;
			 static boolean result;
			 
			 
			 // đề 
			 static int soDe;
			 static int soTien;
			 
			 // lô
			 static int soLo;
			 static int soDiem;
			 static int soNhay;
			
			 
		public static void main(String[] args) {
		System.out.println("Xin Chào " + username);
		System.out.println("tài Khoản của bạn hiện tại là : " + taiKhoan + "VND");
		
		while (true) {
		System.out.println("*================================================*");
			System.out.println("Mời bạn chọn chức năng\n " +
					 " 	1.Đánh đề\n" + 
					 "	2.Đánh Lô\n" +
					 "	3.Cắm sổ đỏ\n" + 
					 "	4.Thôi dừng không chơi nữa");
			
			
				
				System.out.println("Nhập:");
					int choose = scanner.nextInt();
					switch (choose) {
					case 1 :
						danhDe();
						break;
						
					case 2 :
						danhLo();
						break;
					case 3 :
						System.out.println("Bạn Lựa Chọn cắm sổ đỏ");
						break;
						
					case 4 :
						System.out.println("Hẹn gặp lại bạn lần sau !!!");
						return;
					
						default:
							System.out.println("bạn đã nhập sai,mời bạn nhập lại!!!");
							break;
					}
					}
		}
		
		public static void danhDe() {
			System.out.println("Mời khách hàng nhập số đề :");
			soDe = scanner.nextInt();
			
			System.out.println("và số tiền :");
			soTien = scanner.nextInt();
			
			System.out.println("Đã đến 6h, kết quả xổ số là: ");
			randomGiai();
			printGiai();
			checkDe();
			if(result) { 
				int soTienThangGiai = soTien *  tiGiaDe;
				taiKhoan += soTienThangGiai;
				System.out.println("Bạn vừa trúng!");
				System.out.println("Số Tiền trúng là :" + soTienThangGiai);
				System.out.println("Số dư hiện tại :" + taiKhoan);
			} else {
				taiKhoan -= soTien;
				System.out.println("Bạn vừa tạch!");
				System.out.println("Số dư hiện tại :" + taiKhoan);
			}
		}
		
		

			public static void danhLo() {
				System.out.println("Mời khách hàng nhập số lô :");
				soLo = scanner.nextInt();
				
				System.out.println("và số điểm :");
				soDiem = scanner.nextInt();
				
				System.out.println("Đã đến 6h, kết quả xổ số là: ");
				randomGiai();
				printGiai();
				checkLo();
			
				if(soNhay == 0) { 
					taiKhoan -= soDiem * tiGiaDiem;
					System.out.println("Bạn vừa tạch!");
					System.out.println("Số dư hiện tại :" + taiKhoan);
					
			
				} else {
					float soTienThangGiai = soDiem * (tiGiaDanhLo - tiGiaDiem) * soNhay;
					taiKhoan += soTienThangGiai;
					
					System.out.println("Bạn vừa Trúng" + soNhay + "Nhay");
					System.out.println("Số tiền trúng là : " + soTienThangGiai);
					System.out.println("Số dư hiện tại là: " + taiKhoan);
					
				}
		}
			
			
		public static void randomGiai() {

			//	random giải 7
			for (int i = 0; i < giai7.length; i++) {
				// ran dom từ 0 -> 99
				 giai7[i] = random.nextInt(100);
			}
			
			// random giai6
			for (int i  = 0; i < giai6.length; i++) {
				// random tu 0 -> 999
				giai6[i] = random.nextInt(1000);
			}
			
			// random giai5
			for (int i  = 0; i < giai5.length; i++) {
			giai5[i] = random.nextInt(10000);
			}
			
			// random giai4
			for (int i  = 0; i < giai4.length; i++) {
			giai4[i] = random.nextInt(100000);
		}
			// random giai3
			for (int i  = 0; i < giai3.length; i++) {
				giai3[i] = random.nextInt(100000);
		}
			// random giai 2
			for (int i  = 0; i < giai2.length; i++) {
				giai2[i] = random.nextInt(100000);
}
			//  ran dom giai 1 
				giai1= random.nextInt(100000);

				//  ran dom giai dac biet
					giaiDacBiet= random.nextInt(100000);
}
		
		public static void printGiai() { 

				for (int i : giai7) {
					System.out.println("Giải 7: " + String.format("%02d", i));
				}
				
				for (int i : giai6) {
					System.out.println("Giải 6: " + String.format("%03d", i)); 
				
		}
				for (int i : giai5) {
					System.out.println("Giải 5: "  + String.format("%04d", i));
				
		}
				for (int i : giai4) {
					System.out.println("Giải 4: " + String.format("%04d", i));
				
		}
				for (int i : giai3) {
					System.out.println("Giải 3: " +  String.format("%05d", i));
				
		}
				for (int i : giai2) {
					System.out.println("Giải 2: " + String.format("%05d", i));
		}
				// random giải 1
				System.out.println("Giải 1: " + String.format("%05d", giai1)); 
					// random giải 1
				System.out.println("Giải Đặc Biệt: " + String.format("%05d", giaiDacBiet));

} 
		
 		public static void  checkDe () {

			// Tách 2 số giải đặc biệt
			int haiSoCuoi = giaiDacBiet % 100;
			// ckeck giải Dac Biet
		
				if(soDe ==haiSoCuoi) { 
					result = true;
				} else {
					result  = false; 
			}
		}
 		
 		
 		public static void  checkLo () {
 			soNhay = 0;
 			
 			
 			// check giai 7 
 			for (int i : giai7) {
				if(soLo ==i) { 
					soNhay++;
			}
 			}
				// check giai 6 
	 			for (int i : giai6) {
	 				int haiSoCuoi = i % 100;
					if(soLo == haiSoCuoi) { 
						soNhay++;
				}
	 			}
					// check giai 5 
		 			for (int i : giai5) {
		 				int haiSoCuoi = i % 100;
						if(soLo == haiSoCuoi) { 
							soNhay++;
					}
		 			}
						// check giai 4
			 			for (int i : giai4) {
			 				int haiSoCuoi = i % 100;
							if(soLo == haiSoCuoi) { 
								soNhay++;
						}
				}

		// check giai 3 
			for (int i : giai3) {
				int haiSoCuoi = i % 100;
			if(soLo == haiSoCuoi) { 
				soNhay++;
		}
}
			// check giai 2 
 			for (int i : giai2) {
 				int haiSoCuoi = i % 100;
				if(soLo == haiSoCuoi) { 
					soNhay++;
			}
 			// check giai 1 
 			int haiSoCuoiGiai1 = giai1 % 100;
 			if (soLo == haiSoCuoiGiai1) {
 				soNhay++;
 			}
 				// check giai dac biet
 			int haiSoCuoiGiaiDacBiet = giaiDacBiet % 100;
 			if (soLo == haiSoCuoiGiaiDacBiet) {
 				soNhay++;
 			}
 			}
}
 			
}



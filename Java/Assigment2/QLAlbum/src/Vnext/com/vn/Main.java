package Vnext.com.vn;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
		static Scanner sc = new Scanner(System.in);
		static void nhapAlbum(Album ab) {
			System.out.print("Nhập mã CD: ");
			ab.setMaCD(sc.nextInt());
			sc.nextLine();
			System.out.print("nhập tên CD: ");
			ab.setTenCD(sc.nextLine());
			System.out.print("nhập tên ca sĩ : ");
			ab.setCaSy(sc.nextLine());
			System.out.print("nhập số lượng bài hát : ");
			ab.setSoBH(sc.nextInt());
			System.out.print("nhập giá thành :  ");
			ab.setGiaThanh(sc.nextFloat());
		}
		public static void main(String[] args) {
			Album alb [] = null;
			int a = 0, n = 0;
			boolean flag = true;
			do {
			     System.out.println("Bạn chọn làm gì? \n");
		            System.out.println("1.Nhập thông tin CD \n "
		 +
		                    "2.Xuất danh sách Album. \n"
		 + "3.Tính tổng giá thành \n "
		 + "4.Tổng số lượng CD  \n"
		 +
		                    "5.Sắp xếp giảm dần theo giá thành \n"
		+"6.Sắp xếp tăng dần theo tựa CD \n"
		+"Nhập số khác để thoát");
		            a = sc.nextInt();
									switch (a) {
									case 1:
										System.out.println("nhập số lượng CD : ");	
										n = sc.nextInt();
										alb = new Album[n];
										for (int i = 0; i < n; i++) {
											System.out.println("CD thứ " + (i + 1 ) + ": ");
											alb[i] = new Album();
											nhapAlbum(alb[i]);
										}
										
										break;
									case 2 : 
										System.out.printf("%-10s %-20s %-20s %-10s %-20s"  
												, "Mã CD " , " Tên CD" , " Tên Ca Sỹ " , "Số bài hát"  , "Giá thành");
										for (int i = 0; i < n; i++) {
											 alb[i].hienThiAlbum();
										}
										break;
										case 3 : 
											int tong = 0; 
										for(int i = 0; i < n; i ++ ) {
											tong += alb[i].getGiaThanh();
										}
										System.out.println(" " + "Tổng giá thành là : "+ tong);
										break;
										case 4 : 
											
									System.out.println("Tổng số lượng CD là : " + n);
									break;
										case 5:
											Album temp = alb[0];
											for (int i = 0; i< n - 1; i++) {
											for (int j = 0; j < n; j++) {
												if(alb[i].getGiaThanh() < alb[j].getGiaThanh()) {
													temp = alb[j];
													alb[j] = alb[i];
													alb[i] = temp;
												}
												}
											}
											System.out.println("Sắp xếp thành công!nhập 2 số điều kiện để kiểm tra !");
											break;
										case 6 : 
											temp = alb[0];
											for (int i = 0; i < n-1; i++) {
												for (int j = 0; j  < n; j++) {
													if (alb[i].getTenCD().compareTo(alb[j].getTenCD())>0) {
														temp = alb[j];
														alb[j] = alb[i];
														alb[i] = temp;
													}
												}
												
											}
											System.out.println("Sắp xếp thành công ! nhập 2 số điều kiện để kiểm tra !");
											break;
									default:
										System.out.println("Xin chào và hẹn gặp lại");
										flag  = false;
										break;
							}
			
			} while (flag);
		}
}

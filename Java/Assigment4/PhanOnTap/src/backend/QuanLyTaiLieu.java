package backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Sach;
import entity.ThuVien;

// Execrie5(Question40)
public class QuanLyTaiLieu {
		static Scanner scanner = new Scanner(System.in);
		static List<ThuVien> danhSachThuVien = new ArrayList<ThuVien>(); 

	public static void main(String[] args) {
		System.out.println("-------------------------------------------------");
		System.out.println("Chào Mừng bạn đến chương trình quản lý tài liệu");
		int idChonMuc = 0;
		while (idChonMuc !=5) {
			System.out.println("1.Thêm  mới tài liệu");
			System.out.println("2.Xóa tài liệu theo mã tìa liệu");
			System.out.println("3.Hiện Thị thông tin");
			System.out.println("4.Tìm Kiếm tài liệu");
			System.out.println("5.Thoát khỏi chương trình ");
			System.out.println("Mời bạn nhập vào chức năng : ");
			idChonMuc = scanner.nextInt();
			
			switch (idChonMuc) {
			case 1:
				themMoiTaiLieu();
				break;
				
			case 2 : 
				
				
				break;
				
			case 3 :
				
				break;
				
			case 4 : 
				
				break;
				
			case 5 : 
			default:
				break;
			}
		}
	}
	
	
	public static void themMoiTaiLieu() {
			System.out.println("1. mã sách");
			System.out.println("2.tenNhaSanXuat");
			System.out.println("3.soBanPhatHanh");
			int LoaiTaiLieu = scanner.nextInt();
			switch (LoaiTaiLieu) {
			case 1 :
				nhapMaTaiLieu();
				break;
			case 2 :
				
			break;
			case 3 :
				
				break;
			}
	}
	public static void nhapMaTaiLieu() {
			Scanner scanner = new Scanner(System.in);
			 Sach sach = new Sach();
			
	}
	
	}


package lesson4;

import java.util.Scanner;

public class QuanLy {
	public static void main(String[] args) {
		System.out.println("*/-------------Chương trình quản lý tài liệu sách ----------------*/");
		
		int chonmuc;
		Scanner scanner = new Scanner(System.in);
		chonmuc = scanner.nextInt();
		
		switch (chonmuc) {
		case 1: {
			System.out.println("1.Thêm mới tài liệu:Sách , tạp chí , vở, báo.");
			break;
		}
		
		case 2 : 
			System.out.println("2.Xóa tài liệu theo mã tài liệu");
			break;
		case 3 : 
			System.out.println("3.Hiện Thị Thông tin về tài liệu");
			break;
		case 4 : 
			System.out.println("4.Tìm kiếm tài liệu theo loại:Sách, tạp chí, báo.");
			break;
		default:
			System.out.println("5.Thoát");
			break;
		}
		scanner.close();
		
	}

	public static void themTaiLieu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào và chọn tài liệu");
		String tenLuaChon = scanner.nextLine();
		switch (tenLuaChon) {
		case "sach":
			Sach sach = new Sach();
			System.out.println("ma sach");
			String maSach  = scanner.nextLine();
			Sach.setmaTaiLieu(maSach);
			System.out.println("nhập tên nhà sản xuất bản");
			String tenNhaSanXuat = scanner.nextLine();
			sach.settenNhaXanSuat(tennhaxuatban);
			System.out.println("nhập số bản phát hành");
			int sophathanh = scanner.nextInt();
			sach.setSoBanPhatHanh(sophathanh);
			System.out.println("ten tac gia");
			String tentacgia = scanner.nextLine();
			sach.setTentacgia(tentacgia);
			System.out.println(" so trang");
			int sotrang = scanner.nextInt();
			sach.setSotrang(sotrang);
			break;
		case "tap chi":
			TapChi tapChi = new TapChi();
		default:
			break;
		}
		
		
	}
	}

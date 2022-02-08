package com.Vnext.student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class QuanLyHocSinh {
	static Scanner scanner = new Scanner(System.in);
	static List<HocSinh> danhSachHocSinh = new ArrayList<HocSinh>();

	public static void main(String[] args) {

		System.out.println("=========================***==========================");
		System.out.println("Chào Mừng bạn đến với chương trình quản lý học sinh của chúng tôi!!!");

		int idChucNang = 0;
		while (idChucNang != 6) {
			System.out.println("1.Thêm Học Sinh");
			System.out.println("2.Hiện Thị Danh Sách Học Sinh");
			System.out.println("3.Tìm Kiếm theo Họ Tên Học Sinh");
			System.out.println("4. Xoá Học Sinh Theo Tên");
			System.out.println("5.Sắp xếp theo tên của Học Sinh");
			System.out.println("6.Thoát khỏi Chương Trình");
			System.out.println("Mời bạn chọn chức năng");
			idChucNang = scanner.nextInt();

			switch (idChucNang) {
			case 1:
				themMoiHocSinh();
				break;
			case 2:
				hienThi();
				break;
			case 3:
				timKiem();
				break;
			case 4:
				xoaTheoTen();
				break;
//				case 5: 
//					sapXep();
//					break;
			case 6:
				System.out.println("Cảm ơn bạn đã tham gia chương trình!!!Xin Cảm ơn và hẹn gặp lại");
				break;
			default:
				break;
			}
		}

	}

	public static void themMoiHocSinh() {
		System.out.println("1.HocSinhTruongChuyen");
		System.out.println("2.HocSinhTruongNoiTru");
		System.out.println("3.HocSinhTruongGDTX");
		int LoaiHocSinh = scanner.nextInt();
		switch (LoaiHocSinh) {
		
		case 1:
			themMoiHocSinhTruongChuyen();
			break;
		case 2:
			themMoiHocSinhTruongNoiTru();
			break;
		case 3:
			themMoiHocSinhTruongGDTX();
			break;

		default:
			break;
		}
	}

	public static void themMoiHocSinhTruongChuyen() {
		Scanner scanner = new Scanner(System.in);
		HocSinhTruongChuyen hocSinhTruongChuyen = new HocSinhTruongChuyen();
		System.out.println("Mời bạn nhập vào tên học sinh:");
		String hoTen = scanner.nextLine();
		System.out.println("Mời bạn nhập vào giới tính của học sinh:");
		String gioiTinh = scanner.nextLine();
		Gender gender = Gender.fromValue(gioiTinh);

		System.out.println("Mời bạn nhập vào tên trường của học sinh: ");
		String tenTruong = scanner.nextLine();

		System.out.println("Mời bạn nhập vào địa chỉ học sinh :");
		String diaChi = scanner.nextLine();

		System.out.println("Mời bạn nhập vào email học sinh");
		String email = scanner.nextLine();

		System.out.println("Mời bạn điền môn chuyên của học sinh : ");
		String MonChuyen = scanner.nextLine();

		System.out.println("Mời bạn nhập mã học sinh: ");
		int maHocSinh = scanner.nextInt();

		hocSinhTruongChuyen.setTenHocSinh(hoTen);
		hocSinhTruongChuyen.setGioiTinh(gender);
		hocSinhTruongChuyen.setTenTruong(tenTruong);
		hocSinhTruongChuyen.setDiaChi(diaChi);
		hocSinhTruongChuyen.setEmail(email);
		hocSinhTruongChuyen.setMahocSinh(maHocSinh);
		hocSinhTruongChuyen.setMonChuyen(MonChuyen);
		danhSachHocSinh.add(hocSinhTruongChuyen);

	}

	public static void themMoiHocSinhTruongNoiTru() {
		Scanner scanner = new Scanner(System.in);
		HocSinhTruongNoiTru hocSinhTruongNoiTru = new HocSinhTruongNoiTru();
		System.out.println("Mời bạn nhập vào tên : ");
		String hoTen = scanner.nextLine();
		System.out.println("Mời bạn nhập vào giới tính học sinh : ");
		String gioiTinh = scanner.nextLine();
		Gender gender = Gender.fromValue(gioiTinh);

		System.out.println("Mời bạn nhập vào tên trường nội trú : ");
		String tenTruongNoiTru = scanner.nextLine();

		System.out.println("Mời bạn nhập vào địa chỉ học sinh : ");
		String diaChi = scanner.nextLine();

		System.out.println("Mời bạn nhập vào email của học sinh : ");
		String email = scanner.nextLine();

		System.out.println("Mời bạn nhập vào mã học sinh");
		int maHocSinh = scanner.nextInt();

		System.out.println("Mời phụ huynh nhập số tiền nội trú là : ");
		float tienNoiTru = scanner.nextFloat();

		hocSinhTruongNoiTru.setTenHocSinh(hoTen);
		hocSinhTruongNoiTru.setGioiTinh(gender);
		hocSinhTruongNoiTru.setTenTruong(tenTruongNoiTru);
		hocSinhTruongNoiTru.setDiaChi(diaChi);
		hocSinhTruongNoiTru.setEmail(email);
		hocSinhTruongNoiTru.setMahocSinh(maHocSinh);
		hocSinhTruongNoiTru.setTienNoiTru(tienNoiTru);
		danhSachHocSinh.add(hocSinhTruongNoiTru);

	}

	public static void themMoiHocSinhTruongGDTX() {
		Scanner scanner = new Scanner(System.in);
		HocSinhTruongGDTX hocSinhTruongGDTX = new HocSinhTruongGDTX();

		System.out.println("Mời bạn nhập tên học sinh : ");
		String hoTen = scanner.nextLine();
		System.out.println("Mời bạn nhập vào giới tính của học sinh : ");
		String gioiTinh = scanner.nextLine();
		Gender gender = Gender.fromValue(gioiTinh);

		System.out.println("Mời bạn nhập vào tên trường Giáo Dục Thường Xuyên : ");
		String tenTruongGDTX = scanner.nextLine();

		System.out.println("Mời bạn nhập vào địa chỉ học sinh : ");
		String diaChi = scanner.nextLine();

		System.out.println("Mời bạn nhập vào email của học sinh : ");
		String email = scanner.nextLine();

		System.out.println("Mời bạn nhập vào mã học sinh : ");
		int maHocSinh = scanner.nextInt();

		System.out.println("Mời bạn thông báo số năm học sinh bị đúp : ");
		int soNamHocLai = scanner.nextInt();

		hocSinhTruongGDTX.setTenHocSinh(hoTen);
		hocSinhTruongGDTX.setGioiTinh(gender);
		hocSinhTruongGDTX.setTenTruong(tenTruongGDTX);
		hocSinhTruongGDTX.setDiaChi(diaChi);
		hocSinhTruongGDTX.setEmail(email);
		hocSinhTruongGDTX.setMahocSinh(maHocSinh);
		hocSinhTruongGDTX.setSoNamHocLai(soNamHocLai);
		danhSachHocSinh.add(hocSinhTruongGDTX);
	}

	public static void hienThi() {
		System.out.println("thông tin học sinh : ");
		for (HocSinh hocSinh : danhSachHocSinh) {
			System.out.println(hocSinh);
		}
	}

	public static void timKiem() {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhập tên học sinh cần tìm : ");
		String hoTen = sc.nextLine();
		if (hoTen == null || hoTen.equals("")) {
			System.out.println("Không có học sinh nào không có họ  tên ");
		} else {
			boolean timThay = false;
			for (HocSinh hocSinh : danhSachHocSinh) {
				if (hocSinh.tenHocSinh.contains(hoTen)) {
					System.out.println(hocSinh);
					timThay = true;
				}
			}
			if (!timThay) {
				System.out.println("không có học sinh có tên là : " + hoTen);
			}
		}

	}

	public static void xoaTheoTen() {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhập tên học sinh cần xóa : ");
		String hoTen = sc.nextLine();
		if (hoTen == null || hoTen.equals(" ")) {
			System.out.println("không có  học sinh nào là không có họ tên cả :");

		} else {
			List<HocSinh> danhSachXoa = new ArrayList<HocSinh>();
			for (HocSinh hocSinh : danhSachHocSinh) {
				if (hocSinh.tenHocSinh.contains(hoTen)) {
					danhSachXoa.add(hocSinh);
				}
			}
			if (danhSachXoa.size() > 0) {
				danhSachHocSinh.removeAll(danhSachXoa);
				System.out.println("Bạn đã xóa tất cả những người có tên là : " + hoTen);
			} else {
				System.out.println("không tìm thấy tên học sinh cần xóa có tên  : " + hoTen);
				xoaTheoTen();
			}

		}
	}
	public static void sapXep() {
			danhSachHocSinh.sort(Comparator.comparing(HocSinh::getTenHocSinh));
			System.out.println("Thông tin học sinh : ");
			for (HocSinh hocSinh : danhSachHocSinh) {
				System.out.println(hocSinh);
			}
		}
}

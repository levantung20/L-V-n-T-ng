package vti.com.qlcb;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class QuanLyCanBo {
	static Scanner scanner = new Scanner(System.in);
	static List<CanBo> danhSachCanBo = new ArrayList<CanBo>();

	public static void main(String[] args) {
		System.out.println("------------------------ * * * ---------------------------");
		System.out.println("Chao mung ban den voi he thong phan mem quan ly can bo!!");
		int idChucNang = 0;
		while (idChucNang != 6) {
			System.out.println("1. Them moi can bo");
			System.out.println("2. Tìm kiếm theo họ tên");
			System.out.println("3. Hiện thị thông tin về danh sách các cán bộ");
			System.out.println("4. Nhập vào tên của cán bộ và delete ");
			System.out.println("5. Sap xep theo ten");
			System.out.println("6. Thoat chuong trinh");
			System.out.print("Moi ban nhap vao chuc nang: ");
			idChucNang = scanner.nextInt();

			switch (idChucNang) {
			case 1:
				themMoiCanBo();
				break;
			case 2:
				timKiem();
				break;
			case 3:
				hienThiThongTin();
				break;
			case 4:
				xoaTheoTen();
				break;
			case 5:
				sapXepTheoTen();
				break;
			case 6:
				System.out.println("Cam on ban da su dung dich vu cua chung toi, xin chao va hen gap lai !!!!");
				break;
			default:
				break;
			}
		}
	}

	public static void themMoiCanBo() {
		System.out.println("1. Cong Nhan");
		System.out.println("2. Ky Su");
		System.out.println("3. Nhan vien van phong");
		System.out.print("Moi ban chon loai can bo: ");
		int loaiCanBo = scanner.nextInt();
		switch (loaiCanBo) {
		case 1:
			themMoiCongNhan();
			break;
		case 2:
			themMoiKySu();
			break;
		case 3:
			themMoiNhanVienVanPhong();
			break;
		default:
			break;
		}
	}
	public static void themMoiCongNhan() {
		Scanner sc = new Scanner(System.in);
		CongNhan congNhan = new CongNhan();
		System.out.println("Moi ban nhap vao ten cong nhan: ");
		String hoTen = sc.nextLine();
		System.out.println("Moi ban nhap vao gioi tinh cong nhan: ");
		String gioiTinh = sc.nextLine();
		Gender gender = Gender.fromValue(gioiTinh);
		
		System.out.println("Moi ban nhap vao dia chi cong nhan: ");
		String diaChi = sc.nextLine();
		
		System.out.println("Moi ban nhap vao cap bac cong nhan: ");
		String capBac = sc.nextLine();
		
		System.out.println("Moi ban nhap vao tuoi cong nhan: ");
		int tuoi = sc.nextInt();
		
		congNhan.setHoTen(hoTen);
		congNhan.setGioiTinh(gender);
		congNhan.setDiaChi(diaChi);
		congNhan.setCapBac(capBac);
		congNhan.setTuoi(tuoi);
		danhSachCanBo.add(congNhan);
	}
	
	public static void themMoiKySu() {
		Scanner sc = new Scanner(System.in);
		KySu kySu = new KySu();
		System.out.println("Moi ban nhap vao ten ky su: ");
		String hoTen = sc.nextLine();
		System.out.println("Moi ban nhap vao gioi tinh ky su: ");
		String gioiTinh = sc.nextLine();
		Gender gender = Gender.fromValue(gioiTinh);
		
		System.out.println("Moi ban nhap vao dia chi ky su: ");
		String diaChi = sc.nextLine();
		
		System.out.println("Moi ban nhap vao chuyen nganh ky su: ");
		String chuyenNganh = sc.nextLine();
		
		System.out.println("Moi ban nhap vao tuoi ky su: ");
		int tuoi = sc.nextInt();
		
		kySu.setHoTen(hoTen);
		kySu.setGioiTinh(gender);
		kySu.setDiaChi(diaChi);
		kySu.setChuyenNganh(chuyenNganh);
		kySu.setTuoi(tuoi);
		danhSachCanBo.add(kySu);
	}
	
	public static void themMoiNhanVienVanPhong() {
		Scanner sc = new Scanner(System.in);
		NhanVienVanPhong nhanVienVanPhong = new NhanVienVanPhong();
		System.out.println("Moi ban nhap vao ten nhan vien: ");
		String hoTen = sc.nextLine();
		System.out.println("Moi ban nhap vao gioi tinh nhan vien: ");
		String gioiTinh = sc.nextLine();
		Gender gender = Gender.fromValue(gioiTinh);
		
		System.out.println("Moi ban nhap vao dia chi nhan vien: ");
		String diaChi = sc.nextLine();
		
		System.out.println("Moi ban nhap vao cong viec nhan vien: ");
		String congViec = sc.nextLine();
		
		System.out.println("Moi ban nhap vao tuoi nhan vien: ");
		int tuoi = sc.nextInt();
		
		nhanVienVanPhong.setHoTen(hoTen);
		nhanVienVanPhong.setGioiTinh(gender);
		nhanVienVanPhong.setDiaChi(diaChi);
		nhanVienVanPhong.setCongViec(congViec);
		nhanVienVanPhong.setTuoi(tuoi);
		danhSachCanBo.add(nhanVienVanPhong);
	}
	
	public static void hienThiThongTin() {
		System.out.println("Thong tin can bo: ");
		for (CanBo canBo : danhSachCanBo) {
			System.out.println(canBo);
		}
	}
	
	public static void timKiem() {
		Scanner sc  = new Scanner(System.in);
		System.out.println("Nhap ten can bo can tim kiem: ");
		String hoTen =sc.nextLine();
		if(hoTen == null || hoTen.equals("")) {
			System.out.println("Khong co can bo nao khong co ho ten");
		} else {
			boolean timThay = false;
			for (CanBo canBo : danhSachCanBo) {
				if(canBo.hoTen.contains(hoTen)) {
					System.out.println(canBo);
					timThay = true;
				}
			}
			if(!timThay) {
				System.out.println("Khong co can bo nao co ten la: " + hoTen);
			}
		}
	}
	
	public static void xoaTheoTen() {
		Scanner sc  = new Scanner(System.in);
		System.out.println("Nhap ten can bo can xoa: ");
		String hoTen =sc.nextLine();
		if(hoTen == null || hoTen.equals("")) {
			System.out.println("Khong co can bo nao khong co ho ten");
		} else {
			List<CanBo> danhSachXoa = new ArrayList<CanBo>();
			for (CanBo canBo : danhSachCanBo) {
				if(canBo.hoTen.equals(hoTen)) {
					danhSachXoa.add(canBo);
				}
			}
			if(danhSachXoa.size() > 0) {
				danhSachCanBo.removeAll(danhSachXoa);
				System.out.println("Ban da xoa tat ca nhung nguoi co ten: " + hoTen);
			} else {
				System.out.println("Khong tim thay can bo can xoa co ten: " + hoTen);
				xoaTheoTen();
			}
		}
	}
	
	public static void sapXepTheoTen() {
		danhSachCanBo.sort(Comparator.comparing(CanBo::getHoTen));
		System.out.println("Thong tin can bo: ");
		for (CanBo canBo : danhSachCanBo) {
			System.out.println(canBo);
		}
	}

}

package com.vti.backend.Ex5;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.vti.Entity.Ex5.CanBo;
import com.vti.Entity.Ex5.CongNhan;
import com.vti.Entity.Ex5.Gender;
import com.vti.Entity.Ex5.KySu;
import com.vti.Entity.Ex5.NhanVien;

public class Exercise5 {
			static Scanner scanner = new Scanner(System.in);
			static List<CanBo> danhSachCanBo = new ArrayList<CanBo>();
	
		public static void main(String[] args) {
			System.out.println("-------------------------------******---------------------------");
			System.out.println("Chao mung ban den voi he thong phan mem quan ly can bo!!!");
			int idChucNang = 0;
			while (idChucNang != 6) {
				System.out.println("1.Thêm mới cán bộ");
				System.out.println("2.Tìm Kiếm theo họ tên");
				System.out.println("3.Hiện Thị Thông tin về danh sách các bộ");
				System.out.println("4.Nhập vào tên của cán bộ  và delete");
				System.out.println("5. Sắp xếp theo tên");
				System.out.println("6.Thoát chương trình ");
				idChucNang = scanner.nextInt();
				
				switch (idChucNang) {
				case 1: 
					themMoiCanBo();
					break;
					case 2 :
						TimKiem();
						break;
						
					case 3 : 
						 hienThiThongTin();
						break;
						
					case 4 : 
						xoaTheoTen();
						break;
						
					case 5 : 
						sapXepTheoTen();
						break;
						
					case 6 : 
						System.out.println("Cảm ơn bạn đã sử dụng dịch vụ này!!!Xin Cảm Ơn");
						break;
				default:
					break;
				}
			}
		}
		public static void themMoiCanBo() {
			System.out.println("1.Cong Nhan");
			System.out.println("2. KySu");
			System.out.println("3. nhan vien");
			System.out.println("Mời bạn chọn :");
			int loaiCanBo = scanner.nextInt();
			switch (loaiCanBo) {
			case 1: 
				themMoiCongNhan();
				break;
				
			case 2 : 
				themMoiKySu();
				break;
				
			case 3 : 
				themMoiNhanVien();
				break;
				default:
					break;
			}
		
			}
		public static void themMoiCongNhan() {
			Scanner sc = new Scanner( System.in);
			CongNhan congNhan = new CongNhan();
			System.out.println("Moi ban nhap vao ten cong nhan : ");
			String hoTen = sc.nextLine();
			System.out.println("Moi ban nhap vao gioi tinh cua cong nhan : ");
			String gioiTinh = sc.nextLine();
			Gender gender = Gender.fromValue(gioiTinh);
			
			System.out.println("Moi ban nhap vao dia chi cong nhan : ");
			String diaChi = sc.nextLine();
			
			System.out.println("Moi ban nhap vao cap bac cong nhan :  ");
			String capBac = sc.nextLine();
			
			System.out.println("Moi ban nhap vao tuoi cong nhan :  ");
			int tuoi = sc.nextInt();
			
			congNhan.setHoTen(hoTen);
			congNhan.setGioiTinh(gender);
			congNhan.setDiaChi(diaChi);
			congNhan.setCapBap(capBac);
			congNhan.setTuoi(tuoi);
			danhSachCanBo.add(congNhan);
		}
		public static void themMoiKySu() {
			Scanner sc = new Scanner(System.in);
			KySu kySu = new KySu();
			System.out.println("Moi ban nhap vao ten ky su : ");
			String hoTen = sc.nextLine();
			
			System.out.println("Moi ban nhap vao gioi tinh ky su : ");
			String gioiTinh = sc.nextLine();
			Gender gender = Gender.fromValue(gioiTinh);
			
			System.out.println("Moi ban nhap vao dia chi ky su : ");
			String diaChi = sc.nextLine();
			
			System.out.println("Moi ban nhap vao chuyen nganh ky su : ");
			String NganhDaoTao = sc.nextLine();
			
			System.out.println("Moi ban nhap vao tuoi ky su ");
			int tuoi = sc.nextInt();
			
			kySu.setHoTen(hoTen);
			kySu.setGioiTinh(gender);
			kySu.setDiaChi(diaChi);
			kySu.setNganhDaoTao(NganhDaoTao);
			kySu.setTuoi(tuoi);
			danhSachCanBo.add(kySu);
			
		}
		public static void themMoiNhanVien() {
				Scanner sc = new Scanner(System.in);
				NhanVien nhanvien =  new NhanVien();
				System.out.println("Moi ban nhap vao ten cua nhan vien  : ");
				String hoTen = sc.nextLine();
				
				System.out.println("Moi ban nhap gioi tinh cua nhan vien : ");
				String gioiTinh = sc.nextLine();
				Gender gender = Gender.fromValue(gioiTinh);
				
				System.out.println("Moi ban nhap vao dia chi cua nhan  vien : ");
				String diaChi = sc.nextLine();
				
				System.out.println("Moi ban nhap vao cong viec cua nhan vien : ");
				String congViec = sc.nextLine();
				
				System.out.println("Moi ban nhap vao tuoi nhan vien : ");
				int tuoi = sc.nextInt();
				
				nhanvien.setHoTen(hoTen);
				nhanvien.setGioiTinh(gender);
				nhanvien.setDiaChi(diaChi);
				nhanvien.setCongViec(congViec);
				nhanvien.setTuoi(tuoi);
				danhSachCanBo.add(nhanvien);	
		}	
		public static void TimKiem() {
			Scanner sc = new Scanner(System.in);
			System.out.println("nhap ten can bo can tim kiem ");
			String hoTen = sc.nextLine();
			if (hoTen == null || hoTen.equals(" ")) {
				System.out.println(" khong co can bo nao khong co  ho ten ");
			} else {
				boolean timThay = false;
				for (CanBo canBo : danhSachCanBo) {
					if (canBo.hoTen.contains(hoTen)) {
						System.out.println(canBo);
						timThay = true;
					}
				}
				if (!timThay) {
					System.out.println("Khong co can bo nao co ten la  : " + hoTen);
				}
			}
		}
		
		public static void hienThiThongTin() {
			System.out.println("Thong tin can bo : ");
			for (CanBo canBo : danhSachCanBo) {
				System.out.println(canBo);
			}
		}
		
		public static void xoaTheoTen() {
			Scanner sc = new Scanner(System.in);
			System.out.println("nhap ten can xoa");
			String hoTen = sc.nextLine();
			if (hoTen == null || hoTen.equals(" ")) {
				System.out.println("khong co can bo nao khong co ho ten ");
			} else {
				List<CanBo> danhSachXoa = new ArrayList<CanBo>();
				for (CanBo canBo : danhSachCanBo) {
					if (canBo.hoTen.equals(hoTen)) {
						danhSachXoa.add(canBo);
		
					}
				}
				if (danhSachXoa.size() >0) {
					danhSachCanBo.removeAll(danhSachXoa);
					System.out.println("Ban da xoa tat ca nhung nguoi co ten : " + hoTen);
					
				} else {
					System.out.println("khong tim thay can bo can xoa co ten : " + hoTen);
					
				}
			}
		}
		public static void sapXepTheoTen() {
			danhSachCanBo.sort(Comparator.comparing(CanBo::getHoTen));
			System.out.println(" Thong tin can bo :");
			for (CanBo canBo : danhSachCanBo) {
				System.out.println(canBo);
			}
		}
		}

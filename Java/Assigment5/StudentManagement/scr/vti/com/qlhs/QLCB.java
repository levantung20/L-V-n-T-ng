package vti.com.qlhs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entitye.CanBo;
import entitye.CongNhan;
import entitye.Gender;
import entitye.KySu;
import entitye.NhanVienVanPhong;

public class QLCB {
	static Scanner scanner = new Scanner(System.in);
	static List<CanBo> danhSachCanBo = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("--------------*****------------");
		System.out.println("Chào mừng bạn đến với chương trình quản lý cán bộ!!!!");
		int idchucNang = 0;
		while (idchucNang != 5) {
			System.out.println("1.Thêm mới cán bộ");
			System.out.println("2.Tìm Kiếm theo họ Tên");
			System.out.println("3.Hiện Thị thông tin về danh sách cán bộ");
			System.out.println("4.Nhập vào tên cán bộ và delete");
			System.out.println("5.Thoát Chương Trình");
			System.out.println("Mời bạn chọn chức năng");
			idchucNang = scanner.nextInt();

			switch (idchucNang) {
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
				System.out.println("Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi , xin chào và hẹn gặp lại!!!");
				break;

			default:
				break;
			}
		}
	}

	public static void themMoiCanBo() {
		System.out.println("1.Công nhân");
		System.out.println("2.Ky Su");
		System.out.println("3.Nhân viên văn phòng");
		System.out.println("Mời bạn chọn loại cán bộ");
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
		CongNhan congnhan = new CongNhan();
		System.out.println("Mời bạn nhập tên công nhân : ");
		String hoten = sc.nextLine();

		System.out.println("Mời bạn nhập vào giới tính");
		String gioiTinh = sc.nextLine();
		Gender gender = Gender.fromValue(gioiTinh);

		System.out.println("Mời bạn nhập vào địa chỉ ");
		String diachi = sc.nextLine();

		System.out.println("Mời bạn nhập vào cấp bậc ");
		String capBac = sc.nextLine();

		System.out.println("Mời bạn nhập tuổi của công nhân ");
		int tuoi = sc.nextInt();

		congnhan.setHoTen(hoten);
		congnhan.setGioiTinh(gender);
		congnhan.setDiaChi(diachi);
		congnhan.setCapBac(capBac);
		congnhan.setTuoi(tuoi);
		danhSachCanBo.add(congnhan);

	}

	public static void themMoiKySu() {
		Scanner sc = new Scanner(System.in);
		KySu kysu = new KySu();
		System.out.println("Mời bạn nhập tên kỹ sư : ");
		String hoten = sc.nextLine();

		System.out.println("Mời bạn nhập vào giới tính");
		String gioiTinh = sc.nextLine();
		Gender gender = Gender.fromValue(gioiTinh);

		System.out.println("Mời bạn nhập vào địa chỉ ");
		String diachi = sc.nextLine();

		System.out.println("Mời bạn nhập vào chuyên ngành kỹ sư ");
		String chuyenNganh = sc.nextLine();

		System.out.println("Mời bạn nhập tuổi của kỹ sư ");
		int tuoi = sc.nextInt();

		kysu.setHoTen(hoten);
		kysu.setGioiTinh(gender);
		kysu.setDiaChi(diachi);
		kysu.setChuyenNganh(chuyenNganh);
		kysu.setTuoi(tuoi);
		danhSachCanBo.add(kysu);

	}

	public static void themMoiNhanVienVanPhong() {
		Scanner sc = new Scanner(System.in);
		NhanVienVanPhong nhanVienVanPhong = new NhanVienVanPhong();
		System.out.println("Mời bạn nhập tên nhân viên : ");
		String hoten = sc.nextLine();

		System.out.println("Mời bạn nhập vào giới tính nhân viên");
		String gioiTinh = sc.nextLine();
		Gender gender = Gender.fromValue(gioiTinh);

		System.out.println("Mời bạn nhập vào địa chỉ nhân viên ");
		String diachi = sc.nextLine();

		System.out.println("Mời bạn nhập vào công việc của nhân viên ");
		String congViec = sc.nextLine();

		System.out.println("Mời bạn nhập tuổi của nhân viên ");
		int tuoi = sc.nextInt();

		nhanVienVanPhong.setHoTen(hoten);
		nhanVienVanPhong.setGioiTinh(gender);
		nhanVienVanPhong.setDiaChi(diachi);
		nhanVienVanPhong.setCongViec(congViec);
		nhanVienVanPhong.setTuoi(tuoi);
		danhSachCanBo.add(nhanVienVanPhong);

	}

	public static void hienThiThongTin() {
		System.out.println("Thông tin cán bộ  : ");
		for (CanBo canBo : danhSachCanBo) {
			System.out.println(canBo);
		}
	}

	public static void timKiem() {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhập tên cán bộ cần tìm :  ");
		String hoTen = sc.nextLine();
		if (hoTen == null || hoTen.equals("")) {
			System.out.println("không có cán bộ nào không có họ tên");
		} else {
			boolean timThay = false;
			for (CanBo canBo : danhSachCanBo) {
				if (canBo.hoTen.contains(hoTen)) {
					System.out.println(canBo);
					timThay = true;
				}
			}
			if (!timThay) {
				System.out.println("không có cán bộ nào có tên là " + hoTen);
			}
		}
	}

	public static void xoaTheoTen() {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhập tên cán bộ cần xóa :  ");
		String hoTen = sc.nextLine();
		if (hoTen == null || hoTen.equals("")) {
			System.out.println("không có cán bộ nào không có họ tên");
		} else {
			List<CanBo> danhSachXoa = new ArrayList<>();
			for (CanBo canBo : danhSachCanBo) {
				if (canBo.hoTen.equals(hoTen)) {
					danhSachXoa.add(canBo);
				}
			}
			if (danhSachXoa.size() > 0) {
				danhSachCanBo.removeAll(danhSachXoa);
				System.out.println("Bạn đã xóa tất cả những người có tên " + hoTen);
			} else {
				System.out.println("không tìm thấy cán bộ cần xóa có tên là : ");
				xoaTheoTen();
			}

		}
	}
}

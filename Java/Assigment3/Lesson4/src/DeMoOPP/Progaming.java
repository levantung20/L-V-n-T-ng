package DeMoOPP;

public class Progaming {
	public static void main(String[] args) {

		Bank b = new Bank();
		int tongTien1 = b.tinhTongTien(20, 40);
		int tongTien2 = b.tinhTongTien(50, 147, 358);
		int tongTien3 = b.tinhTongTien(258, 369, 3024, 258);
		int tongTien = tongTien1 + tongTien2 + tongTien3;
		System.out.println("Tong tien 1 " + tongTien1);
		System.out.println("Tong tien 2 " + tongTien2);
		System.out.println("Tong tien 3 " + tongTien3);
		System.out.println("Tong tien cua 3 thang la  " + tongTien);
//				Bank b = new Bank();
//				Bank b1 = new VCB();
//				Bank b2 = new AGR();
//				Bank b3 = new TCB();
//			
//				System.out.println("lãi suất ngân hàng nhà nước là " + b.showLaiSuat() + " %");
//				System.out.println("lãi suất  VCB Là " + b1.showLaiSuat() +  " % ");
//				System.out.println("lãi suất  AGR Là " + b2.showLaiSuat() +  " % ");
//				System.out.println("lãi suất TCB Là " + b3.showLaiSuat() +  " % ");
//			

//				
//			HocSinhVTI hocSinh = new HocSinhVTI(18, "Nguyen Minh Anh", "Ha Noi");
//			
//			hocSinh.gioiThieuBanThan();
//			hocSinh.diHoc();

//			HocSinhGioiVTI hocSinhGioiVTI = new HocSinhGioiVTI(18, "Mai van tien", "Nhat ban");
//			hocSinhGioiVTI.gioiThieuBanThan();
//			hocSinhGioiVTI.showSkill();
//			hocSinhGioiVTI.diHoc();

//			HocSinhYeuVTI hocSinhYeu = new HocSinhYeuVTI(18, "Vũ Công Thành", "Thái Bình");
//			hocSinhYeu.gioiThieuBanThan();
//			hocSinhYeu.moiPhuHuynh();

//			HocSinhGioiHoa hocSinhGioiHoa = new HocSinhGioiHoa(18, "Mai Văn Tiến", "Nhật bản",9.9f);
//			
//			hocSinhGioiHoa.gioiThieuBanThan();
//			hocSinhGioiHoa.showSkill();
//			hocSinhGioiHoa.thongBaoDiemMonHoa();
//				Account account = new Account(1, null, "Le Van Tung", "ltung7436@gmail.com", null);
//			
////				Account account = new Account();
////				
////				account.setId(1);
////				account.setFullName("Le Van Tung");
////				account.setEmail("ltung7436@gmail.com");
//				System.out.println(account.getId());
//				System.out.println(account.getFullName());
//				System.out.println(account.getEmail());
//				System.out.println(account.getCreateDate());
	}
}

/*
 * HocSinhVTI hocSinh = new HocSinhVTI(20, "Le Thanh Van", "Thuy An");
 * 
 * hocSinh.gioiThieuBanThan(); hocSinh.diHoc();
 * 
 * 
 * HocSinhGioiHoa hocSinhGioiHoa = new HocSinhGioiHoa(20, "Le Van Tung",
 * "Thai Binh", "Hoa",9.9f); hocSinhGioiHoa.gioiThieuBanThan();
 * hocSinhGioiHoa.showSkill(); hocSinhGioiHoa.thongBaoDiemMonHoa();
 */

//			HocSinhGioiVTI hocSinhGioi = new HocSinhGioiVTI(21, "Le Van Tung", "Thai Binh", "Lap Trinh");
//			hocSinhGioi.gioiThieuBanThan();
//			hocSinhGioi.showSkill();
//			
//			
//			
//			HocSinhYeuVTI hocSinhYeu = new HocSinhYeuVTI(24, "Vu Cong Thang", "Nam Dinh");
//			hocSinhYeu.gioiThieuBanThan();
//			hocSinhYeu.moiPhuHuynh();
//			
//			

//			Account account1 = new Account(1, null, "Le Hong Duyen", "duyennv@gmail.com ", null);// đây 
//			
//			Account account2 = new Account(); // đây là khởi tạo đối tượng constructor rỗng
//			
//			account2.setId(2);
//			account2.setFullName("Le Van Tung 2");
//			account2.setEmail("Tungnx2@gmail.com");
//			
//			System.out.println(account2.getId());
//			System.out.println(account2.getFullName());
//			System.out.println(account2.getEmail());
//			

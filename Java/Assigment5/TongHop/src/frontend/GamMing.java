package frontend;

import entity.AGRB;
import entity.Account;
import entity.Bank;
import entity.HocSinhGioiHoa;
import entity.HocSinhGioiVTI;
import entity.HocSinhVTI;
import entity.HocSinhYeuVTI;
import entity.TCB;
import entity.VCB;

public class GamMing {
	public static void main(String[] args) {
		Bank b = new Bank();
		int tongTien1 = b.tinhTongTien(20, 30);
		int tongTien2 = b.tinhTongTien(30, 27, 19);
		int tongTien3 = b.tinhTongTien(298, 103, 254, 300);
		int tongTien = tongTien1 + tongTien2 + tongTien3;
		
		System.out.println("Tổng tiền " + tongTien);
		System.out.println("Tong tien 1 " + tongTien1);
		System.out.println("Tong tien 2 " + tongTien2);
		System.out.println("Tong tien 3 " + tongTien3);
//		Bank b1 = new VCB();
//		Bank b2 = new AGRB();
//		Bank b3 = new TCB();
//		System.out.println("lãi suất của bank   " + b + "%");
//		System.out.println("Lãi suất  của VCB   " + b1 + "%");
//		System.out.println("Lãi suất  của AGRB " + b2 + "%");
//		System.out.println("Lãi suất  của TCB   " + b3 + "%");
		
		

//				HocSinhVTI hocSinh = new HocSinhVTI(18	, "Lê Thanh Vân", "Thụy An");
//				
//				hocSinh.gioiThieuBanThan();
//				hocSinh.diHoc();
//				
//				HocSinhGioiVTI hocGioiVTI = new HocSinhGioiVTI(2, "Lê Thanh Vân", "Thụy An", "Lập trình");
//				hocGioiVTI.gioiThieuBanThan();
//				hocGioiVTI.diHoc();
//				hocGioiVTI.showSkill();
//					
//				HocSinhYeuVTI hocYeuVTI = new HocSinhYeuVTI(2, "thành", "NamĐịnh");
//				hocYeuVTI.gioiThieuBanThan();
//				hocYeuVTI.moiPhuHuynh();
//				hocYeuVTI.diHoc();
//					
//				
//				HocSinhGioiHoa hocGioiHoa = new HocSinhGioiHoa(0, "lê tùng", "thái bình", "lập trình java" , 9.5f);
//				hocGioiHoa.gioiThieuBanThan();
//				hocGioiHoa.showSkill();
//				hocGioiHoa.thongBaoDiemMonHoa();
	}
}

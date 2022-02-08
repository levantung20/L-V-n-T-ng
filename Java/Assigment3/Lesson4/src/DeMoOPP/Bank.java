package DeMoOPP;

public class Bank {
	
	int showLaiSuat() {
		return 1;
	}
	
	int tinhTongTien(int  soTienThuNhat , int soTienThuHai) {
		return soTienThuNhat + soTienThuHai;
	}
	
	int tinhTongTien(int  soTienThuNhat , int soTienThuHai , int soTienThuBa) {
		return soTienThuNhat + soTienThuHai + soTienThuBa;
	}
	
	int tinhTongTien(int  soTienThuNhat , int soTienThuHai , int soTienThuBa ,  int soTienThuTu) {
		return soTienThuNhat + soTienThuHai + soTienThuBa + soTienThuTu;
	}
}

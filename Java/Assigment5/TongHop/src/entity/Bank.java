package entity;

public class Bank {
	public	int showLaiSuat() {
			return 1;
		}
	public int tinhTongTien(int soTienThuNhat , int soTienThuHai) {
			return soTienThuNhat + soTienThuHai;
					
		}
	public int tinhTongTien(int soTienThuNhat, int soTienThuHai , int soTienThuBa) {
			return soTienThuNhat + soTienThuHai + soTienThuBa;
		}
	public int tinhTongTien(int soTienThuNhat , int soTienThuHai , int soTienThuBa, int soTienThuTu) {
			return soTienThuNhat + soTienThuHai + soTienThuBa + soTienThuTu;
		}
		
		@Override
		public String toString() {
			return " là " + this.showLaiSuat();
		}
}

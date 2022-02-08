package com.Vnext.student;

public class HocSinh {
		int mahocSinh;
		String tenHocSinh;
		String tenTruong;
		String diaChi;
		String email;
		Gender gioiTinh;
		
		public int getMahocSinh() {
			return mahocSinh;
		}
		public void setMahocSinh(int mahocSinh) {
			this.mahocSinh = mahocSinh;
		}
		public String getTenHocSinh() {
			return tenHocSinh;
		}
		public void setTenHocSinh(String tenHocSinh) {
			this.tenHocSinh = tenHocSinh;
		}
		public String getTenTruong() {
			return tenTruong;
		}
		public void setTenTruong(String tenTruong) {
			this.tenTruong = tenTruong;
		}
		public String getDiaChi() {
			return diaChi;
		}
		public void setDiaChi(String diaChi) {
			this.diaChi = diaChi;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}

		public Gender getGioiTinh() {
			return gioiTinh;
		}
		public void setGioiTinh(Gender gioiTinh) {
			this.gioiTinh = gioiTinh;
		}
		@Override
		public String toString() {


		return "ma hoc sinh : " + mahocSinh + " , ten hoc sinh : " + tenHocSinh + " , ten truong :" + tenTruong + " , dia chi " + diaChi +
				", email : " + email + " , gioiTinh : " + gioiTinh;
		}
		public void setmonChuyen(String monChuyen) {
			// TODO Auto-generated method stub
			
		}
}
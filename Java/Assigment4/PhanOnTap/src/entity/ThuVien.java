package entity;

public class ThuVien {
			int MaTaiLieu;
			String tenNhanXuatBan;
			String soBanPhatHanh;
			
			public ThuVien(int maTaiLieu, String tenNhanXuatBan, String soBanPhatHanh) {
				MaTaiLieu = maTaiLieu;
				this.tenNhanXuatBan = tenNhanXuatBan;
				this.soBanPhatHanh = soBanPhatHanh;
			}

			public int getMaTaiLieu() {
				return MaTaiLieu;
			}

			public void setMaTaiLieu(int maTaiLieu) {
				MaTaiLieu = maTaiLieu;
			}

			public String getTenNhanXuatBan() {
				return tenNhanXuatBan;
			}

			public void setTenNhanXuatBan(String tenNhanXuatBan) {
				this.tenNhanXuatBan = tenNhanXuatBan;
			}

			public String getSoBanPhatHanh() {
				return soBanPhatHanh;
			}

			public void setSoBanPhatHanh(String soBanPhatHanh) {
				this.soBanPhatHanh = soBanPhatHanh;
			}
			
			
			
			
			
}

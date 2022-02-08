package entity;

import java.util.Date;

public class Bao extends ThuVien {
	Date ngayPhatHanh;

	public Bao(int maTaiLieu, String tenNhanXuatBan, String soBanPhatHanh, Date ngayPhatHanh) {
		super(maTaiLieu, tenNhanXuatBan, soBanPhatHanh);
		this.ngayPhatHanh = ngayPhatHanh;
	}

	public Date getNgayPhatHanh() {
		return ngayPhatHanh;
	}

	public void setNgayPhatHanh(Date ngayPhatHanh) {
		this.ngayPhatHanh = ngayPhatHanh;
	}

}

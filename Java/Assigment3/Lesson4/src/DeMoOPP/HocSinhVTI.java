package DeMoOPP;

public class HocSinhVTI {
	int maHocSinh;
	String tenHocSinh;
	String diaChiHocSinh;

	public HocSinhVTI(int maHocSinh, String tenHocSinh, String diaChiHocSinh) {
		this.maHocSinh = maHocSinh;
		this.tenHocSinh = tenHocSinh;
		this.diaChiHocSinh = diaChiHocSinh;
	}

	public void gioiThieuBanThan() {
		System.out.println("toi ten la " + this.tenHocSinh + " dia chi " + this.diaChiHocSinh);
	}

	public void diHoc() {
		System.out.println(" i am going to  school");
	}
}

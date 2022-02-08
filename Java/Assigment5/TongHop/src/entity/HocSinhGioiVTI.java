package entity;

public class HocSinhGioiVTI extends HocSinhVTI {

	String monChuyen;

	public HocSinhGioiVTI(int maHocSinh, String tenHocSinh, String diaChiHocSinh, String monChuyen) {
		super(maHocSinh, tenHocSinh, diaChiHocSinh);
			this.monChuyen = monChuyen;
	}

	public void showSkill() {
		System.out.println("môn chuyên của tôi là " + this.monChuyen);
	}

}

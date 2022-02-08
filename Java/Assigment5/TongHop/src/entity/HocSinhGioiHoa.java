package entity;

public class HocSinhGioiHoa  extends HocSinhGioiVTI{
		
	float diemMonHoa;

	public HocSinhGioiHoa(int maHocSinh, String tenHocSinh, String diaChiHocSinh, String monChuyen, float diemMonHoa) {
		super(maHocSinh, tenHocSinh, diaChiHocSinh, monChuyen);
		this.diemMonHoa = diemMonHoa;
	}
	public void thongBaoDiemMonHoa() {
		System.out.println("điểm môn hóa của  em là " + this.diemMonHoa);
	}
}

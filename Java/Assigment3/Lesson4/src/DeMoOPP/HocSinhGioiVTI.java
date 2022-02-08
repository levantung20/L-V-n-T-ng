package DeMoOPP;

public class HocSinhGioiVTI extends HocSinhVTI {
		String monChuyen;
		
	public HocSinhGioiVTI(int maHocSinh, String tenHocSinh, String diaChiHocSinh) {
		super(maHocSinh, tenHocSinh, diaChiHocSinh);
	
	}
		public void showSkill() {
			System.out.println("Mon chyen cua toi la " + this.monChuyen);
		}
}

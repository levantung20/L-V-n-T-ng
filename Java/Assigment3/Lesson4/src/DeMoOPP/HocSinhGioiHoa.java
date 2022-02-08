package DeMoOPP;

public class HocSinhGioiHoa  extends HocSinhGioiVTI {
	
		float diemMonHoa;

		public HocSinhGioiHoa(int maHocSinh, String tenHocSinh, String diaChiHocSinh, float diemMonHoa) {
			super(maHocSinh, tenHocSinh, diaChiHocSinh);
			this.diemMonHoa = diemMonHoa;
		}
		public void thongBaoDiemMonHoa() {
			System.out.println("điểm môn hóa của em là " + this.diemMonHoa);
		}
		
		
}

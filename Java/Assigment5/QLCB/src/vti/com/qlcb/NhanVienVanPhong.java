package vti.com.qlcb;

public class NhanVienVanPhong extends CanBo {
		String congViec;

		public String getCongViec() {
			return congViec;
		}

		public void setCongViec(String congViec) {
			this.congViec = congViec;
		}
		
	@Override
	public String toString() {
	
	return   super.toString() + " ,congviec : " + congViec;
	}
	
	
}

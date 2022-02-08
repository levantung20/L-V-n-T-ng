package entitye;

public class NhanVienVanPhong extends CanBo {
	public String congViec;

	public String getCongViec() {
		return congViec;
	}

	public void setCongViec(String congViec) {
		this.congViec = congViec;
	}

	@Override
	public String toString() {
		return super.toString() + "Cong Viec " + this.congViec;
	}
}

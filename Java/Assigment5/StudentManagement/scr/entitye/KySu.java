package entitye;

public class KySu extends CanBo {
	public String chuyenNganh;

	public String getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	@Override
	public String toString() {
		return super.toString() + " chuyen Nganh " + this.chuyenNganh;
	}
}

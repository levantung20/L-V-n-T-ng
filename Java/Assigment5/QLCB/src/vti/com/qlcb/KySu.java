package vti.com.qlcb;

public class KySu  extends CanBo{
	String chuyenNganh;

	public String getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}
	
	@Override
	public String toString() {
		return  super.toString() + " ,chuyennganh : " + chuyenNganh;
	}
}

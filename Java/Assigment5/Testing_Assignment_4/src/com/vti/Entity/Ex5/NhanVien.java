package com.vti.Entity.Ex5;

public class NhanVien  extends CanBo{
	public 	String CongViec;

		public String getCongViec() {
			return CongViec;
		}

		public void setCongViec(String congViec) {
			CongViec = congViec;
		}
		
		@Override
		public String toString() {
		return super.toString() +  " , congViec : "  + this.CongViec;
		}
}

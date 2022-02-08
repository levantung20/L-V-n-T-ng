package com.Vnext.student;

public class HocSinhTruongChuyen  extends HocSinh{
		String monChuyen;

		public String getMonChuyen() {
			return monChuyen;
		}

		public void setMonChuyen(String monChuyen) {
			this.monChuyen = monChuyen;
		}
		
		@Override
		public String toString() {
		return super.toString() + " , monChuyen " + monChuyen;
		}
}

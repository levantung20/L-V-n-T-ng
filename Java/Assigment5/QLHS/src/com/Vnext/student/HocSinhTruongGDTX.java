package com.Vnext.student;

public class HocSinhTruongGDTX  extends HocSinh{
		int soNamHocLai;

		public int getSoNamHocLai() {
			return soNamHocLai;
		}

		public void setSoNamHocLai(int soNamHocLai) {
			this.soNamHocLai = soNamHocLai;
		}
		
		@Override
		public String toString() {
		return  super.toString() + ",  so nam hoc lai : " + soNamHocLai;
		
		}
}

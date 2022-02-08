package com.Vnext.student;

public class HocSinhTruongNoiTru extends HocSinh {
		float tienNoiTru;

		public float getTienNoiTru() {
			return tienNoiTru;
		}

		public void setTienNoiTru(float tienNoiTru) {
			this.tienNoiTru = tienNoiTru;
		}
		
		@Override
		public String toString() {
		return   super.toString() + " , tien noi tru : " + tienNoiTru;
		}
}

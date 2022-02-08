package com.vti.Entity.Ex5;

public class CongNhan extends CanBo {
	public String CapBap;

		public String getCapBap() {
			return CapBap;
		}

		public void setCapBap(String capBap) {
			CapBap = capBap;
		}
		
		@Override
		public String toString() {
		return super.toString()  + " , capBac " + this.CapBap ;
		}
}

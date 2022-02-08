package vti.com.qlcb;

public class CongNhan extends CanBo {
		String capBac;

		public String getCapBac() {
			return capBac;
		}

		public void setCapBac(String capBac) {
			this.capBac = capBac;
		}
		
		@Override
		public String toString() {
		return  super.toString() +  " , capBac : " + capBac;
		}
}

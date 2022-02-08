package Vnext.com.vn;

public class Album {
	private	 int maCD;
	private	String tenCD;
	private	String caSy;
	private	int soBH;
	private	float giaThanh;
		
		public Album() {}

		public Album(int maCD, String tenCD, String caSy, int soBH, float giaThanh) {
			super();
			this.maCD = maCD;
			this.tenCD = tenCD;
			this.caSy = caSy;
			this.soBH = soBH;
			this.giaThanh = giaThanh;
		}

		public int getMaCD() {
			return maCD;
		}

		public void setMaCD(int maCD) {
			this.maCD = maCD;
		}

		public String getTenCD() {
			return tenCD;
		}

		public void setTenCD(String tenCD) {
			this.tenCD = tenCD;
		}

		public String getCaSy() {
			return caSy;
		}

		public void setCaSy(String caSy) {
			this.caSy = caSy;
		}

		public int getSoBH() {
			return soBH;
		}

		public void setSoBH(int soBH) {
			this.soBH = soBH;
		}

		public float getGiaThanh() {
			return giaThanh;
		}

		public void setGiaThanh(float giaThanh) {
			this.giaThanh = giaThanh;
		}
		
		@Override
		public String toString() {
		return super.toString() + ", maCD " + maCD +  " ,tenCD " + tenCD + " , caSy " + caSy + " , soBH " + soBH + " , giaThanh " + giaThanh;
		}

		public void hienThiAlbum() {
			System.out.printf("%-10d %-20s  %-20s %-10d %-20.1f" , maCD , tenCD , caSy, soBH , giaThanh);
			
		}

}

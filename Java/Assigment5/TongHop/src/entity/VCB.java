package entity;

public class VCB extends Bank {
	public	int showLaiSuat() {
			return 10;
		}
		@Override
		public String toString() {
		return  " là " + this.showLaiSuat();
		}
}

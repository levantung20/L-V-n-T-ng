package entity;

public class AGRB extends Bank {
	public	int showLaiSuat() { 
			return 8;
		}
		@Override
		public String toString() {
		return " là " + this.showLaiSuat() ;
		}
}

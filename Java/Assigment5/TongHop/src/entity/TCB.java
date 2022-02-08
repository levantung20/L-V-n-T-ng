package entity;

public class TCB extends Bank {
	public	int showLaiSuat() { 
			return 6;
		}

		@Override
		public String toString() {
		return  "là  " + this.showLaiSuat() ;
		}
}

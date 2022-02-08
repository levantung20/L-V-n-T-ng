package DeMoto;

public class Student {
		int id;
		String homtown;
		float diemHocLuc;
		String name;
		public Student(int id, String homtown, float diemHocLuc, String name) {
			super();
			this.id = id;
			this.homtown = homtown;
			this.diemHocLuc = diemHocLuc;
			this.name = name;
		}
		
		public void setDiemHocLuc() { // tạo method cho diem
			System.out.println( " que cua toi la : " + this.homtown + " diem cua toi la: " + this.diemHocLuc );
		}
		public void   themDiem(float diemCong) {
		System.out.println(" ten cua ban duoc cong diem la  " +  this.name  + " 4.1 ");
		}
		public void thongtinsinhvien() {
			System.out.println("ten sv nay " + this.name + "4" + this.diemHocLuc);
		}
	
		public String thongtinsv() {
			String xephang = "";
			if(this.diemHocLuc < 4)
				xephang = "yeu";
			else if(4<this.diemHocLuc && this.diemHocLuc<6)
				xephang = " trung binh";
			else if(6<this.diemHocLuc && this.diemHocLuc<8)
				xephang = "kha";
			else 
				xephang ="gioi";
			String thongtin = this.id+this.homtown+this.name+xephang;
			return thongtin;
		
		}
		
}

package entity;

public class Student {
		private int id;
		private String name;
		private String hometown;
		private float diemHocLuc;
		
		public Student(int id, String name, String hometown, float diemHocLuc) {
			super();
			this.id = id;
			this.name = name;
			this.hometown = hometown;
			this.diemHocLuc = diemHocLuc;
		}
		
		// c) Tạo 1 method cho phép set điểm vào
			public void setDiemHocLuc() {
				System.out.println("tên tôi là  : " + this.name  +  ", quê ở : " + this.hometown +  " diem cua toi la : "  + this.diemHocLuc);
			}
			// d) Tạo 1 method cho phép cộng thêm điểm
			public void themDiem(float diemCong) {
				System.out.println("tên của bạn được cộng điểm là " + this.name + 4.1);
			}
			public void thongtinsinhvien() {
				System.out.println("sinh viên  " + this.name +  + this.diemHocLuc);
			}
//			e) Tạo 1 method để in ra thông tin của sinh viên bao gồm có tên,
//			điểm h�?c lực ( nếu điểm <4.0 thì sẽ in ra là Yếu, nếu điểm >
//			4.0 và < 6.0 thì sẽ in ra là trung bình, nếu điểm > 6.0 và < 8.0
//			thì sẽ in ra là khá, nếu > 8.0 thì in ra là Gi�?i)
			
			public String ThongTinSinhVien() {
				String ThucLuc = " ";
				if (this.diemHocLuc < 4.0) {
					ThucLuc = "Yếu";
				} else if(4<this.diemHocLuc && this.diemHocLuc <6)
				if (this.diemHocLuc < 6.0) {
					ThucLuc = "Trung Binh";
				} else if(6 < this.diemHocLuc && this.diemHocLuc >8)
				if(this.diemHocLuc > 8.0) {
					ThucLuc = "Khá";
				} else {
					ThucLuc = "Gi�?i";
				}
				String thongtin =this.id +  this.hometown + this.name + ThucLuc;
				return thongtin;
			}
}

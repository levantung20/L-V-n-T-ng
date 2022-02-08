package entitye;

public class Student{
	public int id;
	public String name;
	public String hometown;
	public float diemHocLuc;

	public Student(int id, String name, String hometown, float diemHocLuc) {
		this.id = id;
		this.name = name;
		this.hometown = hometown;
		this.diemHocLuc = diemHocLuc;
	}

	public void setDiemHocLuc(float diemHocLuc) {
		this.diemHocLuc = diemHocLuc;
	}
	public void dihoc() {
		System.out.println(" i am going to schools");
	}
	
	public void congThemDiemHocLuc(float diemHocLucCongThem) {
		this.diemHocLuc += diemHocLucCongThem;
	}

	String getHocLuc() {
		if (this.diemHocLuc < 4.0) {
			return "Yeu";
		} else if (this.diemHocLuc < 6.0) {
			return "TrungBinh";
		} else if (this.diemHocLuc < 8.0) {
			return "Kha";
		} else {
			return "gioi";
		}

	}

	@Override
	public String toString() {
		return  "ma sv " + this.id + " hoTen " + this.name + " hoc luc : " + getHocLuc();
	}
}

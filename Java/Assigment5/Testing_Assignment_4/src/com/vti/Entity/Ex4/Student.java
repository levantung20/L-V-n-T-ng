package com.vti.Entity.Ex4;

public class Student {
	private	int id;
	private	String name;
	private	String hometown;
	private	float diemHocLuc;
	
	
	public Student(int id, String name, String hometown) {
		this.id = id;
		this.name = name;
		this.hometown = hometown;
		this.diemHocLuc = 0;
	}

	// c) Tạo 1 method cho phép set điểm vào
	public void setDiemHocLuc(float diemHocLuc) {
		this.diemHocLuc = diemHocLuc;
	}
	
	// d) Tạo 1 method cho phép cộng thêm điểm
	
	public void congThemDiemHocLuc(float diemHocLucCongThem) {
		this.diemHocLuc += diemHocLucCongThem;
	}
	 public String getHocLuc() {
		if (this.diemHocLuc < 4.0) {
			return "Yeu";
		} else if (this.diemHocLuc <6.0) {
			return "Trung binh";
		} else if (this.diemHocLuc < 8.0) {
			return "Kha";
		} else {
			return "Gioi";
		}

	}
	
	// toString in ra thong tin cuả 1 obecjt 1 đối tượng
	@Override 
	public String toString() {
		return  " ma sv " + this.id +  " , hoTen "  + this.hometown +  this.name  + " hoc Luc:  " + getHocLuc();
	}
}

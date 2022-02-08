package backend;

import entity.Student;

public class Exercie4 {
		public static void main(String[] args) {
			Student student = new Student(1, "Tung", "ThaiBinh" , 5.1f);
			student.setDiemHocLuc();
			student.thongtinsinhvien();
			student.ThongTinSinhVien();
			student.themDiem(5.0f);
			
		}
}

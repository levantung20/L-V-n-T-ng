package Backend;

import Entity.Student2;

public class Progamming2 {
	public static void main(String[] args) {

//			B1: Các Student sẽ nộp quỹ, mỗi Student 100k
		Student2 student1 = new Student2(1, "Nguyễn Văn A");
		Student2 student2 = new Student2(2, "Nguyễn Văn B");
		Student2 student3 = new Student2(3, "Nguyễn Văn C");

		System.out.println("Tiền quỹ sau khi học sinh tham gia lớp : " + Student2.getMonenyGroup());
		System.out.println("==============================================");
//			B2: Student thứ 1 lấy 50k đi mua bim bim, kẹo về liên hoan
		System.out.println("Bạn An thứ 1 lấy 50K đi mua bim bim ,kẹo về liên hoan");
		student1.layTien(50);
		System.out.println("Tổng tiền quỹ còn lại là : " + Student2.getMonenyGroup());
		System.out.println("==============================================");
		System.out.println("Bạn Vân thứ 2 lấy đi 20k đi mua bánh mỳ");
		student2.layTien(20);
		System.out.println("Tổng tiền quỹ còn lại là : " + Student2.getMonenyGroup());

		System.out.println("==============================================");
		System.out.println("Bạn Thắng thứ 3 lấy đi 150k đi mua đồ dùng học tập cho nhóm");
		student3.layTien(150);
		System.out.println("Tổng tiền quỹ còn lại là :  " + Student2.getMonenyGroup());
		System.out.println("==============================================");
		
//		cả nhóm mỗi người nộp lại 50k
		System.out.println("Cả nhóm  mỗi người 	đóng lại 50k");
		student1.nopTien(50);
		student2.nopTien(50);
		student3.nopTien(50);
		System.out.println("Tiền quỹ còn lại  là :  " + Student2.getMonenyGroup());
	}
}

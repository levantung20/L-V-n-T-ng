package backend;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import entity.Student;

public class Quesion1 {
	static Scanner scanner = new Scanner(System.in);
	static List<Student> students = new ArrayList<>();

//	a) 
	public static void tongStudent() {
		students.add(new Student(1, " A"));
		students.add(new Student(2, " B"));
		students.add(new Student(3, " C"));
		System.out.println("tong hoc sinh là : " + Student.count);
	}

	// b) 

	public void LayPhanTu() {
		tongStudent();
		try {
			System.out.println(students.get(4));
		} catch (IndexOutOfBoundsException e) {
			System.err.println("in ra điuwợc student trong mảng là từ 1 -3 ");
		}
	}

	// c) 

	public void InPhanTu() {
		tongStudent();
		System.out.println(students.get(0));

		int x = students.size() - 1;
		System.out.println(students.get(x));
	}

	// d) 

	public void ThemVaodau() {
		tongStudent();
		students.add(0, new Student(0, " B"));
		System.out.println(students);
	}

//	e) 

	public void themPhanTu() {
		tongStudent();
		students.add(new Student(4, " A"));
		System.out.println(students);
	}

	// f

	public void reverseList() {
		tongStudent();
		Collections.reverse(students);
		System.out.println("Thông tin student sau đảo ngược là: " + students);
	}

	// g)
	public void timKiemTheoId() {
		tongStudent();
		System.out.print("nhập vào id cần tìm : ");
		int number = scanner.nextInt();
		for (Student student : students) {
			if (student.getId() == number) {
				System.out.println("Id bạn cần tìm là :");
			} else {
				System.out.println("không có hoc sinh nào trong danh sách ");
			}
		}
	}

	// h) 
	public void timKiemStudentTheoName() {
		tongStudent();
		System.out.print("Nhap Ten can tim: ");
		String Nm = scanner.nextLine();
		for (Student student : students) {
			if (student.getName().equals(Nm)) {
				System.out.println("id là bạn cần tìm là ");
			} else {
				System.out.println(Nm + " :không có trong danh sách ");
			}
		}
	}

	// i) 
	public static void printSameName() {

	}

	// j) 
	public static void XoaHocSinh1() {
		for (Student student : students) {
			if (student.getId() == 2) {
				student.setName(null);
			}
		}
	}

	// k) 
	public static void XoaHocSinh2() {
		for (Student student : students) {
			if (student.getId() == 5) {
				students.remove(student);
			}
		}
	}

	// l) Tạo 1 ArrayList tên là studentCopies và add tất cả students vào
	// studentCopies
	public static void CreateStudentCopy() {
		ArrayList<Student> studentCopies = new ArrayList<>();
		studentCopies.addAll(students);
	}
}

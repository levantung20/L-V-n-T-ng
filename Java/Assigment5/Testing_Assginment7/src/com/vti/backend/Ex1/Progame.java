package com.vti.backend.Ex1;

import java.net.http.HttpTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.vti.enttity.Ex1.Configs;
import com.vti.enttity.Ex1.HinhHoc;
import com.vti.enttity.Ex1.HinhHocException;
import com.vti.enttity.Ex1.HinhTron;
import com.vti.enttity.Ex1.PrimaryStudent;
import com.vti.enttity.Ex1.SecondaryStudent;
import com.vti.enttity.Ex1.Student;

public class Progame {
private static final Student[] students = null;

//		public static void main(String[] args) {
//			Student student1 = new Student(1, "Nguyễn Văn A");
//			Student student2 = new Student(2, "Nguyễn Văn B");
//			Student student3 = new Student(3, "Nguyễn Văn C");
//			
//			List<Student> lisStudents = new ArrayList<>();
//				lisStudents.add(student1);
//				lisStudents.add(student2);
//				lisStudents.add(student3);
//				
//				//set trường đại học công nghệ 
//				Student.setCollege("Đại Học Công Nghệ");
//				for (Student student : lisStudents) {
//					System.out.println(student.toString());
//				}
//				
//				//set trườn đại học bách khoa
//				Student.setCollege("Đại Học Bách Khoa");
//				for (Student student : lisStudents) {
//					System.out.println(student.toString());
//				}
//			}
	
	//Question2
//				public static void main(String[] args) {
//					Student student1 = new Student(1, "A");
//					Student student2 = new Student(2, "b");
//					Student student3 = new Student(3, "C");
//					
//					List<Student> listStudents = new ArrayList<>();
//					listStudents.add(student1);
//					listStudents.add(student2);
//					listStudents.add(student3);
//					
//					System.out.println("Tiền quỹ hiện tại của lớp là : " + Student.getMoneyGroup());
//					
//					System.out.println("--------------***********************************-------------");
//					
//					System.out.println("bạn thứ nhất lấy đi 50k đi mua bim bim về liên hoan");
//					student1.layTien(50);
//					System.out.println("tiền còn lại là : " +  Student.getMoneyGroup());
//					
//					System.out.println("--------------***********************************-------------");
//					System.out.println("bạn thứ 2 lấy đi 20 để mua sách vở ");
//					student2.layTien(20);
//					System.out.println("tiền còn lại là : " + Student.getMoneyGroup());
//					
//					System.out.println("--------------***********************************-------------");
//					System.out.println("bạn thứ 3 lấy đi 150k để mua các thứ ");
//					student3.layTien(150);
//					System.out.println("tiền còn lại là : " + Student.getMoneyGroup());
//					
//					System.out.println("--------------***********************************-------------");
//					student1.nopTien(100);
//					student2.nopTien(100);
//					student3.nopTien(500);
//					System.out.println("tổng các student nộp lại cho quỹ là " + Student.getMoneyGroup());
//				}
	
	// Question5: tiếp tục của question1
//			public static void main(String[] args) {
//					List<Student> students = new ArrayList<>();
//					students.add(new Student(1 , "Nguyễn văn a"));
//					students.add(new Student(2 , " Nguyễn Văn B"));
//					
//					students.add(new Student(3 , "Nguyễn Văn C"));
//					
//					System.out.println(Student.getCOUNT());
//		}

		//Question6:
//			public static void main(String[] args) {
//				// thêm 2 pr
//				Student student1 = new	PrimaryStudent(1, "Nguyễn Văn a");
//				Student student2 = new PrimaryStudent(2, "Nguyễn Văn B");
//				
//				// thêm 4 se 
//				Student student3 = new SecondaryStudent(3, "Nguyễn văn d");
//				Student student4 = new SecondaryStudent(4, "Nguyễn văn e");
//				Student student5 = new SecondaryStudent(5, "Nguyễn văn f");
//				Student student6 = new SecondaryStudent(6, "Nguyễn văn g");
//				
//				System.out.println("Số PrimaryStudent thêm vào :  " + PrimaryStudent.countPrimary);
//				System.out.println("Số Secondary thêm vào : " + SecondaryStudent.countSe);
//				System.out.println("Tổng số học sinh thêm vào là : " + Student.getCOUNT());
//			}
		//Question7:
//			public static void main(String[] args) {
//				Scanner sc = new Scanner(System.in);
//				while(true) { 
//					if (Student.getCOUNT() < 7) {
//						Student student7 = new SecondaryStudent(7, "Nguyễn Thị F0");
//						System.out.println("Thêm mới thành công tổng số học sinh là :"  + Student.getCOUNT());
//					} else {
//						System.out.println("bạn đã thêm tối đa 7 học sinh");
//					}
//					sc.nextLine();
//				}
				
			
			// Question 8
				public static void main(String[] args)  throws HinhHocException {
					Scanner sc = new Scanner(System.in);
					while(true) {
						try {
							HinhHoc Hinh1 = new HinhTron();
							if (HinhHoc.count > Configs.SO_LUONG_HINH_TOI_DA) {
								throw new HinhHocException ("Bạn chỉ được thêm tối đa là : " + Configs.SO_LUONG_HINH_TOI_DA);
							}
						} catch (HinhHocException  e) {
							System.out.println(e.getMessage());
						}
						System.out.println("Bạn đã thêm thành công số lượng hình học là : " + HinhHoc.count);
						sc.nextLine();
					}
				}
			}

			
		


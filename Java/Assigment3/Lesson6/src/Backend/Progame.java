package Backend;

import entity.Person;
import entity.Student;
import entity.Tearcher;

public class Progame {
	public static void main(String[] args) {
			Student student1 = new Student(15, "tuấn long" , "Viet Nam" , 10);
			Student student2 = new Student(19, "Minh Anh", "Nhat Ban" , 24);
			Student student3= new Student(20, "Thanh Loan", "ChiNa" , 10);
			Student student4 = new Student(21, "Văn Tùng" , "Japan" , 25);
			Student student5 = new Student(15, "Yến Thanh" ,"USE", 12);
			
			Tearcher tearcher1 = new Tearcher(25, "Vũ Công Thành" , "Math" , 100f);
			Tearcher tearcher2	= new Tearcher(26, "Nguyễn Ngọc Duy" ,"Physic", 200f);
			Tearcher tearcher3 = new Tearcher(28, "Nguyễn Văn Quyết", "Music ", 500f);
			Tearcher tearcher4 = new Tearcher(27, "Mai Văn An",  "Fashion " , 100f);
			Tearcher tearcher5 = new Tearcher(29, "Trần Thu Trang" ,"Internet" , 10f);
			
			
			Person[] persons = {student1 , student2 ,student3 , student4, student5 , tearcher1,tearcher2, tearcher3, tearcher4, tearcher5};
			for (Person person : persons) {
				if(person instanceof Student){
					Student tempStudent = (Student) person;
					System.out.println("=======Đối tượng student===========");
					System.out.println(tempStudent.hometown);
					System.out.println(tempStudent.mark);
				} else if( person instanceof Tearcher) {
					Tearcher tempTearcher = (Tearcher) person;
					System.out.println("=====Đối tượng Tearcher======");
					System.out.println(tempTearcher.object);
					System.out.println(tempTearcher.saraly);
				}
			}
//			
//			Student[] students = {student1 ,student2 , student3, student4,student5};
//			
//			for (Student student : students) {
//				System.out.println(student.toString());
//			}
//			Tearcher[] tearchers = {tearcher1 ,tearcher2 , tearcher3, tearcher4, tearcher5};
//			
//			for (Tearcher tearcher : tearchers) {
//				System.out.println(tearcher.toString());
//			}
			
	}
}

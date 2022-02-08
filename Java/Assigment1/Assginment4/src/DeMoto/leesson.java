package DeMoto;

public class leesson {
		public static void main(String[] args) {
//			Question1:
//			Department department1 = new Department();
//			
//			System.out.println(department1.getId());
//			System.out.println(department1.getName());
//			
			
////			Quesion2:
//			Account account = new Account(18, "tungncv@gmail.com", "Tung", "Le Van Tung", null);
//			
//			System.out.println(account.getId());
//			System.out.println(account.getEmail());
//			System.out.println(account.getUserName());
//			System.out.println(account.getFullName());
		
			Student student1 = new Student(1, "Thai Binh", 8.6f, "Tung");
		
			student1.setDiemHocLuc();
			student1.thongtinsv();
			student1.thongtinsinhvien();
			student1.themDiem(2.5f);
}
}

package entity;

public class Tung {
		int age;
		String fullName;
		
		
//		đi làm khi trời râm
		public void goToWork() {
			 System.out.println("đi làm bằng xe máy ");
		}
		
//		đi là khi trời mưa
		public void goToWork(String weather) {
			 if(weather == " mưa") {
				 System.out.println("đi làm bằng taxi");
			 } else {
				 System.out.println("đi làm bằng xe máy, thì đeo kính dâm");
			 }
		}
}

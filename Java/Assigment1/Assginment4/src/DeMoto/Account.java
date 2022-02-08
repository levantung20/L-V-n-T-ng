package DeMoto;


import java.util.Date;

public class Account {
		 int id;
		 String email;
		 String userName;
		 String fullName;
		 Date createDate;
		Postion	position;
		
		public Account( int id , String email, String fristname, String lastname,Date createdate ) {
			this.id =id;
			this.fullName = lastname+fristname;
			this.createDate = new Date();
		}
		
		public Account(int id, String email, String userName, String fullName, Date createDate, Postion position) {
		
			this.id = id;
			this.email = email;
			this.userName = userName;
			this.fullName = fullName;
			this.createDate = new Date();
			this.position = position;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getFullName() {
			return fullName;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		public Date getCreateDate() {
			return createDate;
		}
		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}
		public Postion getPosition() {
			return position;
		}
		public void setPosition(Postion position) {
			this.position = position;
		}
	
		
	
}
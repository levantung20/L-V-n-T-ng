package entity;

public class HighSchoolStudent extends Student2 {
			int id;
			String name;
			String clazz;
			 String desiredUniversity;
			public HighSchoolStudent(String name, int id, String clazz, String desiredUniversity) {
				super(name, id, name);
				this.clazz = clazz;
				this.desiredUniversity = desiredUniversity;
			}
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getClazz() {
				return clazz;
			}
			public void setClazz(String clazz) {
				this.clazz = clazz;
			}
			public String getDesiredUniversity() {
				return desiredUniversity;
			}
			public void setDesiredUniversity(String desiredUniversity) {
				this.desiredUniversity = desiredUniversity;
			}
			@Override
			public String toString() {
			return super.toString()  + " , id; " + this.id + ", name " + this.name + " , clazz " + this.clazz
							+ ", desiredUniversity " + this.desiredUniversity;
			}
		
}

package backend.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeMo {
		public static void main(String[] args) throws SQLException {
			// Khai báo các tham số để khởi tạo connection với Database
			
			String dUrl = "jdbc:mysql://localhost:3306/testingsystem3";
			String username = "root";
			String password = "root";
			
			//Khởi tạo đối tượng connection tới Database
			Connection connection = DriverManager.getConnection(dUrl, username, password);
			
			// khởi tạo đối tượng Statement từ Connection
				
			Statement statement = connection.createStatement();
			
			// chạy câu lệnh và hứng kết quả result set
				ResultSet resultSet =  statement.executeQuery("SELECT * FROM department " );
				
				// in ra kết quả màn hình 
				while (resultSet.next()) {
					System.out.print(resultSet.getString(1));
					System.out.print(" | ");
					System.out.println(resultSet.getString("DepartmentName"));
				}
			}
}

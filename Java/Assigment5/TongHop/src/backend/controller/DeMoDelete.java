package backend.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeMoDelete {
		public static void main(String[] args) throws SQLException {
			
			// khai báo các tham số để khởi tạo connection với Database
			String dUrl = "jdbc:mysql://localhost:3306/testingsystem3";
			String username = "root";
			String password = "root";
			// khởi tạo đối tượng  connection tới Database
			Connection connection = DriverManager.getConnection(dUrl, username, password);
			
			// Tạo câu Update
			String sql = "DELETE FROM department WHERE DepartmentID= ?";
			
			//Tạo đối tượng perparedStatement
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			int n = 13;
			preparedStatement.setInt(1, n);
			
			try {
				int affectedRows  = preparedStatement.executeUpdate();
				System.out.println("DELETE thành công " + affectedRows + " bản ghi");
			} catch (Exception e) {
				System.out.println("Có bug kìa fix lại đi !");
				System.out.println(e.getMessage());
			}
		}
}

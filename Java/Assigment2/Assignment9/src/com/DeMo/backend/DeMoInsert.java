package com.DeMo.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeMoInsert {
		public static void main(String[] args) throws SQLException {
			// khai báo  các tham số để khởi tạo  đối tượng connection với Database
			String url = "jdbc:mysql://localhost:3306/testingsystem3";
			String username = "root";
			String password = "root";
			
			// khởi tạo đối  tượng connection tới DB
			Connection connection = DriverManager.getConnection(url, username, password);
			
			
			// Tạo câu insert:
			String sql = "INSERT INTO department (DepartmentID, DepartmentName) VALUES(? , ? )";
			
			//Tạo đối tượng Prepared Statement
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			int n = 15;
			String s = "Phòng Developper ";
			preparedStatement.setInt(1, n);
			preparedStatement.setNString(2, s);
			
			try {
				int affectedRows = preparedStatement.executeUpdate();
				System.out.println("Insert thành công " + affectedRows + " bản ghi !");
			} catch (Exception e) {
				System.out.println("insert bị lỗi!!!Yêu cầu bạn insert lại!!! xin cảm ơn ");
				System.out.println(e.getMessage());
			}
			
		}
}

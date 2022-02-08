package com.DeMo.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeMoUpdate {
		public static void main(String[] args) throws SQLException {
			
			
			// khai báo các tham số để khởi tạo đên connection với Db
			String url = "jdbc:mysql://localhost:3306/testingsystem3";
			String username = "root";
			String password = "root";
			
			// Khởi tạo đối tượng connection tới Database
			Connection connection = DriverManager.getConnection(url, username, password);
			
			// Tạo câu update
			
			String sql = "UPDATE department SET departmentName = ? WHERE departmentId = ?";
			
			// Tạo đối tượng Prepared Statement
			PreparedStatement preparedStatement  = connection.prepareStatement(sql);
			
			String a = "QA";
			int b = 7;
			preparedStatement.setString(1, a);
			preparedStatement.setInt(2, b);
			
			try {
				int affectRows = preparedStatement.executeUpdate();
				System.out.println("update thành công  " + affectRows + " bản ghi !");
			} catch (Exception e) {
				System.out.println("có lỗi rồi nha ");
				System.out.println(e.getMessage());
			}
		}
}

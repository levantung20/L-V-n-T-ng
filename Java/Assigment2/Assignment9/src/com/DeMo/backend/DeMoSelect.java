package com.DeMo.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeMoSelect {
			public static void main(String[] args) throws SQLException {
				
				// khai báo  các tham số để khởi tạo  đối tượng connection với Database
				String url = "jdbc:mysql://localhost:3306/testingsystem3";
				String username = "root";
				String password = "root";
				
				// khởi tạo đối  tượng connection tới DB
				Connection connection = DriverManager.getConnection(url, username, password);
				
				// khởi tạo đối tượng Statement từ Connection 
				Statement statement = connection.createStatement();
				
				// Chạy câu lệnh và hứng kết quả vào resultSet
				ResultSet resultSet = statement.executeQuery("SELECT * FROM department");
				
				// in ra kết quả màn hình : 
				while (resultSet.next()) {
					System.out.print(resultSet.getString(1));
					System.out.print(" | ");
					System.out.println(resultSet.getString("DepartmentName"));
				}
				
			}
			
}

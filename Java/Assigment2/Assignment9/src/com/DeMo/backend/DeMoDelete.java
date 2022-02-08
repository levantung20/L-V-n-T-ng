package com.DeMo.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;

public class DeMoDelete {
		public static void main(String[] args) throws SQLException {
			
			// khai báo các tham số để khởi tạo đối tượng connection với Database
			String url = "jdbc:mysql://localhost:3306/testingsystem3";
			String username = "root";
			String password = "root";
			
			// khởi tạo đối tượng connection tới Database
			Connection connection = DriverManager.getConnection(url, username, password);
			
			// Tạo câu delete: 
			String sql = "DELETE FROM department WHERE DepartmentID = ? ";
			
			//Tạo đối tượng Prepared Statement
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			int a = 10;
			preparedStatement.setInt(1, a);
			
			try {
				int affectedRows = preparedStatement.executeUpdate();
				System.out.println("delete thành công " + affectedRows + " bản ghi !");
			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println(" có bug rồi hhahaa");
				System.out.println(e.getMessage());
			} catch (SQLSyntaxErrorException e) {
				System.out.println("có bug hahaha ");
				System.out.println(e.getMessage());
			}
			
		}
}	

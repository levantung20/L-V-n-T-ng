package backend.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class DeMoUpdate {
	public static void main(String[] args) throws SQLException {
		// Khai báo các tham số để khởi tạo connection với Database

		String dUrl = "jdbc:mysql://localhost:3306/testingsystem3";
		String username = "root";
		String password = "root";

		// Khởi tạo đối tượng connection tới Database
		Connection connection = DriverManager.getConnection(dUrl, username, password);

		// Tạo câu update:

		String sql = "UPDATE department SET DepartmentName = ? WHERE  DepartmentID = ?";

		// Tạo đối tượng PreparedStatement
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		int n = 7;
		String a = "Nguyễn Minh Anh";
		preparedStatement.setString(1, a);
		preparedStatement.setInt(2,n);


		try {
			int affectedRows = preparedStatement.executeUpdate();
			System.out.println("update  thành công " + affectedRows + " bản ghi! ");

		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Có lỗi xảy ra ! ");
			System.out.println(e.getMessage());
		}

	}

}

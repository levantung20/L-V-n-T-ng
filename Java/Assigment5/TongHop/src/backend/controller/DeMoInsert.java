package backend.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class DeMoInsert {
	public static void main(String[] args) throws SQLException {
		// Khai báo các tham số để khởi tạo connection với Database

		String dUrl = "jdbc:mysql://localhost:3306/testingsystem3";
		String username = "root";
		String password = "root";

		// Khởi tạo đối tượng connection tới Database
		Connection connection = DriverManager.getConnection(dUrl, username, password);

		// Tạo câu Insert:

		String sql = "INSERT INTO department (DepartmentID , DepartmentName) VALUES ( ? , ?)";

		// Tạo đối tượng PreparedStatement
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		int n = 7;
		String a = "Phòng ban Studio";
		preparedStatement.setInt(1, 20);
		preparedStatement.setString(2, a);

		// In ra số Rows bị tác động
		try {
			int affectedRows = preparedStatement.executeUpdate();
			System.out.println("Insert thành công " + affectedRows + " bản ghi! ");

		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Có lỗi xảy ra ! ");
			System.out.println(e.getMessage());
		}

	}

}

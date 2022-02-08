package com.vti.VTIAcademy.FinalExam.backend.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.VTIAcademy.FinalExam.entity.Employee;
import com.vti.VTIAcademy.FinalExam.entity.Manager;
import com.vti.VTIAcademy.FinalExam.entity.Project;
import com.vti.VTIAcademy.FinalExam.entity.User;
import com.vti.VTIAcademy.FinalExam.utils.JdbcUtils;

public class UserRepository implements IUserRepository {
	private JdbcUtils jdbcUtils;

	public UserRepository() {
		jdbcUtils = new JdbcUtils();
	}

	public List<User> getUserOfProjectByID(int projectID) throws ClassNotFoundException, SQLException {
		List<User> users = new ArrayList<>();

		// get connection
		Connection connection = jdbcUtils.getConnection();

		// Create a statement object
		String sql = "SELECT u.id, u.full_name, u.email, u.exp_in_year, u.project_id, u.pro_skill, IF(isManager, 'true', 'false') isManager FROM project_user pu LEFT JOIN `user` u ON pu.user_id = u.id LEFT JOIN project p ON pu.project_id = p.id WHERE p.id = ? ORDER BY u.id DESC";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		// set parameter
		preparedStatement.setInt(1, projectID);

		// execute query
		ResultSet resultSet = preparedStatement.executeQuery();

		// handling result set
		if (resultSet.next()) {
			// int idResult = resultSet.getInt("u.id");
			String fullNameResult = resultSet.getString("u.full_name");
			String emailResult = resultSet.getString("u.email");
			int projectIDResult = resultSet.getInt("u.project_id");
			boolean isManager = resultSet.getBoolean("isManager");
			User user = new User(fullNameResult, emailResult, projectIDResult, isManager);
			users.add(user);
			jdbcUtils.disconnect();
			return users;
		} else {
			jdbcUtils.disconnect();
			return null;
		}
	}
	
	public List<User> getListManager() throws ClassNotFoundException, SQLException {
		List<User> managers = new ArrayList<>();

		// get connection
		Connection connection = jdbcUtils.getConnection();

		// Create a statement object
		String sql = "SELECT id, full_name, email, exp_in_year, project_id, isManager FROM `user` WHERE isManager = true;";
		Statement statement = connection.createStatement();

		// execute query
		ResultSet resultSet = statement.executeQuery(sql);

		// handling result set
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String fullName = resultSet.getString("full_name");
			String email = resultSet.getString("email");
			int expInYear = resultSet.getInt("exp_in_year");
			int projectID = resultSet.getInt("project_id");
			boolean isManager = resultSet.getBoolean("isManager");
			Manager manager = new Manager(fullName, email, expInYear, isManager, projectID);
			managers.add(manager);
		}

		jdbcUtils.disconnect();

		return managers;
	}
	
	public User login(String email, String password) throws ClassNotFoundException, SQLException {

		// get connection
		Connection connection = jdbcUtils.getConnection();

		// Create a statement object
		String sql = "SELECT id, full_name, email, project_id, isManager FROM `user` WHERE email = ? AND `password` = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);

		// execute query
		ResultSet resultSet = preparedStatement.executeQuery();

		// handling result set
		if (resultSet.next()) {
			//int idResult = resultSet.getInt("id");
			String fullNameResult = resultSet.getString("full_name");
			String emailResult = resultSet.getString("email");
			int projectID = resultSet.getInt("project_id");
			boolean isManager = resultSet.getBoolean("isManager");
			User user = new User (fullNameResult, emailResult, projectID, isManager);
				jdbcUtils.disconnect();
				return user;
		} else {
			jdbcUtils.disconnect();
			return null;
		}
	}
}

package com.vti.VTIAcademy.FinalExam.backend.presentationlayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.VTIAcademy.FinalExam.backend.businesslayer.IUserService;
import com.vti.VTIAcademy.FinalExam.backend.businesslayer.UserService;
import com.vti.VTIAcademy.FinalExam.entity.User;

public class UserController {
	private IUserService userService;

	public UserController() {
		userService = new UserService();
	}

	public List<User> getUserOfProjectByID(int projectID) throws ClassNotFoundException, SQLException {
		return userService.getUserOfProjectByID(projectID);
	}
	
	public List<User> getListManager() throws ClassNotFoundException, SQLException {
		return userService.getListManager();
	}
	
	public User login(String email, String password) throws ClassNotFoundException, SQLException {
		return userService.login(email, password);
	}
}

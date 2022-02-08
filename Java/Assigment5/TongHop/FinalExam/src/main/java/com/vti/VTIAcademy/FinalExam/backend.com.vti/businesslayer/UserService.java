package com.vti.VTIAcademy.FinalExam.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.VTIAcademy.FinalExam.backend.datalayer.IUserRepository;
import com.vti.VTIAcademy.FinalExam.backend.datalayer.UserRepository;
import com.vti.VTIAcademy.FinalExam.entity.User;

public class UserService implements IUserService {
	private IUserRepository userRepository;

	public UserService() {
		userRepository = new UserRepository();
	}

	public List<User> getUserOfProjectByID(int projectID) throws ClassNotFoundException, SQLException {
		return userRepository.getUserOfProjectByID(projectID);
	}
	public List<User> getListManager() throws ClassNotFoundException, SQLException {
		return userRepository.getListManager();
	}
	
	public User login(String email, String password) throws ClassNotFoundException, SQLException {
		return userRepository.login(email, password);
	}
}

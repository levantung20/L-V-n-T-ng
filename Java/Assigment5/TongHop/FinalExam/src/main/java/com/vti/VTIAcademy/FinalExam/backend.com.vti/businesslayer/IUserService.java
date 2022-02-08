package com.vti.VTIAcademy.FinalExam.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.VTIAcademy.FinalExam.entity.User;

public interface IUserService {
	public List<User> getUserOfProjectByID(int projectID) throws ClassNotFoundException, SQLException;

	public List<User> getListManager() throws ClassNotFoundException, SQLException;

	public User login(String email, String password) throws ClassNotFoundException, SQLException;
}

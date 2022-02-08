
package com.vti.VTIAcademy.FinalExam.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.VTIAcademy.FinalExam.entity.User;

public interface IUserRepository {
	public List<User> getUserOfProjectByID(int projectID) throws ClassNotFoundException, SQLException;

	public List<User> getListManager() throws ClassNotFoundException, SQLException;

	public User login(String email, String password) throws ClassNotFoundException, SQLException;
}

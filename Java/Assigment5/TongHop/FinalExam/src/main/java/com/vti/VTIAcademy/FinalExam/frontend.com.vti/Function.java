package com.vti.VTIAcademy.FinalExam.frontend;

import java.sql.SQLException;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

import com.vti.VTIAcademy.FinalExam.backend.presentationlayer.UserController;
import com.vti.VTIAcademy.FinalExam.entity.User;
import com.vti.VTIAcademy.FinalExam.utils.ScannerUtils;

public class Function {
	Scanner scanner = new Scanner(System.in);
	private UserController userController;

	public Function() {
		userController = new UserController();
	}

	public void getUserOfProjectByID() throws ClassNotFoundException, SQLException {
		System.out.println("Nhập vào id của project cần tìm");
		int projectID = ScannerUtils.inputID();
		List<User> users = userController.getUserOfProjectByID(projectID);
		if (users.size() == 0) {
			System.out.println("Không tìm thấy user");
		} else {
			Formatter fmt = new Formatter();
			fmt.format("%3s %18s %25s %25s\n", "projectID", "Full Name", "Email", "isManager");
			for (User i : users) {
				fmt.format("%3s %27s %30s %15s\n", i.getProjectID(), i.getFullName(), i.getEmail(), i.isManager());
			}
			System.out.println(fmt);
		}
	}

	public void getListManager() throws ClassNotFoundException, SQLException {
		List<User> managers = userController.getListManager();
		Formatter fmt = new Formatter();
		fmt.format("%3s %18s %25s %25s\n", "ID", "Full Name", "Email", "ProjectID");
		for (User i : managers) {
			fmt.format("%3s %20s %30s %15s\n", i.getId(), i.getFullName(), i.getEmail(), i.getProjectID());
		}
		System.out.println(fmt);
	}

	public User login() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.println("Mời bạn nhập email:");
			String email = ScannerUtils.inputEmail();
			System.out.println("Mời bạn nhập password:");
			String password = ScannerUtils.inputPassword();

			User user = userController.login(email, password);

			if (user == null) {
				System.err.println("Email hoặc mật khẩu sai, mời nhập lại");
			} else {
				System.out.println("Đăng nhập thành công, thông tin tài khoản là: ");
				System.out.println(user);
				return user;
			}
		}
	}
}

package com.vti.VTIAcademy.FinalExam.frontend;

import java.sql.SQLException;

import com.vti.VTIAcademy.FinalExam.utils.ScannerUtils;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Function function = new Function();
		System.out.println("Chào mừng bạn tới với phần mềm");
		while (true) {
			int choose = ScannerUtils.inputFromMenu();
			switch (choose) {
			case 1:
				function.getUserOfProjectByID();
				break;
			case 2:
				function.getListManager();
				break;
			case 3:
				function.login();
				break;
			case 4:
				System.out.println("Cảm ơn bạn đã sử dụng chương trình. Hẹn gặp lại!");
				return;
			}
			boolean isChooseOtherFunction = ScannerUtils.chooseOtherFunction();
			if (!isChooseOtherFunction) {
				System.out.println("Cảm ơn bạn đã sử dụng chương trình. Hẹn gặp lại!");
				return;
			}
		}
	}

}

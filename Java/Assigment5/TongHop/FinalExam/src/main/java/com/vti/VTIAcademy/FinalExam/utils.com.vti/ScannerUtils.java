package com.vti.VTIAcademy.FinalExam.utils;

import java.util.Scanner;
import java.util.regex.Pattern;

//import com.vti.VTIAcademy.FinalExam.entity.Candidate.GraduationRank;

public class ScannerUtils {
	public static Scanner scanner = new Scanner(System.in);

	public static int inputInt(String errorMessage) {
		while (true) {
			try {
				return Integer.parseInt(scanner.next().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
				System.out.println("Mời bạn nhập lại:");
			}
		}
	}

	public static int inputAge(String errorMessage) {
		while (true) {
			int age = inputInt(errorMessage);
			if (age <= 0) {
				System.err.println(errorMessage);
				System.out.println("Mời bạn nhập lại");
			} else {
				return age;
			}
		}
	}

	public static int inputIntBetweenAnd(int from, int to, String errorMessage) {
		while (true) {
			int number = inputInt(errorMessage);
			if (number >= from && number <= to) {
				return number;
			} else {
				System.err.println(errorMessage);
				System.out.println("Mời bạn nhập lại");
			}
		}
	}

	public static String inputStringBetweenAnd(int from, int to, String errorMessage) {
		while (true) {
			String str = inputStringOneWord(errorMessage);
			int number = str.length();
			if (number >= from && number <= to) {
				return str;
			} else {
				System.err.println(errorMessage);
				System.out.println("Mời bạn nhập lại");
			}
		}
	}

	public static float inputFloat(String errorMessage) {
		while (true) {
			try {
				return Float.parseFloat(scanner.next().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
				System.out.println("Mời bạn nhập lại:");
			}
		}
	}

	public static double inputDouble(String errorMessage) {
		while (true) {
			try {
				return Double.parseDouble(scanner.next().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
				System.out.println("Mời bạn nhập lại:");
			}
		}
	}

	public static String inputStringOneWord(String errorMessage) {
		while (true) {
			String str = scanner.next().trim();
			if (!str.isEmpty()) {
				return str;
			} else {
				System.err.println(errorMessage);
				System.out.println("Mời bạn nhập lại:");
			}
		}
	}

	public static String inputEmail() {
		while (true) {
			String email = scanner.next().trim();
			Pattern emailPattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9\\-_\\.]+@[a-zA-Z]{2,}(\\.[a-zA-Z]+){1,3}$");
			if (emailPattern.matcher(email).find()) {
				return email;
			} else {
				System.err.println("Invalid data, mời bạn nhập lại");
			}
		}
	}

	public static String inputName() {
		Pattern fullNamePattern = Pattern.compile("^[a-zA-Z ]+$"); // chữ tiếng việt ??
		while (true) {
			scanner.next(); // ?????????????
			String fullName = scanner.nextLine();
			if (fullNamePattern.matcher(fullName).find()) {
				return fullName;
			} else {
				System.out.println("tên chỉ gồm chữ, mời bạn nhập lại");
			}
		}
	}

	public static String inputUsername() {
		String errorMessage = "Username phải lớn hơn 6 ký tự";
		System.out.println("Mời bạn nhập username:");
		while (true) {
			String username = inputStringOneWord(errorMessage);
			// check condition
			if (username.length() > 6) {
				return username;
			} else {
				System.err.println(errorMessage);
				System.out.println("Mời bạn nhập lại: ");
			}
		}
	}

	public static String inputPassword() {
		String errorMessage = "Password phải từ 6 - 12 ký tự";
		while (true) {
			String password = inputStringBetweenAnd(6, 12, errorMessage);
			boolean upperCase = !password.equals(password.toLowerCase());
			// check condition
			if (!upperCase) {
				System.out.println("Password phải có ít nhất một ký tự viết hoa");
				System.out.println("Mời bạn nhập lại password: ");
			} else {
				return password;
			}
		}
	}

	public static String inputPhoneNumber(String errorMessage) {
		while (true) {
			String number = ScannerUtils.inputStringOneWord(errorMessage);
			if (number.length() > 12 || number.length() < 9) {
				System.err.println(errorMessage);
				continue;
			}

			if (number.charAt(0) != '0') {
				System.err.println(errorMessage);
				continue;
			}

			boolean isNumber = true;

			for (int i = 0; i < number.length(); i++) {
				if (Character.isDigit(number.charAt(i)) == false) {
					isNumber = false;
					break;
				}
			}
			if (isNumber == true) {
				return number;
			} else {
				System.out.println(errorMessage);
				System.out.print("Mời bạn nhập lại phone number: ");
			}

		}
	}

	public static int inputID() {
		String errorMessage = "ID là số và phải lớn hơn 0";

		while (true) {
			int age = inputInt(errorMessage);
			scanner.nextLine();
			if (age > 0) {
				return age;
			} else {
				System.err.println(errorMessage);
				System.out.println("Mời bạn nhập lại: ");
			}
		}
	}

//	public static GraduationRank inputGraduationRank(String errorMessage) {
//		Scanner scanner = new Scanner(System.in);
//		while (true) {
//			String graduationRank = inputStringOneWord(errorMessage);
//			GraduationRank rank = GraduationRank.fromValue(graduationRank);
//			if (graduationRank.isEmpty()) {
//				System.err.println(errorMessage);
//				System.out.println("Mời bạn nhập lại:");
//			} else {
//				return rank;
//			}
//		}
//	}

	public static int inputFromMenu() {
		System.out.println("Mời bạn chọn số ứng với câu lệnh tương ứng");
		System.out.println("1. Get user by project id");
		System.out.println("2. Get List Manager");
		System.out.println("3. Login");
		System.out.println("4. Kết thúc chương trình");
		int choose = inputIntBetweenAnd(1, 4, "Bạn chỉ được nhập từ 1 đến 4");
		scanner.nextLine();
		return choose;
	}

	public static boolean chooseOtherFunction() {
		System.out.println("Bạn có muốn thực hiện tính năng khác không? [Y/N]");
		while (true) {
			String result = scanner.next().trim().toUpperCase();
			if (result.equals("N")) {
				return false;
			} else if (result.equals("Y")) {
				return true;
			} else {
				System.err.println("Bạn phải nhập Y/N");
			}
		}
	}

	public static String inputGroupName() {
		String errorMessage = "Tên của group phải lớn hơn 1 ký tự";
		System.out.println("Mời bạn nhập tên group:");
		while (true) {
			String groupName = inputStringOneWord(errorMessage);
			// check condition
			if (groupName.length() > 1) {
				return groupName;
			} else {
				System.err.println(errorMessage);
				System.out.println("Mời bạn nhập lại: ");
			}
		}
	}
}

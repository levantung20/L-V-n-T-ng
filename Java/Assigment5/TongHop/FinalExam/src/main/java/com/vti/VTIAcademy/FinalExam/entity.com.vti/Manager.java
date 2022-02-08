package com.vti.VTIAcademy.FinalExam.entity;

public class Manager extends User {
	private int expInYear;

	public Manager(String fullName, String email, int projectID, boolean isManager, int expInYear) {
		super(fullName, email, projectID, isManager);
		this.expInYear = expInYear;
	}

	/**
	 * @return the expInYear
	 */
	public int getExpInYear() {
		return expInYear;
	}

	/**
	 * @param expInYear the expInYear to set
	 */
	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Manager: ID:" + getId() + " | Full Name: " + getFullName() + " | Email: " + getEmail()
				+ " | Số năm kinh nghiệm: " + expInYear + " năm.";
	}

}

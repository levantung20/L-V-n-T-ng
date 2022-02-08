package com.vti.VTIAcademy.FinalExam.entity;

public class Employee extends User {
	private int projectID;
	private String proSkill;

	public Employee(String fullName, String email, int projectID, boolean isManager, int projectID2, String proSkill) {
		super(fullName, email, projectID, isManager);
		projectID = projectID2;
		this.proSkill = proSkill;
	}

	/**
	 * @return the projectID
	 */
	public int getProjectID() {
		return projectID;
	}

	/**
	 * @param projectID the projectID to set
	 */
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	/**
	 * @return the proSkill
	 */
	public String getProSkill() {
		return proSkill;
	}

	/**
	 * @param proSkill the proSkill to set
	 */
	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

}

package com.revature.waterplant.model;

public class UserDetails {
	private int id;
	private String name;
	private long mobileNumber;
	private String setPassword;

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ",name=" + name + ", mobileNumber=" + mobileNumber + ", setPassword=" + setPassword + "]";
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getSet_Password() {
		return setPassword;
	}

	public void setSet_Password(String setPassword) {
		this.setPassword = setPassword;
	}

}
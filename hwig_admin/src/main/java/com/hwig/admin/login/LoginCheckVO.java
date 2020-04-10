package com.hwig.admin.login;

public class LoginCheckVO {

	private String userType;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "LoginCheckVO [userType=" + userType + "]";
	}

}

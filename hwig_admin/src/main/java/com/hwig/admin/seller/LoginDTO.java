package com.hwig.admin.seller;

public class LoginDTO {

	private String userType;
	private String user_id;
	private String user_pw;
	private boolean sel_cookie;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public boolean isSel_cookie() {
		return sel_cookie;
	}

	public void setSel_cookie(boolean sel_cookie) {
		this.sel_cookie = sel_cookie;
	}

	@Override
	public String toString() {
		return "LoginDTO [userType=" + userType + ", user_id=" + user_id + ", user_pw=" + user_pw + ", sel_cookie="
				+ sel_cookie + "]";
	}

}

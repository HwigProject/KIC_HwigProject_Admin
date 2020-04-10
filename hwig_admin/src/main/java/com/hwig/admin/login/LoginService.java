package com.hwig.admin.login;

public interface LoginService {
	
	public boolean login(LoginDTO loginDto);
	
	public void logout();

}

package com.hwig.admin.login;

import javax.servlet.http.HttpSession;

import com.hwig.admin.seller.LoginDTO;

public interface LoginService {
	
	public boolean login(HttpSession session, LoginDTO loginDto);
	
	public void logout(HttpSession session);

}

package com.hwig.admin.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.hwig.admin.AdminService;
import com.hwig.admin.AdminVO;
import com.hwig.admin.seller.LoginDTO;
import com.hwig.admin.seller.SellerService;
import com.hwig.admin.seller.SellerVO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private SellerService sellerService;

	@Autowired
	private AdminService adminService;

	@Override
	public boolean login(HttpSession session, LoginDTO loginDto) {
		if (loginDto.getUserType().equals("admin")) {
			AdminVO adminVo = adminService.login(loginDto.getUser_id(), loginDto.getUser_pw());
			if (adminVo == null) {
				return false;
			} else {
				session.setAttribute("user", adminVo);
				session.setAttribute("userType", loginDto.getUserType());
			}
		} else {
			SellerVO sellerVo = sellerService.findOneById(loginDto.getUser_id());
			if (sellerVo == null || !BCrypt.checkpw(loginDto.getUser_pw(), sellerVo.getSel_pw())) {
				return false;
			} else {
				session.setAttribute("user", sellerVo);
				session.setAttribute("userType", loginDto.getUserType());
			}
		}

		return true;
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

}

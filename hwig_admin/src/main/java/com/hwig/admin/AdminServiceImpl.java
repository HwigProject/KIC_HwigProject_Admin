package com.hwig.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDao;

	@Override
	public AdminVO login(String admin_id, String admin_pw) {
		AdminVO adminVo = new AdminVO();
		adminVo.setAdmin_id(admin_id);
		adminVo.setAdmin_pw(admin_pw);
		return adminDao.select(adminVo);
	}

}

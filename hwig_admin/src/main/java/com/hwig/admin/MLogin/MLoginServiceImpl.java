package com.hwig.admin.MLogin;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class MLoginServiceImpl implements MLoginService{

	@Inject
	MLoginDAO dao;

	//�α���
	@Override
	public MLoginVO mem_login(MLoginVO member) throws Exception {
		
		return dao.mem_login(member);
	}
}

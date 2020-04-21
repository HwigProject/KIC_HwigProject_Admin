package com.hwig.admin;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String namespace = "com.hwig.admin.mappers.adminMapper";

	@Override
	public AdminVO select(AdminVO adminVo) {
		return sqlSession.selectOne(namespace + ".adminSelect", adminVo);
	}

}

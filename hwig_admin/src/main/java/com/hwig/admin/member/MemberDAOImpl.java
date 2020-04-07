package com.hwig.admin.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.hwig.admin.mappers.memberMapper";

	@Override
	public int insert(MemberVO memberVo) {
		return sqlSession.insert(namespace + ".memberInsert", memberVo);
	}

}

package com.hwig.admin.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hwig.admin.common.SearchCriteria;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.hwig.admin.mappers.memberMapper";

	@Override
	public int insert(MemberVO memberVo) {
		return sqlSession.insert(namespace + ".memberInsert", memberVo);
	}

	@Override
	public List<MemberVO> selectAll(SearchCriteria cri) {
		return sqlSession.selectList(namespace + ".memberAllSelect", cri);
	}

	@Override
	public int selectAllCount(SearchCriteria cri) {
		return sqlSession.selectOne(namespace + ".memberAllCount", cri);
	}

	@Override
	public MemberVO select(MemberVO memberVo) {
		return sqlSession.selectOne(namespace + ".memberSelect", memberVo);
	}

}

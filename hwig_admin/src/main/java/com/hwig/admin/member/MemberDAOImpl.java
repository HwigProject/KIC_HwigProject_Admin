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

	@Override
	public int emailCheck(EmailCheckVO emailCheckVo) {
		return sqlSession.selectOne(namespace + ".emailCheck", emailCheckVo);
	}

	@Override
	public int idCheck(IdCheckVO idCheckVo) {
		return sqlSession.selectOne(namespace + ".idCheck", idCheckVo);
	}

	/**
	 * 0보다 큰 경우 true 리턴 -> 회원정보가 있음 -> 맞는 회원 -> 정보수정가능
	 */
	@Override
	public boolean isRightUserCheck(MemberVO memberVo) {
		return (Integer)sqlSession.selectOne(namespace + ".isRightUserCheck", memberVo) > 0;
	}

	@Override
	public int update(UpdateMemberVO updateMemberVo) {
		return sqlSession.update(namespace + ".memberUpdate", updateMemberVo);
	}

	@Override
	public int delete(String mem_id) {
		return sqlSession.delete(namespace + ".memberDelete", mem_id);
	}

}

package com.hwig.admin.member;

import java.util.List;

import com.hwig.admin.common.SearchCriteria;

public interface MemberDAO {

	public int insert(MemberVO memberVo);
	
	public List<MemberVO> selectAll(SearchCriteria cri);
	
	public int selectAllCount(SearchCriteria cri);
	
	public MemberVO select(MemberVO memberVo);
	
	public int emailCheck(EmailCheckVO emailCheckVo);
	
	public int idCheck(IdCheckVO idCheckVo);
	
	public boolean isRightUserCheck(MemberVO memberVo);
	
	public int update(UpdateMemberVO updateMemberVo);
	
	public int delete(String mem_id);
}

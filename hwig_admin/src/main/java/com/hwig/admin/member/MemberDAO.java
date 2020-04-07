package com.hwig.admin.member;

import java.util.List;

import com.hwig.admin.common.SearchCriteria;

public interface MemberDAO {

	public int insert(MemberVO memberVo);
	
	public List<MemberVO> selectAll(SearchCriteria cri);
	
	public int selectAllCount(SearchCriteria cri);
	
	public MemberVO select(MemberVO memberVo);
	
}

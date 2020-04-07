package com.hwig.admin.member;

import java.util.List;

import com.hwig.admin.common.SearchCriteria;

public interface MemberService {
	
	public int register(MemberVO memberVo);
	
	public List<MemberVO> listAll(SearchCriteria cri);
	
	public int listAllCount(SearchCriteria cri);
	
	public MemberVO findOne(String mem_id);
	
	public MemberVO login(String mem_id, String mem_pw);

}

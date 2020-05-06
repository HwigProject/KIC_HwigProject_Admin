package com.hwig.admin.member;

import java.util.List;

import com.hwig.admin.common.SearchCriteria;

public interface MemberService {

	public int register(MemberVO memberVo);

	public List<MemberVO> listAll(SearchCriteria cri);

	public int listAllCount(SearchCriteria cri);

	public MemberVO findOne(String mem_id);

	public MemberVO login(String mem_id, String mem_pw);

	public int emailCheck(EmailCheckVO emailCheckVo);

	public int idCheck(IdCheckVO idCheckVo);

	public boolean isRightUesrCheck(String mem_id, String mem_pw);

	public int modify(UpdateMemberVO updateMemberVo);

	public int remove(String mem_id);

	public List<ApiOrderListVO> memberOrderListAll(ApiOrderListVO apiOrderListVo);

	public int memberOrderListAllCount(ApiOrderListVO apiOrderListVo);

	public List<ApiOrderDetailVO> memberOrderDetailAll(ApiOrderDetailVO apiOrderDetailVo);

}

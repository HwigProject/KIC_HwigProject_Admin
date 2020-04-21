package com.hwig.admin.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwig.admin.common.SearchCriteria;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDao;

	@Override
	public int register(MemberVO memberVo) {
		return memberDao.insert(memberVo);
	}

	@Override
	public List<MemberVO> listAll(SearchCriteria cri) {
		return memberDao.selectAll(cri);
	}

	@Override
	public int listAllCount(SearchCriteria cri) {
		return memberDao.selectAllCount(cri);
	}

	@Override
	public MemberVO findOne(String mem_id) {
		MemberVO memberVo = new MemberVO();
		memberVo.setMem_id(mem_id);
		return memberDao.select(memberVo);
	}

	@Override
	public MemberVO login(String mem_id, String mem_pw) {
		MemberVO memberVo = new MemberVO();
		memberVo.setMem_id(mem_id);
		memberVo.setMem_pw(mem_pw);
		return memberDao.select(memberVo);
	}

	@Override
	public int emailCheck(EmailCheckVO emailCheckVo) {
		return memberDao.emailCheck(emailCheckVo);
	}

	@Override
	public int idCheck(IdCheckVO idCheckVo) {
		return memberDao.idCheck(idCheckVo);
	}

	/**
	 * 리턴값이 ture면 해당회원, false면 회원정보 일치 실패
	 */
	@Override
	public boolean isRightUesrCheck(String mem_id, String mem_pw) {
		MemberVO memberVo = new MemberVO();
		memberVo.setMem_id(mem_id);
		memberVo.setMem_pw(mem_pw);
		return memberDao.isRightUserCheck(memberVo);
	}

	@Override
	public int modify(UpdateMemberVO updateMemberVo) {
		return memberDao.update(updateMemberVo);
	}

	@Override
	public int remove(String mem_id) {
		return memberDao.delete(mem_id);
	}

}

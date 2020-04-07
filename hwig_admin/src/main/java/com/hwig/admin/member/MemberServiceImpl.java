package com.hwig.admin.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwig.admin.common.SearchCriteria;
import com.hwig.admin.seller.SellerVO;

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

}

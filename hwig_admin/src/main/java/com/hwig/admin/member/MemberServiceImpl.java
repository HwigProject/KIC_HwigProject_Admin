package com.hwig.admin.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
		memberVo = memberDao.select(memberVo);

		if (!BCrypt.checkpw(mem_pw, memberVo.getMem_pw())) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public int modify(UpdateMemberVO updateMemberVo) {
		MemberVO memberVo = new MemberVO();
		memberVo.setMem_id(updateMemberVo.getMem_id());
		memberVo = memberDao.select(memberVo);
		if (!BCrypt.checkpw(updateMemberVo.getMem_pw(), memberVo.getMem_pw())) {
			return 0;
		}

		if (updateMemberVo.getMem_newpw() != null || updateMemberVo.getMem_newpw() != "") {
			String inputPass = updateMemberVo.getMem_newpw();
			PasswordEncoder passEncoder = new BCryptPasswordEncoder();
			String pass = passEncoder.encode(inputPass);
			updateMemberVo.setMem_newpw(pass);
		}

		memberDao.update(updateMemberVo);

		return 1;
	}

	@Override
	public int remove(String mem_id) {
		return memberDao.delete(mem_id);
	}

	@Override
	public List<ApiOrderListVO> memberOrderListAll(ApiOrderListVO apiOrderListVo) {
		return memberDao.memberOrderSelectAll(apiOrderListVo);
	}

	@Override
	public int memberOrderListAllCount(ApiOrderListVO apiOrderListVo) {
		return memberDao.memberOrderAllCount(apiOrderListVo);
	}

	@Override
	public List<ApiOrderDetailVO> memberOrderDetailAll(ApiOrderDetailVO apiOrderDetailVo) {
		return memberDao.memberOrderDetailSelectAll(apiOrderDetailVo);
	}

}

package com.hwig.admin.member;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hwig.admin.common.CommonResponse;
import com.hwig.admin.common.DuplicatedResponse;

@RestController
@RequestMapping("/api/member/*")
public class MemberApiController {

	private static final Logger logger = LoggerFactory.getLogger(MemberApiController.class);

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public CommonResponse register(@RequestBody MemberVO memberVo) {
		logger.info(memberVo.toString());

		CommonResponse response = new CommonResponse();

		int result = memberService.register(memberVo);

		if (result < 1) {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMsg("fail");
		} else {
			response.setCode(HttpStatus.CREATED.value());
			response.setMsg("success");
		}

		return response;
	}

	/**
	 * 회원정보조횟(데이터 값이 ""이면 없는걸로 처리해라)
	 * 
	 * @param mem_id
	 * @return
	 */
	@RequestMapping(value = "/{mem_id}", method = RequestMethod.GET) // 값 받아서 select해야 하니 get
	public MemberVO one(@PathVariable("mem_id") String mem_id) {
		MemberVO memberVo = memberService.findOne(mem_id);

		if (memberVo == null) {
			MemberVO emptyVo = new MemberVO();
			emptyVo.empty();
			return emptyVo;
		}

		return memberVo;
	}

	/**
	 * 구체적인 객체 형태로 이메일 체크
	 * 
	 * @param emailCheckVo
	 * @return
	 */
	@RequestMapping(value = "/check/email", method = RequestMethod.POST) // 액션을 연상시키게 하는 url이면 POST
	public DuplicatedResponse emailCheck(@RequestBody EmailCheckVO emailCheckVo) {
		logger.info(emailCheckVo.toString());

		int result = memberService.emailCheck(emailCheckVo);

		DuplicatedResponse response = new DuplicatedResponse();
		response.setDuplicated((result < 1) ? false : true);

		return response;
	}

	/**
	 * 구체적인 객체 형태로 아이디 체크
	 * 
	 * @param idCheckVo
	 * @return
	 */
	@RequestMapping(value = "/check/id", method = RequestMethod.POST)
	public DuplicatedResponse idCheck(@RequestBody IdCheckVO idCheckVo) {
		logger.info(idCheckVo.toString());

		int result = memberService.idCheck(idCheckVo);

		DuplicatedResponse response = new DuplicatedResponse();
		response.setDuplicated((result < 1) ? false : true);

		return response;
	}

	/**
	 * 회원정보수정 전 아이디와 비밀번호 Map형태로 체크
	 * 
	 * @param memberVo
	 * @return
	 */
	@RequestMapping(value = "/check/user", method = RequestMethod.POST)
	public Map<String, Boolean> isRightUserCheck(@RequestBody Map<String, String> memberVo) {
		logger.info("mem_id -> " + memberVo.get("mem_id"), "mem_pw -> " + memberVo.get("mem_pw"));

		Map<String, Boolean> map = new HashMap<>();
		map.put("isRightUser", memberService.isRightUesrCheck(memberVo.get("mem_id"), memberVo.get("mem_pw")));

		return map;
	}

	@RequestMapping(value = "/modify/{mem_id}", method = RequestMethod.PUT)
	public CommonResponse modify(@PathVariable("mem_id") String mem_id, @RequestBody UpdateMemberVO updateMemberVo) {
		updateMemberVo.setMem_id(mem_id);

		logger.info(updateMemberVo.toString());

		CommonResponse response = new CommonResponse();

		int result = memberService.modify(updateMemberVo);

		if (result < 1) {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMsg("fail");
		} else {
			response.setCode(HttpStatus.OK.value());
			response.setMsg("success");
		}

		return response;
	}

	@RequestMapping(value = "/remove/{mem_id}", method = RequestMethod.DELETE)
	public CommonResponse remove(@PathVariable("mem_id") String mem_id) {
		logger.info(mem_id);

		CommonResponse response = new CommonResponse();

		int result = memberService.remove(mem_id);

		if (result < 1) {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMsg("fail");
		} else {
			response.setCode(HttpStatus.OK.value());
			response.setMsg("success");
		}

		return response;
	}

}

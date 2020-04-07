package com.hwig.admin.member;
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

@RestController
@RequestMapping("/member")
public class MemberApiController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberApiController.class);

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public CommonResponse register(@RequestBody MemberVO memberVo) {
		CommonResponse response = new CommonResponse();
		
		int result = memberService.register(memberVo);
		
		if(result < 1) {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMsg("fail");
		}else {
			response.setCode(HttpStatus.CREATED.value());
			response.setMsg("success");
		}

		return response;
	}
	
	/**
	 * 아이디 정보 조회(데이터 값이 ""이면 없는걸로 처리해라)
	 * @param mem_id
	 * @return
	 */
	@RequestMapping(value = "/{mem_id}", method = RequestMethod.GET)
	public MemberVO one(@PathVariable("mem_id") String mem_id) {
		MemberVO memberVo = memberService.findOne(mem_id);
		
		if(memberVo == null) {
			MemberVO emptyVo = new MemberVO();
			emptyVo.empty();
			return emptyVo;
		}
		
		return memberVo;
	}
	
}

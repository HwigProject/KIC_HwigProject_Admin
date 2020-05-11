package com.hwig.admin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hwig.admin.common.PageMaker;
import com.hwig.admin.common.SearchCriteria;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) {
		model.addAttribute("list", memberService.listAll(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(memberService.listAllCount(cri));
		model.addAttribute("pageMaker", pageMaker);
	}

	@RequestMapping(value = "/detailForm", method = RequestMethod.GET)
	public void detailPage(String mem_id, @ModelAttribute("cri") SearchCriteria cri, Model model) {
		model.addAttribute("data", memberService.findOne(mem_id));
		
		MemberOrderPrdVO memberOrderPrdVo = new MemberOrderPrdVO();
		memberOrderPrdVo.setMem_id(mem_id);
		model.addAttribute("prdData", memberService.memberOrderPrd(memberOrderPrdVo));
		model.addAttribute("page", cri.getPage());
		model.addAttribute("perPageNum", cri.getPerPageNum());
		model.addAttribute("searchType", cri.getSearchType());
		model.addAttribute("keyword", cri.getKeyword());
	}

}

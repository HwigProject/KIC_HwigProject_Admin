package com.hwig.admin.faq;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/faq")
public class FaqController {
	
	@Inject
	FaqService fService;
	
	//자주묻는질문 목록
	@RequestMapping(value = "/flist")
	public void getFaq(Model model) throws Exception{
		
		model.addAttribute("fList", fService.fList());
	}
	
	//자주묻는질문 등록폼
	@RequestMapping(value = "/faq_write")
	public void getFaq_write() throws Exception{
		
	}
	
	//자주묻는질문 등록
	@RequestMapping(value = "/faq_write", method = RequestMethod.POST)
	public String postQna_write(FaqVO faq, RedirectAttributes rttr) throws Exception{
		
		int result = fService.faq_write(faq);
		
		if(result == 1)
		{
			rttr.addFlashAttribute("msg", "success");
		} else {
			rttr.addFlashAttribute("msg", "fail");
		}

		return "redirect:/faq/flist";
	}
	
	//자주묻는질문 조회
	@RequestMapping(value = "/faq_view")
	public void faq_view(@RequestParam("faq_id") int faq_id, Model model) throws Exception{
		FaqVO faq = fService.faq_view(faq_id);
		
		model.addAttribute("faq_view", faq);
	}
	
	//자주묻는질문 수정폼
	@RequestMapping(value = "/faq_modify")
	public void getFaq_modify(@RequestParam("faq_id") int faq_id, Model model) throws Exception{
		FaqVO faq = fService.faq_view(faq_id);
		
		model.addAttribute("faq_view", faq);
	}
	
	//자주묻는질문 수정
	@RequestMapping(value = "/faq_modify", method = RequestMethod.POST)
	public String postFaq_modify(FaqVO faq, RedirectAttributes rttr) throws Exception{
			
		int result = fService.faq_modify(faq);

		if(result == 1)
		{
			rttr.addFlashAttribute("msg", "success");
		} else {
			rttr.addFlashAttribute("msg", "fail");
		}

		return "redirect:/faq/flist";
	}
	
	//자주묻는질문 삭제
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@RequestMapping(value = "/faq_delete")
	public String faq_delete(FaqVO faq, int faq_id, RedirectAttributes rttr) throws Exception{
		
		int result = fService.faq_delete(faq_id);
		fService.faq_id_d(faq);

		if(result == 1)
		{
			rttr.addFlashAttribute("msg", "success");
		} else {
			rttr.addFlashAttribute("msg", "fail");
		}
		
		return "redirect:/faq/flist";
	}
}

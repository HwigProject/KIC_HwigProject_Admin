package com.hwig.admin.notice;

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
@RequestMapping("/notice")
public class NoticeController {
	
	@Inject
	NoticeService nService;
	
	//공지사항 목록
	@RequestMapping(value = "/nlist")
	public void getNotice(Model model) throws Exception{
		
		model.addAttribute("nList", nService.nList());
	}
	
	//공지사항 등록폼
	@RequestMapping(value = "/notice_write")
	public void getNotice_write() throws Exception{
		
	}
	
	//공지사항 등록
	@RequestMapping(value = "/notice_write", method = RequestMethod.POST)
	public String postNotice_write(NoticeVO notice, RedirectAttributes rttr) throws Exception{
		
		int result = nService.notice_write(notice);

		if(result == 1)
		{
			rttr.addFlashAttribute("msg", "success");
		} else {
			rttr.addFlashAttribute("msg", "fail");
		}
		
		return "redirect:/notice/nlist";
	}
	
	//공지사항 조회
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@RequestMapping(value = "/notice_view")
	public void notice_view(@RequestParam("notice_id") int notice_id, Model model) throws Exception{
		
		NoticeVO notice = nService.notice_view(notice_id);		
		
		/* model.addAttribute("notice_hit_up", nService.notice_hit_up(notice_id)); */
		model.addAttribute("notice_view", notice);

	}
	
	//공지사항 수정폼
	@RequestMapping(value = "/notice_modify")
	public void getNotice_modify(@RequestParam("notice_id") int notice_id, Model model) throws Exception{
		NoticeVO notice = nService.notice_view(notice_id);
		
		model.addAttribute("notice_view", notice);
	}
	
	//공지사항 수정
	@RequestMapping(value = "/notice_modify", method = RequestMethod.POST)
	public String postNotice_modify(NoticeVO notice, RedirectAttributes rttr) throws Exception{
		
		int result = nService.notice_modify(notice);

		if(result == 1)
		{
			rttr.addFlashAttribute("msg", "success");
		} else {
			rttr.addFlashAttribute("msg", "fail");
		}
		
		return "redirect:/notice/nlist";
	}
	
	//공지사항 삭제
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@RequestMapping(value = "/notice_delete")
	public String faq_delete(NoticeVO notice, int notice_id, RedirectAttributes rttr) throws Exception{
		int result = nService.notice_delete(notice_id);
		nService.notice_id_d(notice);
		
		if(result == 1)
		{
			rttr.addFlashAttribute("msg", "success");
		} else {
			rttr.addFlashAttribute("msg", "fail");
		}
		
		return "redirect:/notice/nlist";
	}
	
}

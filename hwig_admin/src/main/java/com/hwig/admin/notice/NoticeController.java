package com.hwig.admin.notice;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Inject
	NoticeService nService;
	
	//�������� ���
	@RequestMapping(value = "/nlist")
	public void getNotice(Model model) throws Exception{
		
		model.addAttribute("nList", nService.nList());
	}
	
	//�������� �����
	@RequestMapping(value = "/notice_write")
	public void getNotice_write() throws Exception{
		
	}
	
	//�������� ���
	@RequestMapping(value = "notice_write", method = RequestMethod.POST)
	public String postNotice_write(NoticeVO notice) throws Exception{
		
		nService.notice_write(notice);
		
		return "redirect:/notice/nlist";
	}
	
	//�������� ��ȸ
	@RequestMapping(value = "notice_view")
	public void notice_view(@RequestParam("notice_id") int notice_id, Model model) throws Exception{
		
		NoticeVO notice = nService.notice_view(notice_id);
		
		model.addAttribute("notice_view", notice);
	}
	
	//�������� ������
	
	
	//�������� ����
	
	
	//�������� ����
}

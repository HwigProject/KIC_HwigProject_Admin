package com.hwig.admin.qna;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hwig.admin.common.PageMaker;
import com.hwig.admin.common.SearchCriteria;
import com.hwig.admin.reply.MacroVO;
import com.hwig.admin.reply.ReplyService;
import com.hwig.admin.reply.ReplyVO;

@Controller
@RequestMapping("/qna")
public class QnaController {
	
	@Inject
	QnaService qService;
	@Inject
	ReplyService rService;
	
	//문의 목록
	@RequestMapping(value = "/qlist")
	public void getQna(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
		
		model.addAttribute("qList", qService.qList(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(qService.listCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	//문의 등록폼
	@RequestMapping(value = "/qna_write")
	public void getqna_write() throws Exception{
		
	}
		
	//문의 등록
	@RequestMapping(value = "/qna_write", method = RequestMethod.POST)
	public String postQna_write(QnaVO qna, RedirectAttributes rttr) throws Exception{
		
		int result = qService.qna_write(qna);
		
		if(result == 1)
		{
			rttr.addFlashAttribute("msg", "success");
		} else {
			rttr.addFlashAttribute("msg", "fail");
		}
			return "redirect:/qna/qlist";
	}
	
	//문의 조회
	@RequestMapping(value = "/qna_view")
	public void qna_view(@RequestParam("qna_id") int qna_id, @RequestParam("qna_category") String qna_category,
						 @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
		QnaVO qna = qService.qna_view(qna_id);
		
		model.addAttribute("qna_view", qna);
		model.addAttribute("cri", cri);
		
		ReplyVO reply = rService.reply_view(qna_id);
		model.addAttribute("rList", reply);
		
		
		 MacroVO macro = rService.macro_view(qna_category);
		 model.addAttribute("macro",macro);
		 
	}
	
	//문의 수정폼
	@RequestMapping(value = "/qna_modify")
	public void getqna_modify(@RequestParam("qna_id") int qna_id,
							  @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
		QnaVO qna = qService.qna_view(qna_id);
		
		model.addAttribute("qna_view", qna);
		model.addAttribute("cri", cri);
	}
	//문의 수정
	@RequestMapping(value = "/qna_modify", method = RequestMethod.POST)
	public String postqna_modify(QnaVO qna, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr) throws Exception{
			
		int result = qService.qna_modify(qna);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		if(result == 1)
		{
			rttr.addFlashAttribute("msg", "success");
		} else {
			rttr.addFlashAttribute("msg", "fail");
		}
			return "redirect:/qna/qlist";
	}
	
	//문의 삭제
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@RequestMapping(value = "/qna_delete")
	public String qna_delete(QnaVO qna, int qna_id, RedirectAttributes rttr,
							 @ModelAttribute("cri") SearchCriteria cri) throws Exception{
		
		int result = qService.qna_delete(qna_id);
		qService.qna_id_d(qna);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		if(result == 1)
		{
			rttr.addFlashAttribute("msg", "success");
		} else {
			rttr.addFlashAttribute("msg", "fail");
		}
		
		return "redirect:/qna/qlist";
	}
	
	//답글 작성
	@RequestMapping(value = "/reply_write", method = RequestMethod.POST)
	public String reply_write(QnaVO qna, ReplyVO reply, SearchCriteria cri, RedirectAttributes rttr) throws Exception{
		
		rService.reply_write(reply);
		
		rttr.addAttribute("qna_id", reply.getQna_id());
		rttr.addAttribute("qna_category", qna.getQna_category());
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/qna/qlist";
	}

}
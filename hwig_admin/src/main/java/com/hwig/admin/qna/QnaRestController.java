package com.hwig.admin.qna;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/qna")
public class QnaRestController {

	/*
	 * @Inject QnaService qService;
	 * 
	 * @GetMapping("/qlist") public List<QnaVO> qlist(QnaVO qna) throws Exception{
	 * 
	 * List<QnaVO> nlist = qService.qList();
	 * 
	 * return nlist; }
	 * 
	 * @GetMapping("/qna_view") public QnaVO qna_view(@RequestParam("qna_id") int
	 * qna_id) throws Exception{
	 * 
	 * nService.notice_hit_up(notice_id);
	 * 
	 * return nService.notice_view(notice_id); }
	 */
}



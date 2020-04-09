package com.hwig.admin.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice")
public class NoticeRestController {

	@Inject
	NoticeService nService;
	
	/*
	 * @CrossOrigin
	 * 
	 * @GetMapping("/nlist_main") public List<NoticeVO> nlist() throws Exception {
	 * 
	 * return nService.nList(); }
	 */
	
	
}



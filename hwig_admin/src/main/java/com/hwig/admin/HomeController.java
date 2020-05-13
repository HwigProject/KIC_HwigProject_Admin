package com.hwig.admin;

import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hwig.admin.order.OrderVO;
import com.hwig.admin.qna.QnaService;

@Controller
public class HomeController {

	@Inject
	AdminService aService;
	
	@Inject
	QnaService qService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "index";
	}

	@RequestMapping("/main")
	public void main(Model model) throws Exception {
		model.addAttribute("qna_count", aService.qna_count());
		model.addAttribute("reply_count", aService.reply_count());
		model.addAttribute("member_count", aService.member_count());
		model.addAttribute("order_paymoney", aService.order_paymoney());
		model.addAttribute("qna_list", aService.qna_list());
		model.addAttribute("order_list", aService.order_list());
		model.addAttribute("prd_list", aService.prd_list());
		model.addAttribute("chart_circle", aService.chart_circle());
	}

}

package com.hwig.admin.product;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Inject
	ProductService service;

	@RequestMapping(value = "/prd_add", method=RequestMethod.GET)
	public void getAdd() throws Exception {
		
	}
	
	@RequestMapping(value = "/prd_add", method=RequestMethod.POST)
	public String postAdd(ProductVO vo, RedirectAttributes rttr) throws Exception {
		int result = service.add(vo);
		if(result == 1) {
			rttr.addFlashAttribute("msg", "success");
		}
		else {
			rttr.addFlashAttribute("msg", "fail");
		}
		
		return "redirect:/product/prd_waitlist_seller";
	}
	
	@RequestMapping(value = "/prd_waitlist", method=RequestMethod.GET)
	public List<ProductVO> getWaitList(Model model) throws Exception {
		
		List<ProductVO> waitList = service.waitList();
		model.addAttribute("waitList", waitList);
		
		return waitList;
	}
	
	@RequestMapping(value = "/prd_waitlist_seller", method=RequestMethod.GET)
	public List<ProductVO> getWaitListSeller(Model model) throws Exception {
		
		List<ProductVO> waitList = service.waitList();
		model.addAttribute("waitList", waitList);
		
		return waitList;
	}
	
	@RequestMapping(value = "/prd_list", method=RequestMethod.GET)
	public void getList() throws Exception {
		
	}
}

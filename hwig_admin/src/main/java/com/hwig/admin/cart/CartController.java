package com.hwig.admin.cart;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hwig.admin.product.ProductController;

@Controller
@RequestMapping("/cart/*")
public class CartController {
	
	@Inject
	CartService service;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	//상품 등록 - get
	@RequestMapping(value = "/cart_list", method=RequestMethod.GET)
	public List<Map<String,String>> getCartlist(@RequestParam("mem_id") String mem_id, Model model) throws Exception {
		List<Map<String,String>> cartlist = service.cartlist(mem_id);
		model.addAttribute("cartlist", cartlist);
		
		return cartlist;
	}
}

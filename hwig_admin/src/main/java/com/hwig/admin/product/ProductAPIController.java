package com.hwig.admin.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
@RequestMapping(value="/api/product")
public class ProductAPIController {
	
	@Inject
	ProductService service;

	
	@RequestMapping(value="/mainlist", method=RequestMethod.GET)
	public List<ProductListDTO> product(@RequestParam int category_p_id, @RequestParam int category_id) throws Exception {
		System.out.println("category => " + category_p_id + "and => " + category_id);
		System.out.println("mainlist 실행");
		return  service.mainlist(category_p_id);
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public Map<String, String> test( HttpSession session) {
		System.out.println("실행");
		Map<String, String> m = new HashMap<String, String>();
		m.put("aaa", "aaa");
		
		return m;
	}
}

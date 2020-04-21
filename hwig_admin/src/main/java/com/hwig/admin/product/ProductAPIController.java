package com.hwig.admin.product;

import java.util.ArrayList;
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

	//카테고리 정보 보내기
	@RequestMapping(value="/category", method=RequestMethod.GET)
	public TotalCategoryDTO category() throws Exception {
		System.out.println("category 목록 보내기 실행");
		
		List<CategoryDTO> catelist = service.category(); //DB에서 가져온 카테고리 전체목록
		
		TotalCategoryDTO tcategory = new TotalCategoryDTO();
		
		List<PCategoryDTO> pcategory = new ArrayList<PCategoryDTO>();
		List<LCategoryDTO> category = new ArrayList<LCategoryDTO>();
		
		if(catelist.size() < 1) {
			
		}
		else {
			for(CategoryDTO tcate : catelist) {
				PCategoryDTO cdto = new PCategoryDTO();
				int num = tcate.getCategory_p_id();
				if(num ==0) {
					cdto.setCategory_p_id(tcate.getCategory_p_id());
					cdto.setCategory_id(tcate.getCategory_id());
					cdto.setCategory_name(tcate.getCategory_name());
					pcategory.add(cdto);
				}
			}
			for(CategoryDTO tcate : catelist) {
				LCategoryDTO cdto = new LCategoryDTO();
				int num = tcate.getCategory_p_id();
				if(num != 0) {
					cdto.setCategory_p_id(tcate.getCategory_p_id());
					cdto.setCategory_id(tcate.getCategory_id());
					cdto.setCategory_name(tcate.getCategory_name());
					category.add(cdto);
				}
			}
		}
		
		tcategory.setPcategory(pcategory);
		tcategory.setCategory(category);
		
		return tcategory;
	}
	
	//상품 메인 상품목록 조회
	/*@RequestMapping(value="/mainlist", method=RequestMethod.GET)
	public List<ProductListDTO> product(@RequestParam int category_p_id, @RequestParam int category_id) throws Exception {
		System.out.println("category => " + category_p_id + " and => " + category_id);
		System.out.println("mainlist 실행");
		return  service.mainlist(category_p_id);
	}*/
	@RequestMapping(value="/mainlist", method=RequestMethod.GET)
	public ProductCateDTO productmain(@RequestParam int category_p_id) throws Exception {
		System.out.println("category => " + category_p_id );
		System.out.println("mainlist 실행");

		List<CategoryDTO> catelist = service.category(); //DB에서 가져온 카테고리 전체목록
		List<ProductListDTO> prolist = service.mainlist(category_p_id);
		
		ProductCateDTO procate = new ProductCateDTO();

		List<PCategoryDTO> pcategory = new ArrayList<PCategoryDTO>();
		List<LCategoryDTO> category = new ArrayList<LCategoryDTO>();
		
		if(catelist.size() < 1) {
			
		}
		else {
			for(CategoryDTO tcate : catelist) {
				PCategoryDTO cdto = new PCategoryDTO();
				int num = tcate.getCategory_p_id();
				int cnum = tcate.getCategory_id();
				if(num == 0 && cnum == category_p_id) {
					cdto.setCategory_p_id(tcate.getCategory_p_id());
					cdto.setCategory_id(tcate.getCategory_id());
					cdto.setCategory_name(tcate.getCategory_name());
					pcategory.add(cdto);
				}
			}
			for(CategoryDTO tcate : catelist) {
				LCategoryDTO cdto = new LCategoryDTO();
				int num = tcate.getCategory_p_id();
				if(num != 0 && num == category_p_id) {
					cdto.setCategory_p_id(tcate.getCategory_p_id());
					cdto.setCategory_id(tcate.getCategory_id());
					cdto.setCategory_name(tcate.getCategory_name());
					category.add(cdto);
				}
			}
		}
		
		procate.setPcategory(pcategory);
		procate.setCategory(category);
		procate.setProductlist(prolist);
		
		return procate;
	}

	//카테고리별 상품 조회
	@RequestMapping(value="/catelist", method=RequestMethod.GET)
	public ProductCateDTO product(@RequestParam int category_id) throws Exception {
		System.out.println("category_id => " + category_id);
		List<CategoryDTO> catelist = service.category(); //DB에서 가져온 카테고리 전체목록
		List<ProductListDTO> prolist = service.catelist(category_id); //카테고리별 상품 목록
		
		ProductCateDTO procate = new ProductCateDTO();
		
		List<PCategoryDTO> pcategory = new ArrayList<PCategoryDTO>();
		List<LCategoryDTO> category = new ArrayList<LCategoryDTO>();
		
		if(catelist.size() < 1) {
			
		}
		else {
			for(CategoryDTO tcate : catelist) {
				PCategoryDTO cdto = new PCategoryDTO();
				int num = tcate.getCategory_p_id();
				if(num ==0) {
					cdto.setCategory_p_id(tcate.getCategory_p_id());
					cdto.setCategory_id(tcate.getCategory_id());
					cdto.setCategory_name(tcate.getCategory_name());
					pcategory.add(cdto);
				}
			}
			for(CategoryDTO tcate : catelist) {
				LCategoryDTO cdto = new LCategoryDTO();
				int num = tcate.getCategory_p_id();
				if(num != 0) {
					cdto.setCategory_p_id(tcate.getCategory_p_id());
					cdto.setCategory_id(tcate.getCategory_id());
					cdto.setCategory_name(tcate.getCategory_name());
					category.add(cdto);
				}
			}
		}
		
		procate.setPcategory(pcategory);
		procate.setCategory(category);
		procate.setProductlist(prolist);
		
		return procate;
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public Map<String, String> test( HttpSession session) {
		System.out.println("실행");
		Map<String, String> m = new HashMap<String, String>();
		m.put("aaa", "aaa");
		
		return m;
	}
}

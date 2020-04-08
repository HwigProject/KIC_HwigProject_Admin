package com.hwig.admin.product;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Inject
	ProductService service;
	
	@Resource(name = "savePath")
	private String savePath;

	@Resource(name = "productAttachPath")
	private String productAttachPath;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@RequestMapping(value = "/prd_add", method=RequestMethod.GET)
	public void getAdd() throws Exception {
		
	}
	
	@RequestMapping(value = "/prd_add", method=RequestMethod.POST)
	public String postAdd(ProductVO vo, RedirectAttributes rttr, MultipartFile[] file) throws Exception {
		
		int count = 0;
		//이미지 저장 
		for(MultipartFile files : file) {
			System.out.println("for문 진입 성공");
			if (files.getOriginalFilename() != null && !files.getOriginalFilename().equals("")) {
				// 파일명 생성
				UUID uid = UUID.randomUUID();
				String fileName = uid.toString() + "_" + files.getOriginalFilename();
				logger.info("path = " + savePath + vo.getPrd_thumb());
	
				// 파일을 서버에 저장
					FileOutputStream fos = new FileOutputStream(savePath + productAttachPath + "/" + fileName);
					logger.info("파일 서버에 저장하는 부분 => " + savePath + productAttachPath + "/" + fileName);
					InputStream is = files.getInputStream();
	
					int readCount = 0;
					byte[] buffer = new byte[1024];
	
					while ((readCount = is.read(buffer)) != -1) {
						fos.write(buffer, 0, readCount);
					}
					fos.close();
					
					if(count == 0) {
						vo.setPrd_thumb(productAttachPath + "/" + fileName);
						System.out.println("썸네일 등록 : " + vo.getPrd_thumb());
					}
					else if(count == 1) {
						vo.setPrd_img(productAttachPath + "/" + fileName);
						System.out.println("설명 이미지 등록 : " + vo.getPrd_img());
					}
					count++;
			}
		}
		
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

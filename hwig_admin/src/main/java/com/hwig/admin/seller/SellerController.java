package com.hwig.admin.seller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hwig.admin.common.PageMaker;
import com.hwig.admin.common.SearchCriteria;

@Controller
@RequestMapping("/seller/*")
public class SellerController {

	@Resource(name = "savePath")
	private String savePath;

	@Resource(name = "sellerAttachPath")
	private String sellerAttachPath;

	@Autowired
	private SellerService sellerService;

	private static final Logger logger = LoggerFactory.getLogger(SellerController.class);

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) {
		logger.info(cri.toString());

		model.addAttribute("list", sellerService.listAll(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(sellerService.listAllCount(cri));

		model.addAttribute("pageMaker", pageMaker);
	}

	@RequestMapping(value = "/modifyForm", method = RequestMethod.GET)
	public void modifyPageGET(String sel_id, @ModelAttribute("cri") SearchCriteria cri, Model model) {
		model.addAttribute("data", sellerService.findOneById(sel_id));
		model.addAttribute("page", cri.getPage());
		model.addAttribute("perPageNum", cri.getPerPageNum());
		model.addAttribute("searchType", cri.getSearchType());
		model.addAttribute("keyword", cri.getKeyword());
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPagePOST(SellerVO sellerVo, MultipartFile attach_img, @ModelAttribute("cri") SearchCriteria cri,
			RedirectAttributes rttr, HttpSession session) {
		logger.info(sellerVo.toString());

		if (attach_img != null && !attach_img.getOriginalFilename().equals("")) {
			// �뙆�씪紐� �깮�꽦
			UUID uid = UUID.randomUUID();
			String fileName = uid.toString() + "_" + attach_img.getOriginalFilename();
			logger.info(savePath + sellerVo.getOrigin_img());
			new File(savePath + sellerVo.getOrigin_img()).delete();

			// �뙆�씪�쓣 �꽌踰꾩뿉 ���옣
			try {
				FileOutputStream fos = new FileOutputStream(savePath + sellerAttachPath + "/" + fileName);
				logger.info("�뙆�씪 �꽌踰꾩뿉 ���옣�븯�뒗 遺�遺� => " + savePath + sellerAttachPath + "/" + fileName);
				InputStream is = attach_img.getInputStream();

				int readCount = 0;
				byte[] buffer = new byte[1024];

				while ((readCount = is.read(buffer)) != -1) {
					fos.write(buffer, 0, readCount);
				}
				fos.close();
				String path = session.getServletContext().getRealPath("/");
				System.out.println("�뼚path:::" + path);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// ���옣�맂 �뙆�씪�젙蹂� �뀑�똿
			sellerVo.setSel_img(sellerAttachPath + "/" + fileName);
		} else {
			sellerVo.setSel_img(sellerVo.getOrigin_img());
		}

		// �뙆�씪 �젙蹂� �룷�븿�빐�꽌 DB�뿉 ���옣
		int result = sellerService.modify(sellerVo);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		if (result == 1) {
			rttr.addFlashAttribute("msg", "success");
		} else {
			rttr.addFlashAttribute("msg", "fail");
		}

		logger.info(rttr.toString());

		return "redirect:/seller/list";
	}

	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public void registerPageGET() {

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPagePOST(SellerVO sellerVo, MultipartFile attach_img, RedirectAttributes rttr) {
		if (attach_img != null && !attach_img.getOriginalFilename().equals("")) {
			// �뙆�씪紐� �깮�꽦
			UUID uid = UUID.randomUUID();
			String fileName = uid.toString() + "_" + attach_img.getOriginalFilename();
			logger.info(savePath + sellerVo.getOrigin_img());

			// �뙆�씪�쓣 �꽌踰꾩뿉 ���옣
			try {
				FileOutputStream fos = new FileOutputStream(savePath + sellerAttachPath + "/" + fileName);
				logger.info("�뙆�씪 �꽌踰꾩뿉 ���옣�븯�뒗 遺�遺� => " + savePath + sellerAttachPath + "/" + fileName);
				InputStream is = attach_img.getInputStream();

				int readCount = 0;
				byte[] buffer = new byte[1024];

				while ((readCount = is.read(buffer)) != -1) {
					fos.write(buffer, 0, readCount);
				}
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// ���옣�맂 �뙆�씪�젙蹂� �뀑�똿
			sellerVo.setSel_img(sellerAttachPath + "/" + fileName);
		}

		// 鍮꾨�踰덊샇 �븫�샇�솕 �옉�뾽
		String inputPass = sellerVo.getSel_pw();
		PasswordEncoder passEncoder = new BCryptPasswordEncoder();
		String pass = passEncoder.encode(inputPass);
		sellerVo.setSel_pw(pass);

		int result = sellerService.register(sellerVo);

		if (result == 1) {
			rttr.addFlashAttribute("msg", "success");
		}

		return "redirect:/seller/list";
	}

	@ResponseBody
	@RequestMapping(value = "/one/{sel_id}", method = RequestMethod.GET)
	public SellerVO one(@PathVariable("sel_id") String sel_id) {
		SellerVO sellerVo = sellerService.findOneById(sel_id);

		if (sellerVo == null) {
			SellerVO emptyVo = new SellerVO();
			emptyVo.empty();
			return emptyVo;
		}

		return sellerVo;
	}

	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public void accountPage() {
	}

	@RequestMapping(value = "/changePw", method = RequestMethod.POST)
	public String changePw(SellerPwDTO sellerPwDto, RedirectAttributes rttr) {
		String inputPass = sellerPwDto.getSel_pw();
		PasswordEncoder passEncoder = new BCryptPasswordEncoder();
		String pass = passEncoder.encode(inputPass);
		sellerPwDto.setSel_pw(pass);

		int result = sellerService.pwModify(sellerPwDto);

		if (result == 1) {
			rttr.addFlashAttribute("msg", "success");
		} else {
			rttr.addFlashAttribute("msg", "fail");
		}

		return "redirect:/seller/account";
	}

}

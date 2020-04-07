package com.hwig.admin.faq;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class FaqServiceImpl implements FaqService{
	
	@Inject
	FaqDAO dao;
	
	//자주묻는질문 목록
	@Override
	public List<FaqVO> fList() throws Exception {
		
		return dao.fList();
	}
	
	//자주묻는질문 등록
	@Override
	public void faq_write(FaqVO faq) throws Exception {
		
		dao.faq_write(faq);
	}
	
	//자주묻는질문 조회
	@Override
	public FaqVO faq_view(int faq_id) throws Exception {

		return dao.faq_view(faq_id);
	}
	
	//자주묻는질문 수정
	@Override
	public void faq_modify(FaqVO faq) throws Exception {
		
		dao.faq_modify(faq);
	}
	
	//자주묻는질문 삭제
	@Override
	public void faq_delete(int faq_id) throws Exception {
		
		dao.faq_delete(faq_id);
	}
	
	//게시글 삭제시 번호 한칸씩 땡겨옴
	@Override
	public void faq_id_d(FaqVO faq) throws Exception {
		
		dao.faq_id_d(faq);
	}
	
	
	
	
	

}

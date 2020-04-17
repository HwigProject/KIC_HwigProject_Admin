package com.hwig.admin.faq;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hwig.admin.common.SearchCriteria;

@Service
public class FaqServiceImpl implements FaqService{
	
	@Inject
	FaqDAO dao;
	
	//자주묻는질문 목록
	@Override
	public List<FaqVO> fList(SearchCriteria cri) throws Exception {
		
		return dao.fList(cri);
	}
	
	//전체 개수 카운트
	@Override
	public int listCount(SearchCriteria cri) throws Exception {
		
		return dao.listCount(cri);
	}
	
	//자주묻는질문 등록
	@Override
	public int faq_write(FaqVO faq) throws Exception {
		
		return dao.faq_write(faq);
	}
	
	//자주묻는질문 조회
	@Override
	public FaqVO faq_view(int faq_id) throws Exception {

		return dao.faq_view(faq_id);
	}
	
	//자주묻는질문 수정
	@Override
	public int faq_modify(FaqVO faq) throws Exception {
		
		return dao.faq_modify(faq);
	}
	
	//자주묻는질문 삭제
	@Override
	public int faq_delete(int faq_id) throws Exception {
		
		return dao.faq_delete(faq_id);
	}
	
	//게시글 삭제시 번호 한칸씩 땡겨옴
	@Override
	public void faq_id_d(FaqVO faq) throws Exception {
		
		dao.faq_id_d(faq);
	}

	@Override
	public List<FaqVO> fList_main() throws Exception {
		
		return dao.fList_main();
	}
}

package com.hwig.admin.faq;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hwig.admin.common.SearchCriteria;

@Service
public class FaqServiceImpl implements FaqService{
	
	@Inject
	FaqDAO dao;
	
	//���ֹ������� ���
	@Override
	public List<FaqVO> fList(SearchCriteria cri) throws Exception {
		
		return dao.fList(cri);
	}
	
	//��ü ���� ī��Ʈ
	@Override
	public int listCount(SearchCriteria cri) throws Exception {
		
		return dao.listCount(cri);
	}
	
	//���ֹ������� ���
	@Override
	public int faq_write(FaqVO faq) throws Exception {
		
		return dao.faq_write(faq);
	}
	
	//���ֹ������� ��ȸ
	@Override
	public FaqVO faq_view(int faq_id) throws Exception {

		return dao.faq_view(faq_id);
	}
	
	//���ֹ������� ����
	@Override
	public int faq_modify(FaqVO faq) throws Exception {
		
		return dao.faq_modify(faq);
	}
	
	//���ֹ������� ����
	@Override
	public int faq_delete(int faq_id) throws Exception {
		
		return dao.faq_delete(faq_id);
	}
	
	//�Խñ� ������ ��ȣ ��ĭ�� ���ܿ�
	@Override
	public void faq_id_d(FaqVO faq) throws Exception {
		
		dao.faq_id_d(faq);
	}

	@Override
	public List<FaqVO> fList_main() throws Exception {
		
		return dao.fList_main();
	}
}

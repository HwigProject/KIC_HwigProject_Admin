package com.hwig.admin.faq;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class FaqServiceImpl implements FaqService{
	
	@Inject
	FaqDAO dao;
	
	//���ֹ������� ���
	@Override
	public List<FaqVO> fList() throws Exception {
		
		return dao.fList();
	}
	
	//���ֹ������� ���
	@Override
	public void faq_write(FaqVO faq) throws Exception {
		
		dao.faq_write(faq);
	}
	
	//���ֹ������� ��ȸ
	@Override
	public FaqVO faq_view(int faq_id) throws Exception {

		return dao.faq_view(faq_id);
	}
	
	//���ֹ������� ����
	@Override
	public void faq_modify(FaqVO faq) throws Exception {
		
		dao.faq_modify(faq);
	}
	
	//���ֹ������� ����
	@Override
	public void faq_delete(int faq_id) throws Exception {
		
		dao.faq_delete(faq_id);
	}
	
	//�Խñ� ������ ��ȣ ��ĭ�� ���ܿ�
	@Override
	public void faq_id_d(FaqVO faq) throws Exception {
		
		dao.faq_id_d(faq);
	}
	
	
	
	
	

}

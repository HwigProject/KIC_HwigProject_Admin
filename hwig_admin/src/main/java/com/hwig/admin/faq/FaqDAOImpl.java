package com.hwig.admin.faq;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class FaqDAOImpl implements FaqDAO {
	
	@Inject
	private SqlSession sql;
	
	//mapper
	private static String namespace = "com.hwig.mappers.faqMapper";

	//���ֹ������� ���
	@Override
	public List<FaqVO> fList() throws Exception {
		
		return sql.selectList(namespace + ".fList");
	}
	
	//���ֹ������� ���
	@Override
	public int faq_write(FaqVO faq) throws Exception {
		
		return sql.insert(namespace + ".faq_write", faq);
	}
	
	//���ֹ������� ��ȸ
	@Override
	public FaqVO faq_view(int faq_id) throws Exception {
		
		return sql.selectOne(namespace + ".faq_view", faq_id);
	}
	
	//���ֹ������� ����
	@Override
	public int faq_modify(FaqVO faq) throws Exception {
		
		return sql.update(namespace + ".faq_modify", faq);
	}
	
	//���ֹ������� ����
	@Override
	public int faq_delete(int faq_id) throws Exception {
		
		return sql.delete(namespace + ".faq_delete", faq_id);
	}

	//�Խñ� ������ ��ȣ �ϳ��� ����
	@Override
	public void faq_id_d(FaqVO faq) throws Exception {
		
		sql.update(namespace + ".faq_id_d", faq);	
	}
	
	
	
}

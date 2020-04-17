package com.hwig.admin.notice;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hwig.admin.common.SearchCriteria;

@Repository
public class NoticeDAOImpl implements NoticeDAO{
	
	@Inject
	private SqlSession sql;
	
	//mapper
	private static String namespace = "com.hwig.admin.mappers.noticeMapper";
	
	//�������� ���
	@Override
	public List<NoticeVO> nList(SearchCriteria cri) throws Exception {
		
		return sql.selectList(namespace + ".nList", cri);
	}
	
	//��ü ���� ����
	@Override
	public int listCount(SearchCriteria cri) throws Exception {
		
		return sql.selectOne(namespace + ".listCount", cri);
	}
	
	//�������� ���
	@Override
	public int notice_write(NoticeVO notice) throws Exception {
		
		return sql.insert(namespace + ".notice_write", notice);
	}
	
	//�������� ��ȸ
	@Override
	public NoticeVO notice_view(int notice_id) throws Exception {
		
		return sql.selectOne(namespace + ".notice_view", notice_id);
	}
	
	//�������� ��ȸ�� ����
	 @Override 
	 public int notice_hit_up(int notice_id) throws Exception {
	  
		 return sql.update(namespace + ".notice_hit_up", notice_id); 
	 }
	 
	
	//�������� ����
	@Override
	public int notice_modify(NoticeVO notice) throws Exception {
		
		return sql.update(namespace + ".notice_modify", notice);
	}
	
	//�������� ����
	@Override
	public int notice_delete(int notice_id) throws Exception {
		
		return sql.delete(namespace + ".notice_delete", notice_id);
		
	}
	
	//�������� ������ ��ȣ ����
	@Override
	public void notice_id_d(NoticeVO notice) throws Exception {
		
		sql.update(namespace + ".notice_id_d", notice);
	}
	
	//�������� ��� ����������
	@Override
	public List<NoticeVO> nList_main() throws Exception {
		
		return sql.selectList(namespace + ".nlist_main");
	}
}

package com.hwig.admin.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Inject
	NoticeDAO dao;
	
	//�������� ���
	@Override
	public List<NoticeVO> nList() throws Exception {
		
		return dao.nList();
	}
	
	//�������� ���
	@Override
	public void notice_write(NoticeVO notice) throws Exception {
		
		dao.notice_write(notice);
	}
	
	//�������� ��ȸ
	@Override
	public NoticeVO notice_view(int notice_id) throws Exception {
		
		return dao.notice_view(notice_id);
	}
	
	//�������� ����
	@Override
	public void notice_modify(NoticeVO notice) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	//�������� ����
	@Override
	public void notice_delete(int notice_id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	//�������� ������ ��ȣ ����
	@Override
	public void notice_id_d(NoticeVO notice) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

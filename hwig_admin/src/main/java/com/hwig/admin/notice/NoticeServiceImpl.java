package com.hwig.admin.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Inject
	NoticeDAO dao;
	
	//공지사항 목록
	@Override
	public List<NoticeVO> nList() throws Exception {
		
		return dao.nList();
	}
	
	//공지사항 등록
	@Override
	public void notice_write(NoticeVO notice) throws Exception {
		
		dao.notice_write(notice);
	}
	
	//공지사항 조회
	@Override
	public NoticeVO notice_view(int notice_id) throws Exception {
		
		return dao.notice_view(notice_id);
	}
	
	//공지사항 수정
	@Override
	public void notice_modify(NoticeVO notice) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	//공지사항 삭제
	@Override
	public void notice_delete(int notice_id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	//공지사항 삭제시 번호 땡김
	@Override
	public void notice_id_d(NoticeVO notice) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

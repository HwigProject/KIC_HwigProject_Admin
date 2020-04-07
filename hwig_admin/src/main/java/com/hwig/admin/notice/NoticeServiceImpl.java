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
	public int notice_write(NoticeVO notice) throws Exception {
		
		return dao.notice_write(notice);
	}
	
	//공지사항 조회
	@Override
	public NoticeVO notice_view(int notice_id) throws Exception {
		
		return dao.notice_view(notice_id);
	}
	
	//공지사항 조회수 증가
	/*
	 * @Override public int notice_hit_up(int notice_id) throws Exception {
	 * 
	 * return dao.notice_hit_up(notice_id); }
	 */
	
	//공지사항 수정
	@Override
	public int notice_modify(NoticeVO notice) throws Exception {
		
		return dao.notice_modify(notice);
	}
	
	//공지사항 삭제
	@Override
	public int notice_delete(int notice_id) throws Exception {
		
		return dao.notice_delete(notice_id);
	}
	
	//공지사항 삭제시 번호 땡김
	@Override
	public void notice_id_d(NoticeVO notice) throws Exception {
		
		dao.notice_id_d(notice);
	}

	

}

package com.hwig.admin.notice;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAOImpl implements NoticeDAO{
	
	@Inject
	private SqlSession sql;
	
	//mapper
	private static String namespace = "com.hwig.mappers.noticeMapper";
	
	//공지사항 목록
	@Override
	public List<NoticeVO> nList() throws Exception {
		
		return sql.selectList(namespace + ".nList");
	}
	
	//공지사항 등록
	@Override
	public void notice_write(NoticeVO notice) throws Exception {
		
		sql.insert(namespace + ".notice_write", notice);
	}
	
	//공지사항 조회
	@Override
	public NoticeVO notice_view(int notice_id) throws Exception {
		
		return sql.selectOne(namespace + ".notice_view", notice_id);
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

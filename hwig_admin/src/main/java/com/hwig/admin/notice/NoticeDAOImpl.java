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
	private static String namespace = "com.hwig.mappers.noticeMapper";
	
	//공지사항 목록
	@Override
	public List<NoticeVO> nList(SearchCriteria cri) throws Exception {
		
		return sql.selectList(namespace + ".nList", cri);
	}
	
	//전체 개수 세기
	@Override
	public int listCount(SearchCriteria cri) throws Exception {
		
		return sql.selectOne(namespace + ".listCount", cri);
	}
	
	//공지사항 등록
	@Override
	public int notice_write(NoticeVO notice) throws Exception {
		
		return sql.insert(namespace + ".notice_write", notice);
	}
	
	//공지사항 조회
	@Override
	public NoticeVO notice_view(int notice_id) throws Exception {
		
		return sql.selectOne(namespace + ".notice_view", notice_id);
	}
	
	//공지사항 조회수 증가
	 @Override 
	 public int notice_hit_up(int notice_id) throws Exception {
	  
		 return sql.update(namespace + ".notice_hit_up", notice_id); 
	 }
	 
	
	//공지사항 수정
	@Override
	public int notice_modify(NoticeVO notice) throws Exception {
		
		return sql.update(namespace + ".notice_modify", notice);
	}
	
	//공지사항 삭제
	@Override
	public int notice_delete(int notice_id) throws Exception {
		
		return sql.delete(namespace + ".notice_delete", notice_id);
		
	}
	
	//공지사항 삭제시 번호 땡김
	@Override
	public void notice_id_d(NoticeVO notice) throws Exception {
		
		sql.update(namespace + ".notice_id_d", notice);
	}
	
	//공지사항 목록 메인페이지
	@Override
	public List<NoticeVO> nList_main() throws Exception {
		
		return sql.selectList(namespace + ".nlist_main");
	}
}

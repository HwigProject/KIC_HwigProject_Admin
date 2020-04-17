package com.hwig.admin.reply;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	@Inject
	private SqlSession sql;
	
	//mapper
	private static String namespace = "com.hwig.mappers.replyMapper";
	
	//답글 조회
	@Override
	public ReplyVO reply_view(int qna_id) throws Exception {
		
		return sql.selectOne(namespace + ".reply_view", qna_id);
	}
	
	//답글 작성
	@Override
	public void reply_write(ReplyVO reply) throws Exception {
		
		sql.insert(namespace + ".reply_write", reply);
	}
	
	//답글 매크로
	@Override
	public MacroVO macro_view(String qna_category) throws Exception {
		
		return sql.selectOne(namespace + ".macro_view", qna_category);
	}
	
	//답글 수정
	@Override
	public void reply_modify(ReplyVO reply) throws Exception {
		
		sql.update(namespace + ".reply_modify", reply);
	}
	
	//답글 삭제
	@Override
	public void reply_delete(ReplyVO reply) throws Exception {
		
		sql.delete(namespace + ".reply_delete", reply);
	}
	
	//매크로 본문 버튼 목록
	@Override
	public List<MacroVO> macro_c_list(String qna_category) throws Exception {
		
		return sql.selectList(namespace + ".macro_c_list", qna_category);
	}
	
	//양식 관리 페이지 본문 목록
	@Override
	public List<MacroVO> macro_list() throws Exception {
		
		return sql.selectList(namespace + ".macro_list");
	}
	
	//양식 관리 페이지 머리,꼬리 목록
	@Override
	public List<MacroVO> macro_ht_list() throws Exception {
		
		return sql.selectList(namespace + ".macro_ht_list");
	}
	
	//머리,꼬리 수정
	@Override
	public int macro_ht_modify(MacroVO macro) throws Exception {
		
		return sql.update(namespace + ".macro_ht_mod", macro);
	}
	
	//본문 양식 추가
	@Override
	public int macro_write(MacroVO macro) throws Exception {
		
		return sql.insert(namespace + ".macro_write", macro);
	}

	@Override
	public int macro_modify(MacroVO macro) throws Exception {
		
		return sql.update(namespace + ".macro_modify", macro);
	}

	@Override
	public MacroVO macro_c_view(int macro_c_id) throws Exception {
		
		return sql.selectOne(namespace + ".macro_c_view", macro_c_id);
	}

	@Override
	public int macro_delete(int macro_c_id) throws Exception {
		
		return sql.delete(namespace + ".macro_delete", macro_c_id);
	}

	@Override
	public void macro_id_d(MacroVO macro) throws Exception {
		
		sql.update(namespace + ".macro_id_d", macro);
	}

	@Override
	public List<ReplyVO> rList(String mem_id) throws Exception {
		
		return sql.selectList(namespace + ".rList", mem_id);
	}
}

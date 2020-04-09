package com.hwig.admin.reply;

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
}

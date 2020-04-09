package com.hwig.admin.reply;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Inject
	ReplyDAO dao;
	
	@Override
	public ReplyVO reply_view(int qna_id) throws Exception {
		
		return dao.reply_view(qna_id);
	}

	@Override
	public void reply_write(ReplyVO reply) throws Exception {
		
		dao.reply_write(reply);
	}

	@Override
	public MacroVO macro_view(String qna_category) throws Exception {
		
		return dao.macro_view(qna_category);
	}

}

package com.hwig.admin.reply;

public interface ReplyService {
	
	public ReplyVO reply_view(int qna_id) throws Exception;
	public void reply_write(ReplyVO reply) throws Exception;
	public MacroVO macro_view(String qna_category) throws Exception;
}

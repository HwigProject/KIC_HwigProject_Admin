package com.hwig.admin.qna;

import java.util.List;

import com.hwig.admin.common.SearchCriteria;
import com.hwig.admin.faq.FaqVO;

public interface QnaDAO {
	public List<QnaVO> qList(SearchCriteria cri) throws Exception;
	public int listCount(SearchCriteria cri) throws Exception;
	public int qna_write(QnaVO faq) throws Exception;
	public QnaVO qna_view(int qna_id) throws Exception;
	public int qna_modify(QnaVO qna) throws Exception;
	public int qna_delete(int qna_id) throws Exception;
	public void qna_id_d(QnaVO qna) throws Exception;
	
}

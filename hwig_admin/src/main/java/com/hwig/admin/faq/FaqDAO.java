package com.hwig.admin.faq;

import java.util.List;

public interface FaqDAO {
	public List<FaqVO> fList() throws Exception;
	public int faq_write(FaqVO faq) throws Exception;
	public FaqVO faq_view(int faq_id) throws Exception;
	public int faq_modify(FaqVO faq) throws Exception;
	public int faq_delete(int faq_id) throws Exception;
	public void faq_id_d(FaqVO faq) throws Exception;
}

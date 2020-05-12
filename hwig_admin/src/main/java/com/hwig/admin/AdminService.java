package com.hwig.admin;

import java.util.List;

import com.hwig.admin.order.OrderVO;
import com.hwig.admin.product.ProductVO;
import com.hwig.admin.qna.QnaVO;

public interface AdminService {

	public AdminVO login(String admin_id, String admin_pw);
	public int qna_count();
	public int reply_count();
	public int member_count();
	public int order_paymoney();
	public List<QnaVO> qna_list();
	public List<OrderVO> order_list();
	public List<ProductVO> prd_list();
	public List<ProductVO> chart_circle();
}

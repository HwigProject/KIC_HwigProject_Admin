package com.hwig.admin;

import java.util.List;

import com.hwig.admin.order.OrderVO;
import com.hwig.admin.product.ProductVO;
import com.hwig.admin.qna.QnaVO;

public interface AdminDAO {

	public AdminVO select(AdminVO adminVo);
	public int qna_select();
	public int reply_select();
	public int member_select();
	public int order_paymoney();
	public List<QnaVO> qna_list();
	public List<OrderVO> order_list();
	public List<ProductVO> prd_list();
}

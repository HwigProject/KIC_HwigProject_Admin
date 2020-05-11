package com.hwig.admin;

import java.util.List;

import com.hwig.admin.order.OrderVO;
import com.hwig.admin.product.ProductVO;
import com.hwig.admin.qna.QnaVO;

public interface AdminDAO {

	public AdminVO select(AdminVO adminVo);
	public IndexVO qna_select();
	public IndexVO reply_select();
	public IndexVO member_select();
	public IndexVO order_paymoney();
	public List<QnaVO> qna_list();
	public List<OrderVO> order_list();
	public List<ProductVO> prd_list();
}

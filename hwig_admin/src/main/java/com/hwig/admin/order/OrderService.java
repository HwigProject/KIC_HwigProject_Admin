package com.hwig.admin.order;

import java.util.List;

public interface OrderService {
	
	public List<OrderVO> listAll(OrderCriteria cri);
	
	public int listAllCount(OrderCriteria cri);
	
	public OrderDetailDTO findOneById(String order_id);
	
	public int register(OrderRegisterDTO orderRegisterDto);
	
	public int statusModify(OrderVO orderVo);

}

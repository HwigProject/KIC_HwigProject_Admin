package com.hwig.admin.order;

import java.util.List;

public interface OrderService {
	
	public List<OrderVO> listAll(OrderCriteria cri);
	
	public int listAllCount(OrderCriteria cri);

}

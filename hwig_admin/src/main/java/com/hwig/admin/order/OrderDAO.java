package com.hwig.admin.order;

import java.util.List;

public interface OrderDAO {
	
	public List<OrderVO> selectAllBySeller(OrderCriteria cri);
	
	public int selectAllCountBySeller(OrderCriteria cri);
	
public List<OrderVO> selectAllByAdmin(OrderCriteria cri);
	
	public int selectAllCountByAdmin(OrderCriteria cri);
	
}

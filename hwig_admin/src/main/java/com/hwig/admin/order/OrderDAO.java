package com.hwig.admin.order;

import java.util.List;

public interface OrderDAO {
	
	public List<OrderVO> selectAllBySeller(OrderCriteria cri);
	
	public int selectAllCountBySeller(OrderCriteria cri);
	
	public List<OrderVO> selectAllByAdmin(OrderCriteria cri);
	
	public int selectAllCountByAdmin(OrderCriteria cri);
	
	public OrderDetailDTO selectDetail(OrderDetailDTO orderDto);
	
	public List<OrderDetailPrdDTO> selectDetailPrd(String order_id);
	
	public int orderVoInsert(OrderVO orderVo);
	
	public int orderBVoInsert(OrderBVO orderBVo);
	
	public int orderAddrVoInsert(OrderAddrVO orderAddrVo);
	
}

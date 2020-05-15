package com.hwig.admin.cart;

import java.util.List;
import java.util.Map;

public interface CartService {
	//장바구니 목록 가져오기
	public List<CartlistDTO> cartList(String mem_id) throws Exception;

	//장바구니 등록
	public int cartInsert(CartVO vo) throws Exception;
	
	//장바구니 삭제
	public void cartDelete(Map<String, Object> cmap) throws Exception;
	
	public int cartPrdRemove(String order_id);
}

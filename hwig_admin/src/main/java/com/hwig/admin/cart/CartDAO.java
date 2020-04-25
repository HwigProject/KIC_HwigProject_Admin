package com.hwig.admin.cart;

import java.util.List;
import java.util.Map;

public interface CartDAO {
	//장바구니 목록 가져오기
	public List<CartlistDTO> cartList(String mem_id) throws Exception;
	
	//장바구니 등록
	public int cartInsert(CartVO vo) throws Exception;
	
	//장바구니 삭제
	public void cartDelete(List<CartdeleteDTO> listdto) throws Exception;
}

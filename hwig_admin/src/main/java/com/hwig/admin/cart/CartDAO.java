package com.hwig.admin.cart;

import java.util.List;
import java.util.Map;

public interface CartDAO {
	//장바구니 목록 가져오기
	public List<Map<String,String>> cartlist(String mem_id) throws Exception;
}

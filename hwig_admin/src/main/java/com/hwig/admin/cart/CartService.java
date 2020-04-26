package com.hwig.admin.cart;

import java.util.List;
import java.util.Map;

public interface CartService {
	// �옣諛붽뎄�땲 紐⑸줉 媛��졇�삤湲�
	public List<Map<String, String>> cartlist(String mem_id) throws Exception;

}

package com.hwig.admin.cart;

import java.util.List;
import java.util.Map;

public interface CartDAO {
	public List<Map<String, String>> cartlist(String mem_id) throws Exception;
}

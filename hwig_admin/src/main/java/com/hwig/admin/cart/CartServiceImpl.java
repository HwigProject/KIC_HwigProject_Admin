package com.hwig.admin.cart;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

@Repository
public class CartServiceImpl implements CartService {

	@Inject
	private CartDAO dao;

	@Override
	public List<Map<String, String>> cartlist(String mem_id) throws Exception {
		return dao.cartlist(mem_id);
	}

}

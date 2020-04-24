package com.hwig.admin.cart;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class CartDAOImpl implements CartDAO{

	//mybatis
	@Inject
	private SqlSession sql;
	
	//mapper
	@Inject
	private static String namespace = "com.hwig.admin.mappers.cartMapper";
	
	//장바구니 목록 가져오기
	@Override
	public List<CartlistDTO> cartList(String mem_id) throws Exception {
		return sql.selectList(namespace + ".cartlist", mem_id);
	}
	
	//장바구니 등록
	@Override
	public int cartInsert(CartVO vo) throws Exception {
		return sql.insert(namespace + ".cartinsert", vo);
	}

}

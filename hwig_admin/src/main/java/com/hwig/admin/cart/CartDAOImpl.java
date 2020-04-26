package com.hwig.admin.cart;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class CartDAOImpl implements CartDAO {

	// mybatis
	@Inject
	private SqlSession sql;

	// mapper
	@Inject
	private static String namespace = "com.hwig.admin.mappers.cartMapper";

	@Override
	public List<Map<String, String>> cartlist(String mem_id) throws Exception {
		return sql.selectList(namespace + ".cartlist", mem_id);
	}
}

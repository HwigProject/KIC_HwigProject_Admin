package com.hwig.admin.product;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO{

	//mybatis
	@Inject
	private SqlSession sql;
	
	//mapper
	@Inject
	private static String namespace = "com.hwig.admin.mappers.productMapper";

	@Override
	public List<ProductVO> waitList() throws Exception {
		return sql.selectList(namespace + ".waitList");
	}
	
	
}

package com.hwig.admin.product;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

@Repository
public class ProductServiceImpl implements ProductService{

	@Inject
	private ProductDAO dao;

	@Override
	public int add(ProductVO vo) throws Exception {
		return dao.add(vo);
	}
	
	@Override
	public List<ProductVO> waitList() throws Exception {
		
		return dao.waitList();
	}

	
}

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
	
	//등록 완료 목록 조회
	@Override
	public List<ProductVO> list() throws Exception {
		return dao.list();
	}
	
	@Override
	public int delete(int prd_id) throws Exception {
		return dao.delete(prd_id);
	}

	@Override
	public int addList(int prd_id) throws Exception {
		return dao.addList(prd_id);
	}

	

	
}

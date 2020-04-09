package com.hwig.admin.product;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.hwig.admin.common.SearchCriteria;

@Repository
public class ProductServiceImpl implements ProductService{

	@Inject
	private ProductDAO dao;

	@Override
	public int add(ProductVO vo) throws Exception {
		return dao.add(vo);
	}
	
	//리스트 갯수 세기
	@Override
	public int listAllCount(SearchCriteria cri) {
		return dao.selectAllCount(cri);
	}
	
	@Override
	public List<ProductVO> waitList(SearchCriteria cri) throws Exception {
		
		return dao.waitList(cri);
	}
	
	//등록 완료 목록 조회
	@Override
	public List<ProductVO> list(SearchCriteria cri) throws Exception {
		return dao.list(cri);
	}
	
	@Override
	public int delete(int prd_id) throws Exception {
		return dao.delete(prd_id);
	}

	@Override
	public int addList(int prd_id) throws Exception {
		return dao.addList(prd_id);
	}

	//등록 완료 상품 삭제
	@Override
	public int deletelist(int prd_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.deletelist(prd_id);
	}
	
}

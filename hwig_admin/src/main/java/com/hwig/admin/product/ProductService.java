package com.hwig.admin.product;

import java.util.List;

public interface ProductService {

	//상품 등록
	public int add(ProductVO vo) throws Exception;
	
	//상품 승인 예정 목록 조회
	public List<ProductVO> waitList() throws Exception;
	
	//등록 완료 목록 조회
	public List<ProductVO> list() throws Exception;
	
	public int delete(int prd_id) throws Exception;
	
	//등록 예정 상품을 등록 완료 리스트로 넘김
	public int addList(int prd_id) throws Exception;
}

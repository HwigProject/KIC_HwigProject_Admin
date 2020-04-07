package com.hwig.admin.product;

import java.util.List;

public interface ProductService {

	//상품 등록
	public int add(ProductVO vo) throws Exception;
	//상품 승인 예정 목록 조회
	public List<ProductVO> waitList() throws Exception;
}

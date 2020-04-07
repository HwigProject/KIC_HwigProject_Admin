package com.hwig.admin.product;

import java.util.List;

public interface ProductDAO {

	//상품 등록
	public int add(ProductVO vo) throws Exception;
	//등록 예정 리스트 조회
	public List<ProductVO> waitList() throws Exception;
}

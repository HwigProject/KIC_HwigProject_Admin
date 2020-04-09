package com.hwig.admin.product;

import java.util.List;

import com.hwig.admin.common.SearchCriteria;

public interface ProductDAO {

	//상품 등록
	public int add(ProductVO vo) throws Exception;
	
	//리스트 갯수 세기
	public int selectAllCount(SearchCriteria cri);
	
	//등록 예정 리스트 조회
	public List<ProductVO> waitList(SearchCriteria cri) throws Exception;
	
	//등록 완료 목록 조회
	public List<ProductVO> list(SearchCriteria cri) throws Exception;
	
	//예정 상품 삭제
	public int delete(int prd_id) throws Exception;
	
	//등록 완료 상품 삭제
	public int deletelist(int prd_id) throws Exception;
	
	//등록 예정 상품을 등록 완료 리스트로 넘김
	public int addList(int prd_id) throws Exception;
}

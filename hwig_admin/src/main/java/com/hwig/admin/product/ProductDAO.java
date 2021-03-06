package com.hwig.admin.product;

import java.util.List;
import java.util.Map;

import com.hwig.admin.common.SearchCriteria;

public interface ProductDAO {

	//상품 등록
	public int add(ProductVO vo) throws Exception;
	
	//리스트 갯수 세기(등록예정)
	public int selectAllCountb(SearchCriteria cri);
	
	//리스트 갯수 세기(등록완료)
	public int selectAllCount(SearchCriteria cri);
	
	//판매자용리스트 갯수 세기(등록예정)
	public int selectAllSelCountb(ProductCriteria cri);
	
	//판매자용리스트 갯수 세기(등록완료)
	public int selectAllSelCount(ProductCriteria cri);
	
	//등록 예정 리스트 조회
	public List<ProductDTO> waitList(SearchCriteria cri) throws Exception;
	
	//판매자용 등록 예정 리스트 조회
	public List<ProductDTO> waitSelList(ProductCriteria cri) throws Exception;
	
	//등록 완료 목록 조회
	public List<ProductDTO> list(SearchCriteria cri) throws Exception;
	
	//판매자용 등록 완료 목록 조회
	public List<ProductDTO> sellist(ProductCriteria cri) throws Exception;
	
	//예정 상품 삭제
	public int delete(int prd_id) throws Exception;
	
	//등록 완료 상품 삭제
	public int deletelist(int prd_id) throws Exception;
	
	//등록 예정 상품을 등록 완료 리스트로 넘김
	public int addList(int prd_id) throws Exception;
	
	//상품 조회
	public ProductVO read(int prd_id) throws Exception;
	
	//카테고리명 조회
	public String readCategory(int prd_id) throws Exception;
	
	//카테고리명 조회1
	public  List<Map<Integer,String>> readCategories1() throws Exception;
	
	//카테고리명 조회2
	public  List<Map<Integer,String>> readCategories2() throws Exception;
		
	//상품 수정
	public int update(ProductVO vo) throws Exception;

	
	//front와 통신

	//카테고리 목록 보내기
	public List<CategoryDTO> category() throws Exception;
	
	//카테고리 선택하여 보내기
	public List<CategoryDTO> cateselect(int category_id) throws Exception;
	
	//등록 완료 목록 조회
	public List<ProductListDTO> mainlist(int category_p_id) throws Exception;
	
	//카테고리별 상품 조회
	public List<ProductListDTO> catelist(int category_id) throws Exception;
	
	//상품 검색
	public List<ProductListDTO> prosearch(String keyword) throws Exception;
	
	//베스트 목록
	public List<ProductListDTO> bestlist() throws Exception;
	
	//신상품 순서대로 나열된 목록
	public List<ProductListDTO> newlist() throws Exception;
	
	//알뜰상품 목록
	public List<ProductListDTO> salelist() throws Exception;
}

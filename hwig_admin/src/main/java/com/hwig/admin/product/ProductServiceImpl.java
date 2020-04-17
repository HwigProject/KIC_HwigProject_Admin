package com.hwig.admin.product;

import java.util.List;
import java.util.Map;

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
	
	//승인 예정 상품 삭제
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

	//상품 조회
	@Override
	public ProductVO read(int prd_id) throws Exception {
		return dao.read(prd_id);
	}
	
	//카테고리명 조회
	@Override
	public String readCategory(int prd_id) throws Exception {
		return dao.readCategory(prd_id);
	}
	
	//카테고리명 조회1
	@Override
	public  List<Map<Integer,String>> readCategories1() throws Exception {
		System.out.println("카테고리" + dao.readCategories1());
		return dao.readCategories1();
	}
	
	//카테고리명 조회2
	@Override
	public  List<Map<Integer,String>> readCategories2() throws Exception {
		System.out.println("카테고리" + dao.readCategories2());
		return dao.readCategories2();
	}
		
	//상품 수정
	@Override
	public int update(ProductVO vo) throws Exception {
		return dao.update(vo);
	}


	//front와 통신
	
	
	//메인 목록 조회
	@Override
	public List<ProductListDTO> mainlist(int category_p_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.mainlist(category_p_id);
	}

	//카테고리별 상품 조회
	@Override
	public List<ProductVO> catelist(int category_id) throws Exception {
		return dao.catelist(category_id);
	}
	
}

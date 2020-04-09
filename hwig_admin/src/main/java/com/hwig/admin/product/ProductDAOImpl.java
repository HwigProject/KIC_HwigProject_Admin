package com.hwig.admin.product;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hwig.admin.common.SearchCriteria;

@Repository
public class ProductDAOImpl implements ProductDAO{

	//mybatis
	@Inject
	private SqlSession sql;
	
	//mapper
	@Inject
	private static String namespace = "com.hwig.admin.mappers.productMapper";
	
	//상품 등록
	@Override
	public int add(ProductVO vo) throws Exception {
		return sql.insert(namespace + ".add", vo);
	}
	
	//리스트 갯수 세기
	@Override
	public int selectAllCount(SearchCriteria cri) {
		return sql.selectOne(namespace + ".allCount", cri);
	}
	
	//상품 승인 예정 목록 조회
	@Override
	public List<ProductVO> waitList(SearchCriteria cri) throws Exception {
		return sql.selectList(namespace + ".waitList", cri);
	}
	
	//등록 완료 목록 조회
	@Override
	public List<ProductVO> list(SearchCriteria cri) throws Exception {
		return sql.selectList(namespace + ".list", cri);
	}

	@Override
	public int delete(int prd_id) throws Exception {
		return sql.delete(namespace + ".delete", prd_id);
	}

	@Override
	public int addList(int prd_id) throws Exception {
		return sql.insert(namespace + ".addList", prd_id);
	}

	//등록 완료 상품 삭제
	@Override
	public int deletelist(int prd_id) throws Exception {
		return sql.delete(namespace + ".deletelist", prd_id);
	}
	
}

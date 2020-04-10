package com.hwig.admin.order;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAOImpl implements OrderDAO {

	private static final String namespace = "com.hwig.admin.mappers.orderMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<OrderVO> selectAllBySeller(OrderCriteria cri) {
		return sqlSession.selectList(namespace + ".orderAllSelectSeller", cri);
	}

	@Override
	public int selectAllCountBySeller(OrderCriteria cri) {
		return sqlSession.selectOne(namespace + ".orderAllCountSeller", cri);
	}

	@Override
	public List<OrderVO> selectAllByAdmin(OrderCriteria cri) {
		return sqlSession.selectList(namespace + ".orderAllSelectAdmin", cri);
	}

	@Override
	public int selectAllCountByAdmin(OrderCriteria cri) {
		return sqlSession.selectOne(namespace + ".orderAllCountAdmin", cri);
	}

}

package com.hwig.admin.cart;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.hwig.admin.member.MemberDeleteVO;

@Repository
public class CartServiceImpl implements CartService{

	@Inject
	private CartDAO dao;
	
	//장바구니 목록 가져오기
	@Override
	public List<CartlistDTO> cartList(String mem_id) throws Exception {
		return dao.cartList(mem_id);
	}
	
	//장바구니 등록
	@Override
	public int cartInsert(CartVO vo) throws Exception {
		return dao.cartInsert(vo);
	}
	
	//장바구니 삭제
	@Override
	public void cartDelete(List<CartdeleteDTO> listdto) throws Exception {
		dao.cartDelete(listdto);
	}

	@Override
	public int cartPrdRemove(String order_id) {
		return dao.cartPrdDelete(order_id);
	}

}

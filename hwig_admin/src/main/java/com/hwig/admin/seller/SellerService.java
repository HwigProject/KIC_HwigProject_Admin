package com.hwig.admin.seller;

import java.util.List;

import com.hwig.admin.common.SearchCriteria;

public interface SellerService {

	public int register(SellerVO sellerVo);
	
	public SellerVO listOne(String sel_id);
	
	public SellerVO login(String sel_id, String sel_pw);
	
	public int modify(SellerVO sellerVo);
	
	public List<SellerVO> listAll(SearchCriteria cri);
	
	public int listAllCount(SearchCriteria cri);
	
}

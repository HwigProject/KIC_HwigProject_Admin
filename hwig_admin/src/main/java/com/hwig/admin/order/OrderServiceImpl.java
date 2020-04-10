package com.hwig.admin.order;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwig.admin.seller.SellerVO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDao;
	
	@Autowired
	private HttpSession session;

	@Override
	public List<OrderVO> listAll(OrderCriteria cri) {
		String user_type = (String) session.getAttribute("user_type");
		String user_id = null;
		if (user_type.equals("seller")) {
			user_id = ((SellerVO) session.getAttribute("user")).getSel_id();
			cri.setSel_id(user_id);
			return orderDao.selectAllBySeller(cri);
		} else {
			return orderDao.selectAllByAdmin(cri);
		}
	}

	@Override
	public int listAllCount(OrderCriteria cri) {
		return orderDao.selectAllCountBySeller(cri);
	}

}

package com.hwig.admin.order;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		String user_type = (String) session.getAttribute("user_type");
		String user_id = null;
		if (user_type.equals("seller")) {
			user_id = ((SellerVO) session.getAttribute("user")).getSel_id();
			cri.setSel_id(user_id);
			return orderDao.selectAllCountBySeller(cri);
		} else {
			return orderDao.selectAllCountByAdmin(cri);
		}
		
	}

	@Override
	public OrderDetailDTO findOneById(String order_id) {
		OrderDetailDTO orderDto = new OrderDetailDTO();
		orderDto.setOrder_id(order_id);
		orderDto = orderDao.selectDetail(orderDto);
		
		String user_type = (String) session.getAttribute("user_type");
		if (user_type.equals("admin")) {
			orderDto.setSel_id(null);
		} else {
			orderDto.setSel_id(((SellerVO) session.getAttribute("user")).getSel_id());
		}
		
		orderDto.setOrder_prds(orderDao.selectDetailPrd(orderDto));
		return orderDto;
	}

	@Transactional
	@Override
	public int register(OrderRegisterDTO orderRegisterDto) {
		OrderVO orderVo = new OrderVO();
		orderVo.setMem_id(orderRegisterDto.getMem_id());
		orderVo.setOrder_reverse(orderRegisterDto.getOrder_reverse());
		orderVo.setOrder_paymoney(orderRegisterDto.getOrder_paymoney());
		orderVo.setOrder_request(orderRegisterDto.getRequest());
		orderVo.setOrder_count(orderRegisterDto.getOrder_count());
		orderDao.orderVoInsert(orderVo);
		
		String order_id = orderVo.getOrder_id();
		OrderBVO orderBVo = new OrderBVO();
		orderBVo.setOrder_id(order_id);
		for(int i = 0; i < orderRegisterDto.getPri_ids().size(); i++) {
			orderBVo.setPrd_id(orderRegisterDto.getPri_ids().get(i));
			orderDao.orderBVoInsert(orderBVo);
		}
		
		OrderAddrVO orderAddrVo = new OrderAddrVO();
		orderAddrVo.setOrder_id(order_id);
		orderAddrVo.setPost(orderRegisterDto.getPost());
		orderAddrVo.setGet(orderRegisterDto.getGet());
		orderAddrVo.setGet_tel(orderRegisterDto.getGet_tel());
		orderAddrVo.setGet_zipcode(orderRegisterDto.getGet_zipcode());
		orderAddrVo.setGet_addr(orderRegisterDto.getGet_addr());
		orderDao.orderAddrVoInsert(orderAddrVo);
		
		return 1;
	}

	@Override
	public int statusModify(OrderVO orderVo) {
		return orderDao.orderStatusUpdate(orderVo);
	}

}

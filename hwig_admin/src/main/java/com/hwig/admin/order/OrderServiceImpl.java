package com.hwig.admin.order;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hwig.admin.member.MemberService;
import com.hwig.admin.member.MemberVO;
import com.hwig.admin.seller.SellerVO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDao;

	@Autowired
	private MemberService memberService;

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
		orderVo.setOrder_request(orderRegisterDto.getOrder_request());
		orderVo.setOrder_count(orderRegisterDto.getOrder_count());
		orderDao.orderVoInsert(orderVo);

		String order_id = orderVo.getOrder_id();
		OrderBVO orderBVo = new OrderBVO();
		orderBVo.setOrder_id(order_id);
		for (int i = 0; i < orderRegisterDto.getOrder_prd_ids().size(); i++) {
			orderBVo.setPrd_id(orderRegisterDto.getOrder_prd_ids().get(i));
			orderDao.orderBVoInsert(orderBVo);
		}

		OrderAddrVO orderAddrVo = new OrderAddrVO();
		orderAddrVo.setOrder_id(order_id);
		orderAddrVo.setOrder_sender(orderRegisterDto.getOrder_sender());
		orderAddrVo.setOrder_receiver(orderRegisterDto.getOrder_receiver());
		orderAddrVo.setOrder_receiver_tel(orderRegisterDto.getOrder_receiver_tel());

		if (orderRegisterDto.isNewAddr()) {
			orderAddrVo.setOrder_receiver_addr(orderRegisterDto.getOrder_receiver_addr());
		} else {
			MemberVO memberVo = new MemberVO();
			memberVo.setMem_id(orderRegisterDto.getMem_id());
			memberVo = memberService.findOne(memberVo.getMem_id());
			orderRegisterDto.setOrder_receiver_addr(memberVo.getMem_addr());

			orderAddrVo.setOrder_receiver_addr(orderRegisterDto.getOrder_receiver_addr());
		}

		return orderDao.orderAddrVoInsert(orderAddrVo);
	}

	@Override
	public int statusModify(OrderVO orderVo) {
		return orderDao.orderStatusUpdate(orderVo);
	}

}

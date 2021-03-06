package com.hwig.admin.order;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hwig.admin.member.MemberDAO;
import com.hwig.admin.member.MemberService;
import com.hwig.admin.member.MemberVO;
import com.hwig.admin.seller.SellerVO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDao;

	@Autowired
	private MemberDAO memberDao;

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
	public String register(OrderRegisterDTO orderRegisterDto) {
		OrderVO orderVo = new OrderVO();
		orderVo.setMem_id(orderRegisterDto.getMem_id());
		orderVo.setOrder_reverse(orderRegisterDto.getOrder_reverse());
		orderVo.setOrder_used_reverse(orderRegisterDto.getOrder_used_reverse());
		orderVo.setOrder_paymoney(orderRegisterDto.getOrder_paymoney());
		orderVo.setOrder_payway(orderRegisterDto.getOrder_payway());
		orderVo.setOrder_request(orderRegisterDto.getOrder_request());
		orderDao.orderVoInsert(orderVo);

		String order_id = orderVo.getOrder_id();
		OrderBVO orderBVo = new OrderBVO();
		orderBVo.setOrder_id(order_id);
		for (int i = 0; i < orderRegisterDto.getOrder_prd_ids().size(); i++) {
			orderBVo.setPrd_id(orderRegisterDto.getOrder_prd_ids().get(i));
			orderBVo.setOrder_count(orderRegisterDto.getOrder_counts().get(i));
			orderDao.orderBVoInsert(orderBVo);
		}

		OrderAddrVO orderAddrVo = new OrderAddrVO();
		orderAddrVo.setOrder_id(order_id);
		orderAddrVo.setOrder_sender(orderRegisterDto.getOrder_sender());
		orderAddrVo.setOrder_receiver(orderRegisterDto.getOrder_receiver());
		orderAddrVo.setOrder_receiver_tel(orderRegisterDto.getOrder_receiver_tel());

		MemberVO memberVo = new MemberVO();
		if (orderRegisterDto.isNewAddr()) {
			orderAddrVo.setOrder_receiver_addr(orderRegisterDto.getOrder_receiver_addr());
		} else {
			memberVo.setMem_id(orderRegisterDto.getMem_id());
			memberVo = memberService.findOne(memberVo.getMem_id());
			orderRegisterDto.setOrder_receiver_addr(memberVo.getMem_addr());
			orderAddrVo.setOrder_receiver_addr(orderRegisterDto.getOrder_receiver_addr());
		}
		orderDao.orderAddrVoInsert(orderAddrVo);

		memberVo.setMem_id(orderRegisterDto.getMem_id());
		memberVo = memberService.findOne(memberVo.getMem_id());
		int totalReverse = memberVo.getMem_reverse() + orderRegisterDto.getOrder_reverse();
		memberVo.setMem_reverse(totalReverse);
		memberDao.changeReverse(memberVo);

		int totalPrice = memberVo.getMem_price() + orderRegisterDto.getOrder_paymoney();
		memberVo.setMem_price(totalPrice);
		memberDao.changePrice(memberVo);

		if (!memberVo.getMem_grade().equals("bronze")) {
			if (memberVo.getMem_price() > 5000000) {
				memberVo.setMem_grade("diamond");
				memberDao.changeGrade(memberVo);
			} else if (memberVo.getMem_price() > 3000000) {
				memberVo.setMem_grade("platinum");
				memberDao.changeGrade(memberVo);
			} else if (memberVo.getMem_price() > 1000000) {
				memberVo.setMem_grade("gold");
				memberDao.changeGrade(memberVo);
			} else if (memberVo.getMem_price() > 300000) {
				memberVo.setMem_grade("silver");
				memberDao.changeGrade(memberVo);
			}
		}

		return order_id;
	}

	@Override
	public int statusModify(OrderVO orderVo) {
		return orderDao.orderStatusUpdate(orderVo);
	}

	@Override
	public ApiOrderCompletionDTO orderCompletion(String order_id) {
		return orderDao.orderCompletion(order_id);
	}

}

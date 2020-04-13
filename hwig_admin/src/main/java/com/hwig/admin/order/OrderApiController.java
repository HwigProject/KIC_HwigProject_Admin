package com.hwig.admin.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hwig.admin.common.CommonResponse;
import com.hwig.admin.member.MemberApiController;

@RestController
@RequestMapping("/api/order/*")
public class OrderApiController {

	private static final Logger logger = LoggerFactory.getLogger(MemberApiController.class);

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public CommonResponse register(@RequestBody OrderRegisterDTO orderRegisterDto) {
		logger.info(orderRegisterDto.toString());

		CommonResponse response = new CommonResponse();

		int result = orderService.register(orderRegisterDto);

		if (result < 1) {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMsg("fail");
		} else {
			response.setCode(HttpStatus.CREATED.value());
			response.setMsg("success");
		}

		return response;
	}

	@RequestMapping(value = "/{order_id}", method = RequestMethod.PUT)
	public CommonResponse statusModify(@PathVariable("order_id") String order_id, @RequestBody OrderVO orderVo) {
		logger.info(orderVo.toString());

		CommonResponse response = new CommonResponse();

//		if(orderVo.getOrder_status().equals("배송 중")) {
//			
//		}
		orderVo.setOrder_status("배송 중");
		orderVo.setOrder_id(order_id);
		int result = orderService.statusModify(orderVo);

		if (result < 1) {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMsg("fail");
		} else {
			response.setCode(HttpStatus.OK.value());
			response.setMsg("success");
		}

		return response;
	}

}

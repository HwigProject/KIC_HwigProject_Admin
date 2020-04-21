package com.hwig.admin.order;

public class OrderBVO {

	private String order_id;
	private int prd_id;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public int getPrd_id() {
		return prd_id;
	}

	public void setPrd_id(int prd_id) {
		this.prd_id = prd_id;
	}

	@Override
	public String toString() {
		return "OrderBVO [order_id=" + order_id + ", prd_id=" + prd_id + "]";
	}

}

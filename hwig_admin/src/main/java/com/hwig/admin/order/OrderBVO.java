package com.hwig.admin.order;

public class OrderBVO {

	private String order_id;
	private int prd_id;
	private int order_count;

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

	public int getOrder_count() {
		return order_count;
	}

	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}

	@Override
	public String toString() {
		return "OrderBVO [order_id=" + order_id + ", prd_id=" + prd_id + ", order_count=" + order_count + "]";
	}

}
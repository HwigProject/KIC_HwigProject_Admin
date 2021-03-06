package com.hwig.admin.cart;

public class CartlistDTO {
	
	private String prd_name;
	private int prd_price;
	private int order_count;
	private String prd_thumb;
	
	public String getPrd_name() {
		return prd_name;
	}
	public void setPrd_name(String prd_name) {
		this.prd_name = prd_name;
	}
	public int getPrd_price() {
		return prd_price;
	}
	public void setPrd_price(int prd_price) {
		this.prd_price = prd_price;
	}
	public int getOrder_count() {
		return order_count;
	}
	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}
	public String getPrd_thumb() {
		return prd_thumb;
	}
	public void setPrd_thumb(String prd_thumb) {
		this.prd_thumb = prd_thumb;
	}
	
	@Override
	public String toString() {
		return "CartlistDTO [prd_name=" + prd_name + ", prd_price=" + prd_price + ", order_count=" + order_count
				+ ", prd_thumb=" + prd_thumb + "]";
	}
	
}

package com.hwig.admin.member;

public class ApiOrderPrdDetailDTO {

	private String prd_name;
	private int prd_price;
	private int prd_count;
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

	public int getPrd_count() {
		return prd_count;
	}

	public void setPrd_count(int prd_count) {
		this.prd_count = prd_count;
	}

	public String getPrd_thumb() {
		return prd_thumb;
	}

	public void setPrd_thumb(String prd_thumb) {
		this.prd_thumb = prd_thumb;
	}

	@Override
	public String toString() {
		return "ApiOrderPrdDetailDTO [prd_name=" + prd_name + ", prd_price=" + prd_price + ", prd_count=" + prd_count
				+ ", prd_thumb=" + prd_thumb + "]";
	}

}

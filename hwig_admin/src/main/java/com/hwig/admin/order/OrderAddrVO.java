package com.hwig.admin.order;

public class OrderAddrVO {

	private String order_id;
	private String post;
	private String get;
	private String get_tel;
	private String get_zipcode;
	private String get_addr;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getGet() {
		return get;
	}

	public void setGet(String get) {
		this.get = get;
	}

	public String getGet_tel() {
		return get_tel;
	}

	public void setGet_tel(String get_tel) {
		this.get_tel = get_tel;
	}

	public String getGet_zipcode() {
		return get_zipcode;
	}

	public void setGet_zipcode(String get_zipcode) {
		this.get_zipcode = get_zipcode;
	}

	public String getGet_addr() {
		return get_addr;
	}

	public void setGet_addr(String get_addr) {
		this.get_addr = get_addr;
	}

	@Override
	public String toString() {
		return "OrderAddrVO [order_id=" + order_id + ", post=" + post + ", get=" + get + ", get_tel=" + get_tel
				+ ", get_zipcode=" + get_zipcode + ", get_addr=" + get_addr + "]";
	}

}

package com.hwig.admin.order;

import java.util.List;

public class OrderRegisterDTO {

	private String mem_id;
	private int order_reverse;
	private int order_paymoney;
	private String request;

	private List<Integer> pri_ids;
	private int order_count;

	private String post;
	private String get;
	private String get_tel;
	private String get_zipcode;
	private String get_addr;

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getOrder_reverse() {
		return order_reverse;
	}

	public void setOrder_reverse(int order_reverse) {
		this.order_reverse = order_reverse;
	}

	public int getOrder_paymoney() {
		return order_paymoney;
	}

	public void setOrder_paymoney(int order_paymoney) {
		this.order_paymoney = order_paymoney;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public List<Integer> getPri_ids() {
		return pri_ids;
	}

	public void setPri_ids(List<Integer> pri_ids) {
		this.pri_ids = pri_ids;
	}

	public int getOrder_count() {
		return order_count;
	}

	public void setOrder_count(int order_count) {
		this.order_count = order_count;
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
		return "OrderRegisterDTO [mem_id=" + mem_id + ", order_reverse=" + order_reverse + ", order_paymoney="
				+ order_paymoney + ", request=" + request + ", pri_ids=" + pri_ids + ", order_count=" + order_count
				+ ", post=" + post + ", get=" + get + ", get_tel=" + get_tel + ", get_zipcode=" + get_zipcode
				+ ", get_addr=" + get_addr + "]";
	}

}

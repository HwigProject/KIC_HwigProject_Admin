package com.hwig.admin.order;

import java.util.List;

public class OrderRegisterDTO {

	private String mem_id;
	private int order_reverse;
	private int order_used_reverse;
	private int order_paymoney;
	private String order_request;

	private List<Integer> order_prd_ids;
	private List<Integer> prd_count;

	private int order_count;
	private String order_sender;
	private String order_receiver;
	private String order_receiver_tel;
	private String order_receiver_addr;
	private boolean isNewAddr;

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

	public int getOrder_used_reverse() {
		return order_used_reverse;
	}

	public void setOrder_used_reverse(int order_used_reverse) {
		this.order_used_reverse = order_used_reverse;
	}

	public int getOrder_paymoney() {
		return order_paymoney;
	}

	public void setOrder_paymoney(int order_paymoney) {
		this.order_paymoney = order_paymoney;
	}

	public String getOrder_request() {
		return order_request;
	}

	public void setOrder_request(String order_request) {
		this.order_request = order_request;
	}

	public List<Integer> getOrder_prd_ids() {
		return order_prd_ids;
	}

	public void setOrder_prd_ids(List<Integer> order_prd_ids) {
		this.order_prd_ids = order_prd_ids;
	}

	public List<Integer> getPrd_count() {
		return prd_count;
	}

	public void setPrd_count(List<Integer> prd_count) {
		this.prd_count = prd_count;
	}

	public void setNewAddr(boolean isNewAddr) {
		this.isNewAddr = isNewAddr;
	}

	public int getOrder_count() {
		return order_count;
	}

	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}

	public String getOrder_sender() {
		return order_sender;
	}

	public void setOrder_sender(String order_sender) {
		this.order_sender = order_sender;
	}

	public String getOrder_receiver() {
		return order_receiver;
	}

	public void setOrder_receiver(String order_receiver) {
		this.order_receiver = order_receiver;
	}

	public String getOrder_receiver_tel() {
		return order_receiver_tel;
	}

	public void setOrder_receiver_tel(String order_receiver_tel) {
		this.order_receiver_tel = order_receiver_tel;
	}

	public String getOrder_receiver_addr() {
		return order_receiver_addr;
	}

	public void setOrder_receiver_addr(String order_receiver_addr) {
		this.order_receiver_addr = order_receiver_addr;
	}

	public boolean isNewAddr() {
		return isNewAddr;
	}

	public void setIsNewAddr(boolean isNewAddr) {
		this.isNewAddr = isNewAddr;
	}

	@Override
	public String toString() {
		return "OrderRegisterDTO [mem_id=" + mem_id + ", order_reverse=" + order_reverse + ", order_used_reverse="
				+ order_used_reverse + ", order_paymoney=" + order_paymoney + ", order_request=" + order_request
				+ ", order_prd_ids=" + order_prd_ids + ", prd_count=" + prd_count + ", order_count=" + order_count
				+ ", order_sender=" + order_sender + ", order_receiver=" + order_receiver + ", order_receiver_tel="
				+ order_receiver_tel + ", order_receiver_addr=" + order_receiver_addr + ", isNewAddr=" + isNewAddr
				+ "]";
	}

}

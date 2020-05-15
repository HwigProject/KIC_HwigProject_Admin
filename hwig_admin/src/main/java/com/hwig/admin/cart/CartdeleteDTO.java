package com.hwig.admin.cart;

import java.util.List;

public class CartdeleteDTO {
	
	private List<Integer> prd_id;
	private String mem_id;
	
	public List<Integer> getPrd_id() {
		return prd_id;
	}
	public void setPrd_id(List<Integer> prd_id) {
		this.prd_id = prd_id;
	}
	public int getPrd_ids(int i) {
		return prd_id.get(i);
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	@Override
	public String toString() {
		return "CartdeleteDTO [prd_id=" + prd_id + ", mem_id=" + mem_id + "]";
	}
}

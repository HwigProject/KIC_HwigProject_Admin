package com.hwig.admin.member;

public class MemberVO {

	private int rownum;
	private String mem_id;
	private String mem_pw;
	private String mem_tel;
	private String mem_name;
	private String mem_zipcode;
	private String mem_addr;
	private String mem_email;
	private String mem_regdate;
	private String mem_grade;
	private int mem_reverse;

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}

	public String getMem_tel() {
		return mem_tel;
	}

	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_zipcode() {
		return mem_zipcode;
	}

	public void setMem_zipcode(String mem_zipcode) {
		this.mem_zipcode = mem_zipcode;
	}

	public String getMem_addr() {
		return mem_addr;
	}

	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_regdate() {
		return mem_regdate;
	}

	public void setMem_regdate(String mem_regdate) {
		this.mem_regdate = mem_regdate;
	}

	public String getMem_grade() {
		return mem_grade;
	}

	public void setMem_grade(String mem_grade) {
		this.mem_grade = mem_grade;
	}

	public int getMem_reverse() {
		return mem_reverse;
	}

	public void setMem_reverse(int mem_reverse) {
		this.mem_reverse = mem_reverse;
	}

	@Override
	public String toString() {
		return "MemberVO [rownum=" + rownum + ", mem_id=" + mem_id + ", mem_pw=" + mem_pw + ", mem_tel=" + mem_tel
				+ ", mem_name=" + mem_name + ", mem_zipcode=" + mem_zipcode + ", mem_addr=" + mem_addr + ", mem_email="
				+ mem_email + ", mem_regdate=" + mem_regdate + ", mem_grade=" + mem_grade + ", mem_reverse="
				+ mem_reverse + "]";
	}

	public void empty() {
		rownum = 0;
		mem_id = "";
		mem_pw = "";
		mem_tel = "";
		mem_name = "";
		mem_zipcode = "";
		mem_addr = "";
		mem_email = "";
		mem_regdate = "";
		mem_grade = "";
		mem_reverse = 0;
	}

}

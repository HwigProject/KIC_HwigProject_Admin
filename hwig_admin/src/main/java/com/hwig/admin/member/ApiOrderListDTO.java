package com.hwig.admin.member;

import java.util.List;

public class ApiOrderListDTO {

	private ApiPageMaker pageMaker;

	private List<ApiOrderDTO> data;

	public ApiPageMaker getPageMaker() {
		return pageMaker;
	}

	public void setPageMaker(ApiPageMaker pageMaker) {
		this.pageMaker = pageMaker;
	}

	public List<ApiOrderDTO> getData() {
		return data;
	}

	public void setData(List<ApiOrderDTO> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ApiMemberOrderListDTO [pageMaker=" + pageMaker + ", data=" + data + "]";
	}

}

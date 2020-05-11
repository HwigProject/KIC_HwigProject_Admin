<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headnav.jsp" %>

        <!--main content start-->
        <section class="main-content-wrapper">
            <div class="pageheader">
                <h1>관리자 페이지</h1>
                <p class="description">휙 관리자 페이지 입니다.</p>
            </div>
            <section id="main-content" class="animated fadeInUp">
                <div class="row">
                    <div class="col-md-12 col-lg-12">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="panel panel-solid-success widget-mini">
                                    <div class="panel-body">
                                        <i class="icon-bar-chart"></i>
                                        <span class="total text-center" id="order_paymoney">${order_paymoney.order_paymoney}</span>
                                        <span class="title text-center">총 매출</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="panel widget-mini">
                                    <div class="panel-body">
                                        <i class="icon-support"></i>
                                        <span class="total text-center">${reply_count.reply_id}</span>
                                        <span class="title text-center">문의답변</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="panel widget-mini">
                                    <div class="panel-body">
                                        <i class="icon-envelope-open"></i>
                                        <span class="total text-center">${qna_count.qna_id}</span>
                                        <span class="title text-center">고객문의</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="panel panel-solid-info widget-mini">
                                    <div class="panel-body">
                                        <i class="icon-user"></i>
                                        <span class="total text-center">${member_count.mem_id}</span>
                                        <span class="title text-center">회원 수</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-4">
                        <div class="panel">
                            <div class="panel-body">
                                <div class="calendar-block ">
                                    <div class="cal1">

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><a href="/qna/qlist">문의 목록</a></h3>
                                <div class="actions pull-right">
                                    <i class="fa fa-expand"></i>
                                    <i class="fa fa-chevron-down"></i>
                                    <i class="fa fa-times"></i>
                                </div>
                            </div>
                            <div class="panel-body">

                                <div class="table-responsive">
                                    <table class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>글 번호</th>
                                                <th>카테고리</th>
                                                <th>제목</th>
                                                <th>작성일</th>
                                                <th>작성자</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                           <c:forEach var="qList_index" varStatus="status" items="${qList_index}">
												<tr>
													<td>${qList_index.qna_id}</td>
													<td>${qList_index.qna_category}</td>
													<td>${qList_index.qna_subject}</td>
													<td>${qList_index.qna_regdate}</td>
													<td>${qList_index.mem_id}</td>											
												</tr>
											</c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                     <div class="col-xs-12 col-sm-12 col-md-12 col-lg-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">주문 목록</h3>
                                <div class="actions pull-right">
                                    <i class="fa fa-expand"></i>
                                    <i class="fa fa-chevron-down"></i>
                                    <i class="fa fa-times"></i>
                                </div>
                            </div>
                            <div class="panel-body">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>주문번호</th>
                                            <th>회원아이디</th>
                                            <th>결제금액</th>
                                            <th>주문날짜</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach var="order_list" items="${order_list}">
                                    		<tr class="success">
	                                            <td>${order_list.order_id}</td>
	                                            <td>${order_list.mem_id}</td>
	                                            <td>${order_list.order_paymoney}</td>
	                                            <td>${order_list.order_paydate}</td>
                                        	</tr>
                                    	</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">승인 요청 상품 목록</h3>
                                <div class="actions pull-right">
                                    <i class="fa fa-expand"></i>
                                    <i class="fa fa-chevron-down"></i>
                                    <i class="fa fa-times"></i>
                                </div>
                            </div>
                            <div class="panel-body">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>상품번호</th>
                                            <th>카테고리</th>
                                            <th>판매자</th>
                                            <th>상품명</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="prd_list" items="${prd_list}">
                                    		<tr class="success">
	                                            <td>${prd_list.prd_id}</td>
	                                            <td>${prd_list.category_id}</td>
	                                            <td>${prd_list.sel_id}</td>
	                                            <td>${prd_list.prd_name}</td>
                                        	</tr>
                                    	</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </section>
        <!--main content end-->
    
<%@ include file="/WEB-INF/views/include/footnav.jsp" %>
<script>
$(function(){
	
	  if($('#order_paymoney').val()=='')
	 {
		 $('#order_paymoney').text('￦ 0');
	 }	  
})
</script>
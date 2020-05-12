<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headnav.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <!--main content start-->
        <section class="main-content-wrapper">
            <div class="pageheader">
                <h1>관리자 페이지</h1>
                <p class="description">휙 관리자 페이지 입니다.</p>
            </div>
            
            <section id="main-content" class="animated fadeInUp">
                <div class="row">
                    <div class="col-md-12 col-lg-6">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="panel panel-solid-success widget-mini">
                                    <div class="panel-body">
                                        <i class="icon-bar-chart"></i>
                                        <span class="total text-center" id="order_paymoney">${order_paymoney}</span>
                                        <span class="title text-center">총 매출</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="panel widget-mini">
                                    <div class="panel-body">
                                        <i class="icon-support"></i>
                                        <span class="total text-center">${reply_count}</span>
                                        <span class="title text-center">문의답변</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="panel widget-mini">
                                    <div class="panel-body">
                                        <i class="icon-envelope-open"></i>
                                        <span class="total text-center">${qna_count}</span>
                                        <span class="title text-center">고객문의</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="panel panel-solid-info widget-mini">
                                    <div class="panel-body">
                                        <i class="icon-user"></i>
                                        <span class="total text-center">${member_count}</span>
                                        <span class="title text-center">회원 수</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                        <div class="panel panel-default browser-chart">
                            <div class="panel-heading">
                                <h3 class="panel-title">BROWSER STATS</h3>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                        <ul>
                                            <li><i class="fa fa-circle success-color"></i> 소·돼지</li>
                                            <li><i class="fa fa-circle primary-color"></i> 닭·오리</li>
                                            <li><i class="fa fa-circle warning-color"></i> 간편조리·양념육</li>
                                            <li><i class="fa fa-circle info-color"></i> 기본채소</li>
                                            <li><i class="fa fa-circle default-color"></i> 국산과일</li>
                                            <li><i class="fa fa-circle default-color" style="color:red"></i> 수입과일</li>
                                        </ul>
                                    </div>
                                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                                        <div id="doughnut-canvas-holder">
                                            <canvas id="doughnut-chart-area" width="137" height="137"></canvas>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Monthly Goal</h3>
                                <div class="actions pull-right">
                                    <i class="fa fa-expand"></i>
                                </div>
                            </div>
                            <div class="panel-body widget-gauge">
                                <canvas width="160" height="100" id="gauge" class=""></canvas>
                                <div class="goal-wrapper">
                                    <span class="gauge-value pull-left">$</span>
                                    <span id="gauge-text" class="gauge-value pull-left">3,200</span>
                                    <span id="goal-text" class="goal-value pull-right">$5,000</span>
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
	  
	  var value = new Array();
	  var i=0;
	  <c:forEach var="chart_circle" items="${chart_circle}">
	  	 value[i] = <c:out value='${chart_circle.prd_price}'/>
	  	 i++;
	  </c:forEach>
	  
	  var data1,data2,data3,data4,data5,data6;
      var doughnutData = [
    	  data1 = {
          value: 0,
          color: "#1ABC9C",
          highlight: "#1ABC9C",
          label: "소·돼지"
      }, data2 = {
          value: 0,
          color: "#556B8D",
          highlight: "#556B8D",
          label: "닭·오리"
      }, data3 = {
          value: 0,
          color: "#EDCE8C",
          highlight: "#EDCE8C",
          label: "간편조리·양념육"
      }, data4 = {
          value: 40,
          color: "#CED1D3",
          highlight: "#CED1D3",
          label: "기본채소"
      }, data5 = {
          value: 0,
          color: "#1F7BB6",
          highlight: "#1F7BB6",
          label: "국산과일"
      }, data6 = {
    	  value: 0,
    	  color: "red",
    	  highlight: "red",
    	  label: "수입과일"
      }
  ];
   		data1["value"] = value[0];
   		data2["value"] = value[1];
   		data3["value"] = value[2];
   		data4["value"] = value[3];
   		data5["value"] = value[4];
   		data6["value"] = value[5];

      window.onload = function() {
          var ctx3 = document.getElementById("doughnut-chart-area").getContext("2d");
          window.myDoughnut = new Chart(ctx3).Doughnut(doughnutData, {
              responsive: true
          });
      };
  });
</script>
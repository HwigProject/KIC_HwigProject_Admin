<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headnav.jsp" %>
<section class="main-content-wrapper">
        <div class="pageheader">
              <h1>승인 완료</h1>
              <p class="description">상품 목록 페이지 입니다.</p>
              <div class="breadcrumb-wrapper hidden-xs">
                  <span class="label">You are here:</span>
                  <ol class="breadcrumb">
                      <li class="active">Dashboard</li>
                  </ol>
              </div>
        </div>
	<section id="main-content" class="animated fadeInUp">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">상품 목록</h3>
						<div class="actions pull-right">
							<i class="fa fa-expand"></i>
							<i class="fa fa-chevron-down"></i>
							<i class="fa fa-times"></i>
	                    </div>
					</div>
					<div class="panel-body">
						<table id="productlist" class="table table-striped table-bordered" cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>상품번호</th>
									<th>카테고리</th>
									<th>판매자id</th>
									<th>상품명</th>
									<th>썸네일</th>
									<th>한줄설명</th>
									<th>원가</th>
									<th>수정삭제</th>
								</tr>
							</thead>
							
							<tbody>
							<!-- 목록 -->
								<c:forEach items="${list}" var="list">
									<tr>
										<td id="list_prd_id">${prd_id}</td>
										<td >${list.category_id}</td>
										<td>${list.sel_id}</td>
										<td>${list.prd_name}</td>
										<td>${list.prd_thumb}</td>
										<td>${list.prd_comment}</td>
										<td>${list.prd_price}</td>
										<td>
											<button type="button" class="btn btn-warning btn-sm">수정</button>
											<button type="button" class="btn btn-danger btn-sm btn_del">삭제</button>
										</td>
									</tr>
								</c:forEach>
							<!-- 목록 -->
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
</section>
<%@ include file="/WEB-INF/views/include/footnav.jsp" %>
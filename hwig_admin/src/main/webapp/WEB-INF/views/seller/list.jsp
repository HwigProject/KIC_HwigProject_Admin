<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headnav.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--main content start-->
        <section class="main-content-wrapper">
            <div class="pageheader">
                <h1>고객 관리</h1>
            </div>
            <section id="main-content" class="animated fadeInUp">
                <div class="row">
                    <div class="col-md-12">

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Responsive table</h3>
                                <div class="actions pull-right">
                                    <i class="fa fa-expand"></i>
                                    <i class="fa fa-chevron-down"></i>
                                    <i class="fa fa-times"></i>
                                </div>
                            </div>
                            <div class="panel-body">
								<div class="row">
		                            <div class="col-xs-6">
			                            <div class="dataTables_length" id="example_length">
				                            <label>검색
				                            <select name="searchType" id="searchType">
												<option value=""
													<c:out value="${cri.searchType == null ? 'selected' : ' '}" />>
													----</option>
												<option value="id"
													<c:out value="${cri.searchType eq 'id' ? 'selected' : ' ' }" />>
													사업자등록번호</option>
												<option value="cname"
													<c:out value="${cri.searchType eq 'cname' ? 'selected' : ' ' }" />>
													상호명</option>
											</select>
				                            </label>
			                            </div>
			                        </div>
			                        <div class="col-xs-6">
				                        <div id="example_filter" class="dataTables_filter">
				                            <label>Search:<input type="search" class="form-control input-sm" aria-controls="example" id="keyword" value="${cri.keyword}"></label>
				                            <button type="button" class="btn btn-success" id="searchBtn">검색</button>
			                            </div>
	                            	</div>
                            	</div>
                                <div class="table-responsive">
                                    <table class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>사업자번호</th>
	                                            <th>비밀번호</th>
	                                            <th>상호명</th>
	                                            <th>대표자명</th>
	                                            <th>주소</th>
	                                            <th>전화번호</th>
	                                            <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${list}" var="sellerVo">
                                            <tr>
                                                <td>${sellerVo.sel_id}</td>
                                                <td>${sellerVo.sel_pw}</td>
                                                <td>${sellerVo.sel_cname}</td>
                                                <td>${sellerVo.sel_name}</td>
                                                <td>${sellerVo.sel_addr}</td>
                                                <td>${sellerVo.sel_tel}</td>
                                                
                                                <td><a href="/seller/modifyForm${pageMaker.makeSearch(pageMaker.cri.page)}&sel_id=${sellerVo.sel_id}" class="btn btn-warning">수정</a></td>
                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="text-center">
									<ul class="pagination">
										<c:if test="${pageMaker.prev}">
											<li><a href="list${pageMaker.makeSearch(pageMaker.startPage-1)}">&laquo;</a></li>
										</c:if>
										
										<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
											<li
												<c:out value="${pageMaker.cri.page == idx?'class=active':''}"/>>
												<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
											</li>
										</c:forEach>
										
										<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
											<li><a href="list${pageMaker.makeSearch(pageMaker.endPage+1)}">&raquo;</a></li>
										</c:if>
									</ul>
								</div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </section>
        <!--main content end-->

<%@ include file="/WEB-INF/views/include/footnav.jsp" %>
<script>
	$(document).ready(function() {
		function search(){
			self.location = "list"
				+ '${pageMaker.makeQuery(1)}'
				+ "&searchType="
				+ $("#searchType option:selected").val()
				+ "&keyword=" + encodeURIComponent($('#keyword').val());
		}
		
		$("#searchBtn").on("click", search);
	});
	
	var result = '${msg}';
	
	if(result == 'success') {
		alert("처리가 완료되었습니다.");
	} /* else {
		alert("처리가 실패되었습니다.");
	} */
	
	
</script>
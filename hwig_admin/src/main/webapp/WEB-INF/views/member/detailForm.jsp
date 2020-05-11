<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headnav.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!--main content start-->
<section class="main-content-wrapper">
    <div class="pageheader">
        <h1>회원 상세정보</h1>
    </div>
    <section id="main-content" class="animated fadeInUp">
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">${data.mem_id}</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" method="post" action="modify" enctype="multipart/form-data" id="modifyForm" class="form-horizontal form-border">
                        	<div class="form-group">
                                <label class="col-sm-3 control-label">아이디</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="mem_id" name="mem_id" readonly="readonly" value="${data.mem_id}" maxlength="20">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">이름</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="mem_name" name="mem_name" readonly="readonly" value="${data.mem_name}" maxlength="20">
                                </div>
                            </div>
                            
                                    <input type="hidden" class="form-control" id="mem_pw" name="mem_pw" value="${data.mem_pw}" maxlength="20">
                                    
                            <div class="form-group">
                                <label class="col-sm-3 control-label">이메일</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="mem_email" name="mem_email" value="${data.mem_email}" maxlength="200">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">전화번호</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="mem_tel" name="mem_tel" value="${data.mem_tel}" maxlength="20">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">주소</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" value="${data.mem_addr}" readonly="readonly">
	                                <input type="text" id="sample4_postcode" placeholder="우편번호" class="form-control">
									<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" class="btn btn-primary" ><br>
									<input type="text" id="sample4_roadAddress" placeholder="도로명주소" class="form-control">
									<input type="hidden" id="sample4_jibunAddress" placeholder="지번주소" class="form-control">
									<input type="text" id="sample4_detailAddress" placeholder="상세주소" class="form-control" maxlength="400">
									<input type="text" id="sample4_extraAddress" placeholder="참고항목" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">가입날짜</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control " id="mem_regdate" name="mem_regdate" value="${data.mem_regdate}" maxlength="20" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">등급</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control " id="mem_grade" name="mem_grade" value="${data.mem_grade}" maxlength="20" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">적립금</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control " id="mem_reverse" name="mem_reverse" value="${data.mem_reverse}" maxlength="20" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">총 주문금액</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control " id="mem_price" name="mem_price" value="${data.mem_price}" maxlength="20" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">주문리스트</label>
                                <div class="col-sm-6">
                                    <div class="table-responsive">
										<table class="table table-bordered table-striped text-center">
											<thead>
												<tr>
													<th class="text-center">주문번호</th>
													<th class="text-center">상품이름</th>
													<th class="text-center">상품가격</th>
													<th class="text-center">상품갯수</th>
												</tr>
											</thead>
											<tbody>
												<c:if test="${fn:length(prdData) > 0}">
												<c:forEach items="${prdData}" var="prdData">
													<tr>
														<td>${prdData.order_id}</td>
														<td>${prdData.prd_name}</td>
														<td>${prdData.prd_price}</td>
														<td>${prdData.order_count}</td>
													</tr>
												</c:forEach>
												</c:if>
												<c:if test="${fn:length(prdData) < 1}">
													<tr>
														<td colspan="3">주문한 상품이 없습니다</td>
													</tr>
												</c:if>
											</tbody>
										</table>
									</div>
                                </div>
							</div>
                            <div class="form-group">
                               <div class="col-sm-offset-3 col-sm-6" align="right">
		                      		<button type="button" class="btn btn-primary" id="modifyBtn">수정</button>
		                      		<button type="button" class="btn btn-danger" id="listBtn">목록</button>
	                      		</div>
                           </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
</section>
<!--main content end-->

<%@ include file="/WEB-INF/views/include/footnav.jsp" %>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }
            }
        }).open();
    }
    
	$(document).ready(function() {
		$("#modifyBtn").click(function(){
			var sel_addr = "(" + $("#sample4_postcode").val() + ") "
										+ $("#sample4_roadAddress").val() + ", "
										+ $("#sample4_detailAddress").val()
										+ $("#sample4_extraAddress").val();
			
			$("#sel_addr").val(sel_addr);
			console.log(sel_addr);
			
			if($.trim($("#sel_id").val()) == ""){
				alert("사업자번호를 입력해주세요");
				return false;
			}
			
			if($.trim($("#sel_cname").val()) == ""){
				alert("상호명를 입력해주세요");
				return false;
			}
			
			if($.trim($("#sel_name").val()) == ""){
				alert("대표자명를 입력해주세요");
				return false;
			}
			
			if($.trim($("#sel_addr").val()) == ""){
				alert("사업장 소재지를 입력해주세요");
				return false;
			}
			
			if($.trim($("#sel_tel").val()) == ""){
				alert("전화번호를 입력해주세요");
				return false;
			}
			
			if($.trim($("#sel_img").val()) == "" && $.trim($("#attach_img").attr("src")) == ""){
				alert("사업자등록증 사본을 업로드해주세요");
				return false;
			}
			
			$("#modifyForm").submit();
		});
		
		$("#listBtn").click(function(){
			self.location = "list?page=${page}&perPageNum=${perPageNum}&searchType=${searchType}&keyword=${keyword}";
		});
	});
</script>
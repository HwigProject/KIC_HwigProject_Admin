<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headnav.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--main content start-->
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

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
<section class="container animated fadeInUp">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div id="login-wrapper">
                    <header>
                        <div class="brand">
                            <a href="index.html" class="logo">
                                <i class="icon-layers"></i>
                                <span>판매자 등록</span></a>
                        </div>
                    </header>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                          <h3 class="panel-title">     
                           
                        </h3>  
                    </div>
                    <div class="panel-body">
                        <form role="form" method="post" action="register" enctype="multipart/form-data">
                            <div class="form-group">
                                <label for="exampleInputEmail1">사업자등록번호</label>
                                <input type="text" class="form-control" id="sel_id" name="sel_id">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">비밀번호</label>
                                <input type="password" class="form-control" id="sel_pw" name="sel_pw">
                            </div>
                             <div class="form-group">
                                <label for="exampleInputPassword1">상호명</label>
                                <input type="text" class="form-control" id="sel_cname" name="sel_cname">
                            </div>
                              <div class="form-group">
                                <label for="exampleInputPassword1">대표자명</label>
                                <input type="text" class="form-control" id="sel_name" name="sel_name">
                            </div>
                            
                            <div class="form-group">
                                <label for="exampleInputPassword1">주소</label><br>
                                <!-- <input type="text" class="form-control" id="sel_addr" name="sel_addr"> -->
                                <input type="text" id="sample4_postcode" placeholder="우편번호" class="form-control" name="selAddr">
								<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" class="btn btn-primary" ><br>
								<input type="text" id="sample4_roadAddress" placeholder="도로명주소" class="form-control" name="selAddr">
								<input type="text" id="sample4_jibunAddress" placeholder="지번주소" class="form-control">
								<span id="guide" style="color:#999;display:none"></span>
								<input type="text" id="sample4_detailAddress" placeholder="상세주소" class="form-control" name="selAddr">
								<input type="text" id="sample4_extraAddress" placeholder="참고항목" class="form-control" name="selAddr">
							</div>
							
                            <div class="form-group">
                                <label for="exampleInputPassword1">전화번호</label>
                                <input type="text" class="form-control" id="sel_tel" name="sel_tel">
                            </div>
                            <div class="form-group">
								<label for="exampleInputFile">파일</label>
								<img src="${data.sel_img}" id="attach_img">
								<input type="file" id="sel_img" name="attach_img">
 							</div>
                       
                       		<button type="submit" class="btn btn-primary btn-block">등록</button>
                       		<input type="hidden" name="origin_img" value="${data.sel_img}">
                       		<input type="text" name="sel_addr" value="" id="sel_addr">
                        </form>

                    </div>
                </div>
                </div>
            </div>
        </div>

    </section>
        <!--main content end-->

<%@ include file="/WEB-INF/views/include/footnav.jsp" %>
<script>
$("#sel_img").change(function(){
	   if(this.files && this.files[0]) {
	    var reader = new FileReader;
	    reader.onload = function(data) {
	     $("#attach_img").attr("src", data.target.result).width(500);        
	    }
	    reader.readAsDataURL(this.files[0]);
	   }
	  });

var sel_addr = "";
$("#sel_img").click(function(){
	$("input[name=selAddr]").map(function(){
		sel_addr += $(this).val();
	});
	$("#sel_addr").attr("value", sel_addr);
	console.log(sel_addr);
});


</script>
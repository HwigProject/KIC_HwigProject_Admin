<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>1대1 문의 등록</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
<script>
	function select_category(frm){
		
		var selec = frm.category.selectedIndex;
		
		switch(selec){
		case 0:
			frm.qna_category.value = '선택';
		break;
		case 1:
			frm.qna_category.value = '회원문의';
		break;
		case 2:
			frm.qna_category.value = '주문/결제';
		break;
		case 3:
			frm.qna_category.value = '취소/교환/반품';
		break;
		case 4:
			frm.qna_category.value = '배송문의';
		break;
		case 5:
			frm.qna_category.value = '쿠폰/적립금';
		break;
		case 6:
			frm.qna_category.value = '서비스 이용 및 기타';
		break;
		}
		return true;
	}
	
	function check_upload(){
		upForm = document.q_uploadForm;
		var selec = upForm.category.selectedIndex;
		
		if(upForm.qna_subject.value==""){
			alert("제목을 입력해주세요.");
			return upForm.qna_subject.focus();
		} 
		if(upForm.qna_content.value==""){
			alert("본문을 입력해주세요.");
			return upForm.qna_content.focus();
		}
		if(selec==0){
			alert("카테고리를 설정해주세요.")
			return upForm.qna_category.focus();
		}
		if(confirm("등록 하시겠습니까?")){
			upForm.submit();
		}else{
			return;
		}
	}
</script>


</head>
<body>
	<%@ include file="../include/headnav.jsp" %>
	<section class="main-content-wrapper">
			<section id="main-content" class="animated fadeInUp">
		           <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">1대1 문의 등록</h3>
                                <div class="actions pull-right">
                                    <i class="fa fa-expand"></i>
                                    <i class="fa fa-chevron-down"></i>
                                    <i class="fa fa-times"></i>
                                </div>
                            </div>

                            <div class="panel-body">
                                <form method="post" name="q_uploadForm" class="form-horizontal form-border">                                
               						<input type="hidden" name="qna_category">
               						<input type="hidden" name="mem_id" value="test2">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">제목</label>
                                        <div class="col-sm-6">
                                            <input type="text" name="qna_subject" class="form-control" placeholder="제목을 입력하세요. ">
                                        </div>
                                    </div>
                                    <div class="form-group">
	                                    <label class="col-sm-3 control-label">카테고리</label>
	                                    <div class="col-sm-6">
		                                    <select class="form-control" name="category" onchange="select_category(this.form)">
		                                        <option selected value=0>선택</option>
		                                        <option value=1>회원문의</option>
		                                        <option value=2>주문/결제</option>
		                                        <option value=3>취소/교환/반품</option>
		                                        <option value=4>배송문의</option>
		                                        <option value=5>쿠폰/적립금</option>
		                                        <option value=6>서비스 이용 및 기타</option>
		                                    </select>
	                                	</div>
       								</div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">본문</label>
                                        <div class="col-sm-6">
                                            <textarea style="resize:none; height:500px;" id="qna_content" name="qna_content" class="form-control"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-4 pull-right">
                                            <input type="button" value="등록" class="btn btn-info" onclick="check_upload()"/>
                   							<input type="reset" value="초기화" class="btn btn-success"/>
                    						<input type="button" value="목록 " class="btn btn-danger" onclick="javascript:location.href=document.referrer"/>
                                        </div>
                                    </div>                                        
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
          </section>
	<%@ include file="../include/footnav.jsp" %>
</body>
</html>
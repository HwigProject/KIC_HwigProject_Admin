<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>자주묻는질문 등록</title>

<script>
	function select_category(frm){
		
		var selec = frm.category.selectedIndex;
		
		switch(selec){
		case 0:
			frm.faq_category.value = '선택';
		break;
		case 1:
			frm.faq_category.value = '회원문의';
		break;
		case 2:
			frm.faq_category.value = '주문/결제';
		break;
		case 3:
			frm.faq_category.value = '취소/교환/반품';
		break;
		case 4:
			frm.faq_category.value = '배송문의';
		break;
		case 5:
			frm.faq_category.value = '쿠폰/적립금';
		break;
		case 6:
			frm.faq_category.value = '서비스 이용 및 기타';
		break;
		}
		return true;
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
                                <h3 class="panel-title">자주묻는질문 등록</h3>
                                <div class="actions pull-right">
                                    <i class="fa fa-expand"></i>
                                    <i class="fa fa-chevron-down"></i>
                                    <i class="fa fa-times"></i>
                                </div>
                            </div>

                            <div class="panel-body">
                                <form method="post" class="form-horizontal form-border">
               						<input type="hidden" name="faq_category">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">제목</label>
                                        <div class="col-sm-6">
                                            <input type="text" name="faq_subject" class="form-control" placeholder="제목을 입력하세요. ">
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
                                            <textarea style="resize:none; height:500px;" name="faq_content" class="form-control"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-6 pull-right">
                                            <input type="submit" value="등록" class="btn btn-info"/>
                   							<input type="reset" value="초기화" class="btn btn-success"/>
                    						<input type="button" value="글 목록으로... " class="btn btn-danger" onclick="javascript:history.back()"/>
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
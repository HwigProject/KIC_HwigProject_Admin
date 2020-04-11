<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headnav.jsp" %>
<section class="main-content-wrapper">
        <div class="pageheader">
              <h1>상품 수정 페이지</h1>
              <p class="description">상품을 수정하는 페이지입니다</p>
              <div class="breadcrumb-wrapper hidden-xs">
                  <span class="label">You are here:</span>
                  <ol class="breadcrumb">
                      <li class="active">상품 수정</li>
                  </ol>
              </div>
        </div>
	<section id="main-content" class="animated fadeInUp">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>상품 수정</h3>
						<div class="actions pull-right">
							<i class="fa fa-expand"></i>
							<i class="fa fa-chevron-down"></i>
							<i class="fa fa-times"></i>
	                    </div>
					</div>
					<div class="panel-body" id="readdiv">
						<form role="form" method="post" class="form-horizontal form-border" encType="multipart/form-data" id="form">
							<input type="hidden" value="${product.prd_id}" class="prdid">
							<div class="form-group">
								<label class="col-sm-3 control-label" for="category_id">카테고리</label>
								<div class="col-sm-6">
									${cateName}
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="sel_id">판매자 id</label>
								<div class="col-sm-6">
									${product.sel_id}
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_ea">판매단위</label>
								<div class="col-sm-6">
									${product.prd_ea}
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_name">상품명</label>
								<div class="col-sm-6">
									${product.prd_name}
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_thumb">썸네일</label>
								<div class="col-sm-6">
									<input type="hidden" name="prd_thumb"  value="${product.prd_thumb}" />
									<div class="select_thumb">
										<img src="${product.prd_thumb}"/>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_comment">한줄설명</label>
								<div class="col-sm-6">
									${product.prd_comment}
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_img">이미지</label>
								<div class="col-sm-6">
									<input type="hidden" name="prd_img"  value="${product.prd_img}" />
									<div class="select_img">
										<img src="${product.prd_img}"/>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_stock">재고</label>
								<div class="col-sm-6">
									${product.prd_stock}
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_price">원가</label>
								<div class="col-sm-6">
									${product.prd_price}
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_kg">중량/용량</label>
								<div class="col-sm-6">
									${product.prd_kg}
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_from">원산지</label>
								<div class="col-sm-6">
									${product.prd_from}
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_wrap">포장타입</label>
								<div class="col-sm-6">
									${prd_wrap}
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_info">안내사항</label>
								<div class="col-sm-6">
									${product.prd_info}
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-6">	
									<button type="button" id="btn_input" onclick="history.back()" class="btn btn-primary">뒤로가기</button>
									<button type="button" class="btn btn-warning btn_mod">수정</button>
									<button type="button" class="btn btn-danger btn_del">삭제</button>
								</div>
	                        </div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
</section>
<script>
	$('.btn_mod').click(function(){
		var ids = $('.prdid').val(); //prd_id를 얻어온다
		var url = '/product/prd_modify?prd_id='+ids;
		$(location).attr('href', url); //수정 페이지로 이동
	});
	
	$('.btn_del').click(function(){
		var ids = $('.prdid').val(); //prd_id를 얻어온다
		var url = '/product/prd_deletelist?prd_id='+ids;
	
		var result = confirm(ids + "번 상품을 삭제하시겠습니까?"); //상품 삭제 확인 알림
		
		if(result){ //확인을 눌렀을 경우
			$(location).attr('href', url); //삭제를 해 준다
		}
	});
	
	var result = "${msg}";
	if(result == "success") { //완료 사실을 알려준다
		alert("완료되었습니다.")
	}
</script>
<%@ include file="/WEB-INF/views/include/footnav.jsp" %>
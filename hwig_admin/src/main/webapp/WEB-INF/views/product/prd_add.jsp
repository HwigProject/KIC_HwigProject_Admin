<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headnav.jsp" %>
<section class="main-content-wrapper">
        <div class="pageheader">
              <h1>상품 등록 페이지</h1>
              <p class="description">상품을 등록하는 페이지입니다</p>
              <div class="breadcrumb-wrapper hidden-xs">
                  <span class="label">You are here:</span>
                  <ol class="breadcrumb">
                      <li class="active">상품 등록</li>
                  </ol>
              </div>
        </div>
	<section id="main-content" class="animated fadeInUp">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>상품 등록</h3>
						<div class="actions pull-right">
							<i class="fa fa-expand"></i>
							<i class="fa fa-chevron-down"></i>
							<i class="fa fa-times"></i>
	                    </div>
					</div>
					<div class="panel-body">
						<form role="form" method="post" class="form-horizontal form-border" id="form">
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_id">상품 번호</label>
								<div class="col-sm-6">
									<input type="number" class="form-control" id="prd_id" name="prd_id" required="" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="category_id">카테고리 id</label>
								<div class="col-sm-6">
									<input type="number" class="form-control" id="category_id" name="category_id" required="" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="sel_id">판매자 id</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="sel_id" name="sel_id" required="" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_ea">판매단위</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_ea" name="prd_ea" required="" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_name">상품명</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_name" name="prd_name" required="" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_thumb">썸네일</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_thumb" name="prd_thumb" required="" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_comment">한줄설명</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_comment" name="prd_comment" required="" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_img">이미지</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_img" name="prd_img" required="" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_stock">재고</label>
								<div class="col-sm-6">
									<input type="number" class="form-control" id="prd_stock" name="prd_stock" required="" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_price">원가</label>
								<div class="col-sm-6">
									<input type="number" class="form-control" id="prd_price" name="prd_price" required="" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_sale">할인율</label>
								<div class="col-sm-6">
									<input type="number" class="form-control" id="prd_sale" name="prd_sale" required="" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_kg">중량/용량</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_kg" name="prd_kg" required="" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_from">원산지</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_from" name="prd_from" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_wrap">포장타입</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_wrap" name="prd_wrap" required="" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label" for="prd_info">안내사항</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="prd_info" name="prd_info" required="" placeholder="Required input"/>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-6">	
									<button type="button" id="btn_input" class="btn btn-primary">등록</button>
								</div>
	                        </div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
</section>
<%@ include file="/WEB-INF/views/include/footnav.jsp" %>
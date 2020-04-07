<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headnav.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--main content start-->
        <section class="container animated fadeInUp">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div id="login-wrapper">
                    <header>
                        <div class="brand">
                            <a href="index.html" class="logo">
                                <i class="icon-layers"></i>
                                <span>판매자 수정</span></a>
                        </div>
                    </header>
                <div class="panel panel-primary">
                    <div class="panel-heading">
                          <h3 class="panel-title">     
                           
                        </h3>  
                    </div>
                    <div class="panel-body">
                        <form role="form" method="post" action="modify" enctype="multipart/form-data">
                            <div class="form-group">
                                <label for="exampleInputEmail1">사업자등록번호</label>
                                <input type="text" class="form-control" id="sel_id" value="${data.sel_id}" readonly="readonly" name="sel_id">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">비밀번호</label>
                                <input type="password" class="form-control" id="sel_pw" value="${data.sel_pw}" name="sel_pw">
                            </div>
                             <div class="form-group">
                                <label for="exampleInputPassword1">상호명</label>
                                <input type="text" class="form-control" id="sel_cname" value="${data.sel_cname}" name="sel_cname">
                            </div>
                              <div class="form-group">
                                <label for="exampleInputPassword1">대표자명</label>
                                <input type="text" class="form-control" id="sel_name" value="${data.sel_name}" name="sel_name">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">주소</label>
                                <input type="text" class="form-control" id="sel_addr" value="${data.sel_addr}" name="sel_addr">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">전화번호</label>
                                <input type="text" class="form-control" id="sel_tel" value="${data.sel_tel}" name="sel_tel">
                            </div>
                            <div class="form-group">
								<label for="exampleInputFile">파일</label>
								<img src="${data.sel_img}" id="attach_img">
								${data.sel_img}
								<input type="file" id="sel_img" name="attach_img">
 							</div>
                       
                       		<button type="submit" class="btn btn-primary btn-block">수정</button>
                       		<input type="hidden" name="origin_img" value="${data.sel_img}">
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
</script>
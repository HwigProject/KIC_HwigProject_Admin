<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>1대1 문의 조회</title>

</head>
<body>
	<%@ include file="../include/headnav.jsp" %>
	
	<section class="main-content-wrapper">
			<section id="main-content" class="animated fadeInUp">
		           <div class="row" id="qna_row">
  						<div class="col-md-12 col-sm-12" id="view-mail-wrapper">
	                        <div class="panel">
	                            <div class="panel-body">
	                                <header>
	                                    <h2>${qna_view.qna_subject}</h2>
	                                     	작성자 : ${qna_view.mem_id} /	 
	                                      	${qna_view.qna_category}                                   
	                                </header>
	                                
	
	                                <div class="row">
	                                    <div class="col-md-12">
	                                        <div class="panel view-mail-body">
	                                            <div class="panel-body">
	                                                <p>${qna_view.qna_content}</p>
	                                            </div>                              
	                                        </div>
	                                    </div>
	                                </div>
	                                <div class="col-md-12">
	                                	<button class="btn btn-danger pull-right" onclick="location.href='/qna/qna_delete?qna_id=${qna_view.qna_id}&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}'">삭제</button>
	                                    <button class="btn btn-success pull-right" onclick="location.href='/qna/qna_modify?qna_id=${qna_view.qna_id}&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}'">수정</button>	
	                                    <a href="qlist?&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}" class="btn btn-info pull-right">목록</a>	                                   
	                                </div>
	                            </div>
	                        </div>
	                        
	                    </div>
	                   
	                                	
	                              
                   </div>
                   
                   <div class="row" id="reply_row">
  						<div class="col-md-12 col-sm-12" id="view-mail-wrapper">
	                        <div class="panel">
	                            <div class="panel-body">
	                                <header>
	                                    <h2>re:${qna_view.qna_subject}</h2>
	                                    	작성자 : Hwig /	 
	                                      	${qna_view.qna_category}	                                    
	                                </header>

	
	                                <div class="row">
	                                    <div class="col-md-12">
	                                        <div class="panel view-mail-body">
	                                            <div class="panel-body">
	                                            	<p>${rList.reply_content}</p>	   
	                                            </div>
	                                            
	                                            <div class="col-md-12">
			                                		<button class="btn btn-danger pull-right" onclick="location.href='/qna/qna_delete?qna_id=${qna_view.qna_id}&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}'">삭제</button>
			                                        <button class="btn btn-success pull-right" onclick="location.href='/qna/qna_modify?qna_id=${qna_view.qna_id}&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}'">수정</button>                                   
			                                	</div>                                                                
	                                        </div>
	                                    </div>
	                                </div>
	                                
	                                
	                            </div>
	                        </div>
	                    </div>
                   </div>
                   <div class="row" id="reply_upload_row">
  						<div class="col-md-12 col-sm-12" id="view-mail-wrapper">
	                        <div class="panel">
	                            <div class="panel-body">
	                            <form role="form" method="post" autocomplete="off" id="reply_form">
	                            	<input type="hidden" id="qna_id" name="qna_id" value="${qna_view.qna_id}"/>
	                            	<input type="hidden" id="page" name="page" value="${cri.page}"/>
	                            	<input type="hidden" id="perPageNum" name="perPageNum" value="${cri.perPageNum}"/>
	                            	<input type="hidden" id="searchType" name="searchType" value="${cri.searchType}"/>
	                            	<input type="hidden" id="keyword" name="keyword" value="${cri.keyword}"/>

	                                <header>
	                                    <h2>re:${qna_view.qna_subject}</h2>
	                                    	작성자 : Hwig /	 
	                                      	${qna_view.qna_category}	                                    
	                                </header>

	
	                                <div class="row">
	                                    <div class="col-md-12">
	                                        <div class="panel view-mail-body">
	                                            <div class="panel-body">
	                                            	<div class="col-sm-8">
			                                            <textarea style="resize:none; height:500px;" id="reply_content" name="reply_content" class="form-control"></textarea>
			                                        </div>
			                                        <div class="col-sm-4">
			                                        	 <button type="button" id="hd">머리말</button>  <textarea id="hdt"></textarea> <p>
	
														 <button type="button" id="bd">본문</button>   <textarea id="bdt"></textarea> <p>
													
														 <button type="button" id="ti">꼬리말</button>  <textarea id="tit"></textarea> <p>
													
														 <button type="button" id="mix">합체!</button>
			                                        </div>
	                                            </div>                                                                
	                                        </div>
	                                    </div>
	                                </div>
	                            
	                            
	                                <div class="row">
	                                	<div class="col-md-12">
	                                		<button type="button" id="reply_write_bt" class="btn btn-danger pull-right" >등록</button>	                                        	
	                                        <a href="qlist?&page=${cri.page}&perPageNum=${cri.perPageNum}&searchType=${cri.searchType}&keyword=${cri.keyword}" class="btn btn-info pull-right">목록</a>	                                   
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
	<script> //답글 Post
		$("#reply_write_bt").click(function(){
			$("#reply_form").attr("action", "reply_write");
			$("#reply_form").submit();
		})
	</script>
	
	<script> //답글 유무에 따라 나오는 메뉴 달라지게 하기
		var r_data = "${rList.reply_content}";
			
		console.log(r_data);
		if(r_data==""){
			$("#reply_row").hide();
		} else {
			$("#reply_upload_row").hide();
		}
	</script>
	
	<script> //버튼 매크로
	var txt = "";
	var hdtx = "";
	var bdtx = "";
	var titx = "";
	var data = new Array();
	data[0] = "${macro.macro_head}";
	data[1] = "${macro.macro_content}";
	data[2] = "${macro.macro_tail}";
	
	console.log(data[0]);
	
	$(function(){
		$('#hd').click(function(){
			$('#hdt').text(data[0]+"<br><br>");
			hdtx = $('#hdt').text();
			
		})

		 $('#bd').click(function(){
			$('#bdt').text(data[1]+"<br><br>");
			bdtx = $('#bdt').text();

		})

		$('#ti').click(function(){
			$('#tit').text(data[2]+"<br><br>");
			titx = $('#tit').text();

		}) 

		$('#mix').click(function(){
			txt = hdtx + bdtx + titx;
			
			$('#reply_content').html(txt);
		})

	})
</script>  
</body>
</html>
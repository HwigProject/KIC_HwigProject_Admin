<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>자주묻는질문</title>
<script>
    var result = "${msg}";
    if(result == "success"){
        alert("완료되었습니다.");
    }
</script>
</head>
<body>
	<%@ include file="../include/headnav.jsp" %>
		<section class="main-content-wrapper">
            <div class="pageheader">
                <h1>자주묻는질문 관리</h1>
                <div class="breadcrumb-wrapper hidden-xs">
                    <span class="label">You are here:</span>
                    <ol class="breadcrumb">
                        <li><a href="index.html">Dashboard</a>
                        </li>
                        <li>Tables</li>
                        <li class="active">Data Tables</li> 
                    </ol>
                </div>
            </div>
            <section id="main-content" class="animated fadeInUp">
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h1>자주묻는질문 관리 <a href="/faq/faq_write" class="btn btn-info">추가</a></h1> 
                                
                                <div class="actions pull-right">
                                    <i class="fa fa-expand"></i>
                                    <i class="fa fa-chevron-down"></i>
                                    <i class="fa fa-times"></i>
                                </div>
                            </div>
                            <div class="panel-body">
                                <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                            <th>글 번호</th>
                                            <th>카테고리</th>
                                            <th>제목</th>
                                            <th>관리</th>
                                        </tr>
                                    </thead>

                                    <tbody>
	                                    <c:forEach var="fList" items="${fList}">
											<tr>
												<td>${fList.faq_id}</td>
												<td>${fList.faq_category}</td>
												<td><a href="faq_view?faq_id=${fList.faq_id}">${fList.faq_subject}</a></td>
												<td>
													<button type="button" onclick="location.href='/faq/faq_modify?faq_id=${fList.faq_id}'" class="btn btn-success">수정</button>
                                					<button type="button" onclick="location.href='/faq/faq_delete?faq_id=${fList.faq_id}'" class="btn btn-danger">삭제</button>
                                				</td>
											</tr>
										</c:forEach>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </section>
	<%@ include file="../include/footnav.jsp" %>
</body>
</html>
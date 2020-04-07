<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>공지사항</title>
</head>
<body>
	<%@ include file="../include/headnav.jsp" %>
		<section class="main-content-wrapper">
            <div class="pageheader">
                <h1>공지사항 관리</h1>
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
                                <h1>공지사항 관리 <a href="/notice/notice_write" class="btn btn-info">추가</a></h1> 
                                
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
                                            <th>제목</th>
                                            <th>작성일</th>
                                            <th>조회수</th>
                                            <th>관리</th>
                                        </tr>
                                    </thead>

                                    <tbody>
	                                    <c:forEach var="nList" items="${nList}">
											<tr>
												<td>${nList.notice_id}</td>
												<td><a href="notice_view?notice_id=${nList.notice_id}">${nList.notice_subject}</a></td>
												<td>${nList.notice_regdate}</td>
												<td>${nList.notice_hit}</td>
												<td>
													<button type="button" onclick="location.href='/notice/notice_modify?notice_id=${nList.notice_id}'" class="btn btn-warning">수정</button>
                                					<button type="button" onclick="location.href='/notice/notice_delete?notice_id=${nList.notice_id}'" class="btn btn-danger">삭제</button>
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
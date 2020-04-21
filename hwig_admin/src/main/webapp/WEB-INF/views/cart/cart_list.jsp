<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/include/headnav.jsp" %>

<section class="main-content-wrapper">
장바구니!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
<table>
	<c:forEach items="${cartlist}" var="cartlist">
		<tr>
			<td>${cartlist.PRD_NAME}</td>
			<td>${cartlist.PRD_PRICE}</td>
			<td>${cartlist.ORDER_COUNT}</td>
			<td><img src="${cartlist.PRD_THUMB}" /></td>
		</tr>
	</c:forEach>
</table>
</section>
<%@ include file="/WEB-INF/views/include/footnav.jsp" %>
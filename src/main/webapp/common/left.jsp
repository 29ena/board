<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="col-sm-3 col-md-2 sidebar">
		<ul class="nav nav-sidebar">
			<li class="active"><a href="${pageContext.request.contextPath}/insertBoard">게시판생성</a></li>
			<c:forEach items="${board_List }" var="board">
				<c:set var="boardYN" value="${board.board_yn }"/>
					<c:if test="${boardYN eq 'Y' }">
						<li class="active"><a href="${pageContext.request.contextPath}/articlePagingList?board_id=${board.board_id}&board_name=${board.board_name}">${board.board_name }</a></li>
					</c:if>
			
			</c:forEach>
			
		</ul>
	</div>
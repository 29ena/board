<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>사용자리스트</title>
<!-- css, js -->
<%@include file="/common/basicLib.jsp" %>
<style>
	.articleTr:hover{
		cursor:pointer;
	}
</style>
<script>
	$(document).ready(function(){
		$(".articleTr").on("click",function(){
			console.log("articleTr click");
			
			var article_id = $(this).find(".article_id").text();
			$("#article_id").val(article_id);
			
			// #frm을 이용하여 submit();
			$("#frm").submit();
		});
		
	});
</script>
</head>

<body>
	
	<!-- header -->
	<%@include file="/common/header.jsp" %>	
	
	<div class="container-fluid">
		<div class="row">
			
		<!-- left -->
		<%@include file="/common/left.jsp" %>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
             <div class="row">
				<div class="col-sm-8 blog-main">
					<h2 class="sub-header">${param.board_name }</h2>
					<!-- 사용자 상세조회 : userId가 필요 -->
					<form id="frm" action="${pageContext.request.contextPath }/articleController" method="get">
							<input type="hidden" id="article_id" name="article_id"/>
					</form>	
					
					<div class="table-responsive">
						<table class="table table-striped">
							<tr>
								<th>게시글 번호</th>
								<th>제목</th>
								<th>작성자 아이디</th>
								<th>작성일시</th>
							</tr>
							<!-- 향상된 for -->
							<c:forEach items="${articleList }" var="article">
									<tr class = "articleTr" data-article_id="${article.article_id }">
										<td class="article_id">${article.article_id }</td>
										<td>${article.article_title }</td>
										<td>${article.article_userid }</td>
										<td><fmt:formatDate value="${article.article_dt }" pattern="yyyy-MM-dd"/> </td>
									</tr>
								</c:forEach>
						</table>
					</div>
					
					<a href="${pageContext.request.contextPath }/articleWrite" class="btn btn-default pull-right">새글 등록</a>
					<!-- 사용자 수 : 105건
						  페이지네이션 : 11건
					  -->
					<div class="text-center">
						<ul class="pagination">
							
							
							
								<c:choose>
									<c:when test="${pageVo.page == 1 }">
										<li class="disabled">
										<span>«</span>
										</li>
									</c:when>
									<c:otherwise>
										<li>
											<a href="${pageContext.request.contextPath}/articlePagingList?page=${pageVo.page -1 }&pageSize=${pageVo.pageSize}" >«</a>
										</li>
									</c:otherwise>
								</c:choose>
								<c:forEach begin="1" end= "${paginationSize }" var="i">
									<c:choose>
										<c:when test="${pageVo.page == i}">
											<li	class = "active">										
									  			<span>${i }</span>
								  			</li>
										</c:when>
										<c:otherwise>
											<li>
											<a href="${pageContext.request.contextPath}/articlePagingList?page=${i }&pageSize=${pageVo.pageSize}">${i }</a>
											</li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							
								<c:choose>
									<c:when test="${pageVo.page == paginationSize }">
										<li class="disabled">
											<span>»</span>
										</li>
									</c:when>
									<c:otherwise>
										<li>
											<a href="${pageContext.request.contextPath}/articlePagingList?page=${pageVo.page +1 }&pageSize=${pageVo.pageSize}">»</a>
										</li>
									</c:otherwise>
								</c:choose>
						</ul>
					</div>
				</div>
			</div>
         </div>
         
      </div>
   </div>
</body>
</html>

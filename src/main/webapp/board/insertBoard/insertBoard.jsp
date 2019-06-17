<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script>
	$(document).ready(function(){
		$("#regBtn").on("click", function(){
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
					<h2 class="sub-header">사용자</h2>
					<div class="table-responsive">
						
						<table class="table table-striped">
						   <form id= "frm" class="form-horizontal" role="form" action="${pageContext.request.contextPath }/insertBoard" method="post">
							<tr>
								<td><label>게시판이름</label></td>
								<td>
									<input type="text" class="form-control" name="board_name" value="${param.board_name }"/>
								</td>
								<td>
									<select name="board_yn" class="form-control">
										<option value="Y" >사용</option>
										<option value="N" >미사용</option>
									</select>
								</td>
								<td>
									<input type="button" id="regBtn" class="btn btn-default" value="생성"/>
								</td>
								
							</tr>
							</form>
							
							<c:forEach items="${board_List }" var="board">
								<form  class="form-horizontal" role="form" action="${pageContext.request.contextPath }/updateBoard"  method="post">			
								<tr>
									<td><label>게시판이름</label></td>
									<td><input type="text" name="uboard_name" class="form-control" value="${board.board_name }"/></td>
									<td>
									<select name="uboard_yn" class="form-control">
										<c:choose>
										<c:when test="${board.board_yn =='Y'}">
											<option value="Y" selected="selected">사용</option>
											<option value="N" >미사용</option>
										</c:when>
										<c:otherwise>
											<option value="Y" >사용</option>
											<option value="N" selected="selected">미사용</option>
										
										</c:otherwise>
									</c:choose>
									</select>
									</td>
									<td>
										<input type="submit" id="updateBtn" class="btn btn-default" value="수정"/>
										<input type="hidden" name="board_id"  value="${board.board_id}"/>
									</td>
									</tr>
									</form>
							</c:forEach>
						</table>
							
						
					</div>

				
				</div>
			</div>
         </div>
      </div>
   </div>
</body>
</html>

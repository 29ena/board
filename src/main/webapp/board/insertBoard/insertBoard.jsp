<%@page import="kr.or.ddit.paging.model.PageVo"%>
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

<title>사용자페이징리스트</title>
<!-- css, js -->
<%@include file="/common/basicLib.jsp" %>

<style>
	.userTr:hover{
		cursor:pointer;
	}
</style>
<script>
	$(document).ready(function(){
		$(".userTr").on("click",function(){
			
			console.log("userTr click");
			// userId를 획득하는 방법
			//$(this).find("userId").text();
			//$(this).data("userid");
			
			// 사용자 아이디를 #userId 값으로 설정해주고
			
		
		var userId = $(this).find(".userId").text();
		$("#userId").val(userId);
		
		// #frm을 이용하여 submit();
		$("#frm").submit();
	});
});
</script>
<style>
	
</style>
</head>

<body>
	<!-- header -->
	<%@include file="/common/header.jsp" %>	
	
	<div class="container-fluid">
		<div class="row">
			
		<!-- left -->
		<%@include file="/common/left.jsp" %>
		
         <div>
             <div class="row">
				<div class="col-sm-8 blog-main">
					<h2 class="sub-header">사용자</h2>
					<!-- 사용자 상세조회 : userId가 필요 -->
					
						<div class="text-center">
					<form id="frm" action="${pageContext.request.contextPath }/insertBoard" method="get">
								<table border="1">
									<tr>
									<c:forEach items="${boardList }" var="board">
									
									${board.board_name }
									</c:forEach>
									</tr>
									<tr>
										<input type="text" class="boardNm" name="boardNm"/>
									</tr>
									<tr>
										<select name="combo">
											<option value="Y">사용</option>
											<option value="N">미사용</option>
										</select>
									</tr>
									<tr>
										<input type="submit" name="reg" value="생성"/>
									</tr>
								</table>
								
						 		
						</div>
					</form>
				</div>
			</div>
         </div>
      </div>
   </div>
</body>
</html>
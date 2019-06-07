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

<title>게시글 보기</title>
<!-- css, js -->
<%@include file="/common/basicLib.jsp" %>
<style>
	
</style>
<script>

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
					<h2 class="sub-header">게시글 보기</h2>
					<!-- 사용자 상세조회 : userId가 필요 -->
					<form id="frm" action="${pageContext.request.contextPath }/articleController" method="get">
							<input type="hidden" id="article_id" name="article_id"/>
					</form>
					<div class="text-left">
						<div class="form-group">
                        <label for="article_title" class="col-sm-2 control-label">제목</label>
	                        <div class="col-sm-10">
	                           <label class="control-label">${articleVo.article_title }</label>
	                        </div>
						</div>
						
						<div class="form-group">
                        <label for="article_content" class="col-sm-2 control-label">글 내용</label>
	                        <div class="col-sm-10">
	                           <label class="control-label">${articleVo.article_content }</label>
	                        </div>
						</div>
						
						<div class="form-group">
                        <label for="attach" class="col-sm-2 control-label">첨부파일</label>
	                        <div class="col-sm-10">
	                           <label class="control-label">?</label>
	                        </div>
						</div>
						
						<div class="form-group">
                        <label for="attach" class="col-sm-2 control-label">댓글</label>
	                        <div class="col-sm-10">
	                           <label class="control-label">?!</label>
	                        </div>
						</div>
						
					</div>
					
				</div>
         	</div>
      	</div>
   	</div>
 </body>
</html>

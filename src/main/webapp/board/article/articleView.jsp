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
	$(document).ready(function(){
		$("#modifyBtn").on("click",function(){
			$("#frm").attr("action", "${pageContext.request.contextPath}/articleModify");
			$("#frm").submit();
		});
		$("#deleteBtn").on("click",function(){
			$("#frm").attr("action", "${pageContext.request.contextPath}/articleDelete");
			$("#frm").attr("method","post");
			$("#frm").submit();
		});
		$("#commentBtn").on("click",function(){
			$("#frm").attr("action","${pageContext.request.contextPath}/articleComment");
			$("#frm").submit();
		});
	});
</script>
</head>

<body>
<!-- header.jsp -->
   <%@include file="/common/header.jsp" %>
   
   <div class="container-fluid">
      <div class="row">

         <!-- left -->
         <%@include file="/common/left.jsp" %>
         
         <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="row">
               <div class="col-sm-8 blog-main">
                  <h2 class="sub-header">게시글 보기</h2>
                  
                 	<form id="frm" class="form-horizontal" role="form" action="${pageContext.request.contextPath }/articleController" method="get">
                 		<input type="hidden"  name="article_id" value="${articleVo.article_id }"/> 
                 		<input type="hidden" name="article_pid" value="${articleVo.article_id }"/> 
                     <div class="form-group">
                        <label for="article_title" class="col-sm-2 control-label">제목</label>
                        <div class="col-sm-10">
                               <label class="control-label" name="article_title">${articleVo.article_title }</label>
                        </div>
                     </div>
                    
                     <div class="form-group">
                        <label for="article_title" class="col-sm-2 control-label">글 내용</label>
                        <div class="col-sm-10">
                               <label class="control-label" name="article_content">${articleVo.article_content }</label>
                        </div>
                     </div>
      
                     <div class="form-group">
                        <label class="col-sm-2 control-label">첨부파일</label>
                        <div class="col-sm-6">
                        	<c:forEach items="${fileList }" var="list">
                 		       <a href="${pageContext.request.contextPath}/fileDownload?attach_id=${list.attach_id}"> ${list.attach_name}</a><br>
                        	</c:forEach>
                        </div>
                        <div class="col-sm-4">
										  
						  	<c:if test="${articleVo.article_userid eq userId}">
						 		<input type="button" id="modifyBtn" name="modifyBtn" class="btn btn-default" value="수정"/>
						  		<input type="button" id="deleteBtn" name="deleteBtn" class="btn btn-default" value="삭제"/>
						  	</c:if>
						  <input type="button" id="commentBtn" name="commentBtn" class="btn btn-default" value="답글"/>
						  	
                        </div>
                     </div>
                     </form>
                     <div class="table-responsive">
						<table class="table table-striped">
							
							<!-- 향상된 for -->
							<c:forEach items="${replyList }" var="reply" varStatus="status">
								<c:if test="${reply.reply_delete eq 'N'}">
									<c:choose>
										<c:when test="${reply.reply_userid eq userId}">
										<input type="hidden" name="article_id" value="${articleVo.article_id }"/>
										
								<tr class ="replyid" >
									<td class="col-sm-1">댓글</td>
									<td>${reply.reply_content }</td>
									<td>[${reply.reply_userid } / <fmt:formatDate value="${reply.reply_dt}" pattern="yyyy-MM-dd" />]<a class="btn btn-default pull-right" href="${pageContext.request.contextPath}
									/replyDelete?reply_id=${reply.reply_id}&article_id=${articleVo.article_id}">삭제</a></td>
								</tr>
								</c:when>
										<c:otherwise>
											<tr class ="replyid" >
												<td class="col-sm-1">댓글</td>
												<td>${reply.reply_content }</td>
												<td>[${reply.reply_userid } / <fmt:formatDate value="${reply.reply_dt}" pattern="yyyy-MM-dd" />]</td>
											</tr>
										</c:otherwise>
									</c:choose>
								</c:if>
								<c:if test="${reply.reply_delete eq 'Y'}">
								<tr>
								<td class="col-sm-1">댓글</td>
								<td>삭제된 댓글입니다.</td>
								<td></td>
								</tr>
								</c:if>
							</c:forEach>
									<form id="reply" class="form-horizontal" role="form" action="${pageContext.request.contextPath }/replyWrite" method="post">
								<tr>
                                	<input type="hidden" id="reply_article" name="reply_article" value="${articleVo.article_id }"/>
                                	<input type="hidden" id="reply_userid" name="reply_userid" value="${replyVo.reply_userid }"/>
                                	<input type="hidden" id="article_id" name="article_id" value="${articleVo.article_id }"/>
                                	<td class="col-sm-1">댓글</td>
									<td>
									<input type="text" class="form-control" id="reply_content" name="reply_content"
	                                 value="${param.reply_content }"/>
	                                </td>
									<td><button type="submit" id="replyBtn" name="replyBtn" class="btn btn-default">댓글 저장</button></td>
                                </tr>
                                 	</form>
						</table>
					</div>
                     
               </div>
            </div>
         </div>
      </div>
   </div>
 </body>
</html>

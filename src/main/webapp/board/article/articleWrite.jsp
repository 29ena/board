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

<title>새글 등록</title>
<!-- css, js -->
<%@include file="/common/basicLib.jsp" %>
<style>

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>


<script src="${pageContext.request.contextPath }/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">
var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

$(document).ready(function() {
   // Editor Setting
   nhn.husky.EZCreator.createInIFrame({
      oAppRef : oEditors, // 전역변수 명과 동일해야 함.
      elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
      sSkinURI : "${pageContext.request.contextPath }/SE2/SmartEditor2Skin.html", // Editor HTML
      fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
      htParams : {
         // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
         bUseToolbar : true,
         // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
         bUseVerticalResizer : true,
         // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
         bUseModeChanger : true, 
      }
   });

   // 전송버튼 클릭이벤트
   $("#savebutton").click(function(){
      if(confirm("저장하시겠습니까?")) {
         // id가 smarteditor인 textarea에 에디터에서 대입
         oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

         // 이부분에 에디터 validation 검증
         if(validation()) {
            $("#frm").submit();
         }
      }
   });
   
   $("#addBtn").on("click",function(){
// 	      var fileLength = $(".filelable").length;
	      
// 	      if($(".myfiles").length + fileLength > 4) {
// 	         alert("첨부파일은 최대 5개 입니다.");
// 	         return;
// 	      }
		if($(".myfiles").length < 5){		
		newfile = $("<input/>", {
	      "type" : "file", 
	      "class" : "myfiles", 
	      "name" : "myfile"
		});
	      $(this).parent().append(newfile);
		}else{
			alert("최대 5개의 파일을 올릴 수 있습니다.")
		}
		
   });
   
   
});

// 필수값 Check
function validation(){
   var contents = $.trim(oEditors[0].getContents());
   if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
      alert("내용을 입력하세요.");
     oEditors.getById['smarteditor'].exec('FOCUS');
      return false;
   }

   return true;
}

</script>
</head>

<body>
	
	<!-- header -->
	<%@include file="/common/header.jsp" %>	
	
		<!-- left -->
		<%@include file="/common/left.jsp" %>
			<div class="table-responsive">
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<div class="col-sm-10 blog-main">
						<h2 class="sub-header">새글 등록</h2>
					</div> 
					<form id = "frm" class="form-hrizontal" role="form" action="${pageContext.request.contextPath }/articleWrite"
								method="post" enctype="multipart/form-data">
								<input type="hidden" id="board_id" name="board_id" value="${board_id}"/>
					<table class="table table-striped">
						<tr>
						<td><label>제목</label></td>
						<td><input class="form-control" id="aricle_title" name="article_title" type="text" value="${param.article_title}"/></td>
						</tr>
						<tr>
						<td>글 내용</td>
						<td>
							
			   				<textarea name="article_content" id="smarteditor" value="${param.article_content }" rows="10" cols="100" 
			   								style="width:750px; height:412px;"></textarea> 
							
						</td>
						</tr>	
						<tr>
					
						<td class="col-sm-1">첨부파일</td>
						<td >
						 <div class="form-group">
	                        <div >
	                        	<button id = "addBtn" type="button" class="btn btn-default">추가</button>
	                        </div>
                    	 </div>
						</td>
						<td></td>
						<td><button type="button" id="savebutton" name="savebutton" class="btn btn-default">저장</button></td>
						</tr>
		  			</table>
		  			</form>
				</div>
	   		</div>
 	</body>
</html>

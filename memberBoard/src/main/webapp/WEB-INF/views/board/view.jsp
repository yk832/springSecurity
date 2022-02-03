<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="_csrf_header" id="_csrf_header" content="${_csrf.headerName}">
<meta name="_csrf" id="_csrf" content="${_csrf.token}">
<title>게시물 조회</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../resources/js/ajax.js?v_0.1"></script>
<script type="text/javascript">

$(document).ready(function(){
	showReplyList();
	
});



</script>
</head>
<body>
	
	<label>제목</label>
	${view.title}<br />
	<label>작성자</label>
	${view.reg_id}<br/>
	<label>내용</label><br />
	${view.content}<br />
	
	
	<hr>
	
	<div>
		<p>
			<label>댓글 작성자</label> <input type="text" id="reWriter">
		</p>
		<p>
			<textarea rows="5" cols="50" id="reContent"></textarea>
		</p>
		<p>
		<input type="hidden" id="bno" value="${view.bno}">
			<button onclick="sendReply()">댓글 작성</button>
		</p>
	</div>
	<hr/>
	<div>
		<a href="./modifyForm?bno=${view.bno}&mode=modi">게시물수정</a>, <a href="./deleteBoard?bno=${view.bno}">게시물 삭제</a> , <a href="./getBoardList">게시물 목록</a>
	</div>
	
	<hr />
	
	<div id="replyList" class="reList" style="font-size : 13px;">
	</div>
	<div id="replyPaging" style="font-size : 16px; ">
	</div>
	

</body>
</html>

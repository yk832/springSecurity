<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
</head>
<body>

<form action="insertBoards" method="post">

<input type="hidden" name="bno" value="${view.bno}"/>
<input type="hidden" name="mode" value="modify"/> 

	<label>제목</label>
	<input type="text" name="title" value="${view.title}" />
	<br />
	
	<label>작성자</label>
	<input type="text" name="reg_id" value="${view.reg_id}" readonly/>
	<br />
	
	<label>내용</label>
	<textarea cols="50" rows="5" name="content">${view.content}</textarea>
	<br />
	
	<button type="submit">작성</button>
	
</form>



</body>
</html>

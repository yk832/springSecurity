<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<c:set var="today" value="<%=new java.util.Date() %>"/>

<html>
<head>
<%@ include file="../include/header.jsp"%>
<title>Home</title>

<style type="text/css">

td{
	text-align:center;
}
.selectBox{
padding-left : 70px; 
}

</style>

﻿<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>﻿
<script>

//게시글 작성 이벤트
function boardForm(){
	location.href = "/board/boardForm";
}

</script>

	
</head>
<body>
<h3>게시판 getBoardList </h3>
	<table class="table table-striped table-sm">
		<colgroup>
			<col style="width:5%;" />
			<col style="width:auto;" />
			<col style="width:15%;" />
			<col style="width:10%;" />
			<col style="width:10%;" />
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
		</thead>
		
		<tbody>
		<!-- 게시글 없을때 화면 구현 필요 -->
			<c:forEach items="${list}" var ="list" >
				<tr>
					<td>${list.bno}</td>
					<td><a href="/board/getView?bno=${list.bno}&mode=view">${list.title}</a></td>
					<td>${list.reg_dt}</td>
					<td>${list.reg_id}</td>
					<td>${list.view_cnt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="selectBox">
		<button onclick="boardForm()">게시글 작성</button>
		<c:if test="${page.prev}">
		 	<span>[ <a href="/board/getBoardList?num=${page.startPageNum - 1}&type=${search.searchType}&input=${search.input}">이전</a> ]</span>
		</c:if>
		
		<c:forEach begin="${page.startPageNum}" end="${page.endPageNum}" var="num">
			  <span>
				   <c:if test="${select != num}">
				   		<a href="/board/getBoardList?num=${num}&type=${search.searchType}&input=${search.input}">${num}</a>
			 	   </c:if>    
				  
				  <c:if test="${select == num}">
				   	<b>${num}</b>
				  </c:if>
			 </span>
		</c:forEach>
		
		<c:if test="${page.next}">
		 	<span>[ <a href="/board/getBoardList?num=${page.endPageNum + 1}&type=${search.searchType}&input=${search.input}">다음</a> ]</span>
		</c:if>
	</div>
	<br>
	<div class="selectBox">
		<select id='searchBox'>
			<option value="title" <c:if test="${search.searchType eq 'title'}">selected</c:if> >제목</option>
			<option value="content" <c:if test="${search.searchType eq 'content'}">selected</c:if> >내용</option>
			<option value="reg_id" <c:if test="${search.searchType eq 'reg_id'}">selected</c:if> >작성자</option>
			<option value="titleContent" <c:if test="${search.searchType eq 'titleContent'}">selected</c:if> >제목/내용</option>
		</select>
		<input type="text" id="searchInput" value="${search.input.equals('') ? '' : search.input}"/>
		<button onclick="search()">검색</button>
	</div>

</body>
</html>

<script>
	
	//게시글 검색 
	function search(){

		var optionVal = $('#searchBox').val();
		var inputVal = $('#searchInput').val();
		
		if(inputVal == ""){
			return false;
		} 
		
		location.href = "/board/getBoardList?searchType="+optionVal+"&input="+inputVal;
		
		
		
	}
</script>


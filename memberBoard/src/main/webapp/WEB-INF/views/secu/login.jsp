<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <!-- URL : http://localhost:8080/  -->
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>login</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
       	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
        <style>
            .page{
                position:absolute;
                top:40%;
                left:50%;
                transform:translate(-50%, -50%);
            }
        </style>
    </head>
    <body>
        <div class="page">
            <div class="title">
                <h1>Login Page</h1>
            </div>
            <div class="content form-horizontal align-items-center">
				<form action="/login" method="post">
					<div class="form-group">
					<label for="username" class="control-label">아이디</label>
					<input type="text" class="form-control" name="loginId" placeholder="login">
					   
					<label for="password" class="control-label">비밀번호</label>
					<input type="password" class="form-control" name="loginPw" placeholder="password">
					<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
					
					<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
					    <font color="red">
					        <p>Your login attempt was not successful due to <br/>
					            ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
					        <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
					    </font>
					</c:if>
					</div>
					<div class="form-group">
					<input type="submit" value="로그인" class="btn btn-primary btn-block">
					</div>
				</form>
           	<div class="form-group">
                   <input type="submit" value="회원가입" class="btn btn-primary btn-block">
                </div>
            </div>
        </div>
        
        
    </body>
</html>


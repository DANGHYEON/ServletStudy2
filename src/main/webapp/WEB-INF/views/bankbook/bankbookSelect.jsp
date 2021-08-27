<%@page import="com.iu.s1.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/ttest.css" rel="stylesheet">
</head>
<body>
	<h1 id="title">BankBook Select Page</h1>
	

	
	<h2>num : ${dto.bookNumber}</h2>
	<h3>Name : ${requestScope.dto.bookName }</h3>
	<h3>count : ${count}</h3>
	<h3>name : ${name}</h3>
	<h3>SE : ${sessionScope.se}</h3>
	<h3>SE : ${se}</h3>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="./css/test.css" rel="stylesheet">
<style type="text/css">
	h1{
		color : blue;
	}
	h3{
		color :lime;
	}
	a {
		color: black;
		
		}
</style>
</head>
<body>
	<h1>Index Page</h1>
	<h3 style="color: red;">Member</h3>
	
	<p>
		<a href="/ServletStudy2/member/memberLogin.do?id=t1&pw=123">Member Login</a><br>
		<a href="./member/memberJoin.do">Member Join</a><br>
		<a href="member/memberPage.do">MyPage</a>
	</p>
	
	<h3>Bankbook</h3>
	
	<p>
		<a href="/ServletStudy2/bankbook/bankbookList.do">bankbook List</a><br>
		<a href="./bankbook/bankbookInsert.do">bankbook Insert</a><br>
		<a href="bankbook/bankbookSelect.do?booknumber=1">bankbook Select</a>
	
	</p>
	
	<h2 class="c1 c2">Button</h2>

	<button class="c1">CLICK </button>	
	
	
	<div id="circle">circle</div>
	
</body>
</html>
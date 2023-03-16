<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Laboratory</title>
<link rel="stylesheet" href="css/register.css">
</head>
<body>
<header>
    <div class="header">
    	<div class="left">
    		<h1 class="title">会員ID新規登録</h1>
    	</div>
    </div>
</header>
<img src="img/register1.png"alt="">
<form action="RegisterUser2Servlet"method="get">
	<input type="email"name="email"placeholder="メールアドレス">
	<input type="button"name="button"><a href="./TermspageServlet">利用規約</a>	に同意します<br>
	<input type="submit" id ="button" value="Search">
</form>
<h1><img alt="" src="img/orline.png"></h1>
<div class="">
	<a class=button_a></a>
</div>
</body>
</html>
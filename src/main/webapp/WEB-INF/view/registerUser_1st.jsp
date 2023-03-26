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
<%
	request.setCharacterEncoding("UTF-8");
	String errorCode=request.getParameter("error");
	if(errorCode!=null&&errorCode.equals("1")){
%>
<header>
    <div class="header">
    	<div class="center">
    		<a class=title>会員ID新規登録</a>
    	</div>
    </div>
</header>
<p style="color:red; text-align: center;font-size: 1.3rem">登録に失敗しました。</p>
<div class="checkpoint">
	<img src="img/register1.png"alt="">
</div>
<br>
<br>
<br>
<div class="searchbox">
	<form action="./RegisterUser2Servlet"method="get">
		<input type="email"name="email"class="search"autocomplete="off"placeholder="メールアドレス"><br><br><br>
		<input type="radio"name="button"value="on"><a href="./TermspageServlet" class="button">利用規約</a>に同意します<br><br>
		<input type="submit" id ="button" class="submit"value="新規登録">
	</form>
</div>
<br>

<h2>・・・・・・・・・・・・・・・・・・・・・・・または・・・・・・・・・・・・・・・・・・・・・・</h2>
<br>
<div class="loginbutton">
<a class="button_a"href="./LoginServlet">会員登録IDをお持ちの方はこちら　　　　　　　　　　　　▷</a>
</div>
<%
	}else{
%>
<header>
    <div class="header">
    	<div class="center">
    		<a class=title>会員ID新規登録</a>
    	</div>
    </div>
</header>

<div class="checkpoint">
	<img src="img/register1.png"alt="">
</div>
<br>
<br>
<br>
<div class="searchbox">
	<form action="./RegisterUser2Servlet"method="get">
		<input type="email"name="email"class="search"autocomplete="off"placeholder="メールアドレス"><br><br><br>
		<input type="radio"name="button"value="on"><a href="./TermspageServlet" class="button">利用規約</a>に同意します<br><br>
		<input type="submit" id ="button" class="submit"value="新規登録">
	</form>
</div>
<br>
<h2>・・・・・・・・・・・・・・・・・・・・・・・または・・・・・・・・・・・・・・・・・・・・・・</h2>
<br>
<div class="loginbutton">
<a class="button_a"href="./LoginServlet">会員登録IDをお持ちの方はこちら　　　　　　　　　　　　▷</a>
</div>
<%} %>
</body>
</html>
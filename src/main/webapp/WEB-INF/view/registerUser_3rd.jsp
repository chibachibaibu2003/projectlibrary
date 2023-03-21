<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"href="css/register3.css">
<title>Book Laboratory</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String email=request.getParameter("email");
	String errorCode=request.getParameter("error");
	if(errorCode!=null&&errorCode.equals("1")){
%>
<header>
    <div class="header">
    	<div class="center">
    		<a>会員ID新規登録</a>
    	</div>
    </div>
</header>
<p style="color:red; text-align: center;font-size: 1.3rem">登録に失敗しました。</p>
<div class="checkpoint">
	<img src="img/register4new.png"alt="">
</div>
<br>
<div class="searchbox">
	<form action="./RegisterUser4Servlet"method="post">
		<input type="text"name="familyname"class="search" autocomplete="off"placeholder="姓">
		<input type="text"name="firstyname"class="search" autocomplete="off"placeholder="名"><br>
		<input type="password"name="pass"class="passbox" autocomplete="off"placeholder="パスワード　英数10字以上"><br>
		<input type="hidden"name="email"value="<%=email%>">
		<input type="submit"id="button"value="登録">
	</form>
</div>
<%
	}else{
%>
<header>
    <div class="header">
    	<div class="center">
    		<a>会員ID新規登録</a>
    	</div>
    </div>
</header>
<br>
<div class="checkpoint">
	<img src="img/register4new.png"alt="">
</div>
<br>
<div class="searchbox">
	<form action="./RegisterUser4Servlet"method="post">
		<input type="text"name="firstname"class="search" autocomplete="off"placeholder="姓">
		<input type="text"name="familyname"class="search" autocomplete="off"placeholder="名"><br>
		<input type="password"name="pass"class="passbox" autocomplete="off"placeholder="パスワード　英数10字以上"><br>
		<input type="hidden"name="email"value="<%=email%>">
		<input type="submit"id="button"value="登録">
	</form>
</div>
<%} %>
</body>
</html>
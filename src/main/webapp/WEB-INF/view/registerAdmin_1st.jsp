<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Laboratory</title>
<link rel="stylesheet"href="css/registerAdmin1.css">
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
    		<a>管理者アカウント登録</a>
    	</div>
    </div>
</header>
<br>
<br>
<br>
<p style="color:red; text-align: center;font-size: 1.3rem">登録に失敗しました。</p>
<form action="./RegisterAdmin2Servlet" method="post">
	<input type="text"name="email"class="search"autocomplete="off"placeholder="メールアドレス"><br>
	<input type="password"name="pass"class="search"autocomplete="off"placeholder="パスワード　英数10字以上"><br>
	<input type="submit"class="button_a"value="新規登録">
</form>

<a class="button_b"href="" onclick="history.go(-1); return false;">戻る</a>
<%
	}else{
%>
<header>
    <div class="header">
    	<div class="center">
    		<a>管理者アカウント登録</a>
    	</div>
    </div>
</header>
<br>
<br>
<br>
<form action="./RegisterAdmin2Servlet" method="post">
	<input type="text"name="email"class="search"autocomplete="off"placeholder="メールアドレス"><br>
	<input type="password"name="pass"class="search"autocomplete="off"placeholder="パスワード　英数10字以上"><br>
	<input type="submit"class="button_a"value="新規登録">
</form>

<a class="button_b"href="" onclick="history.go(-1); return false;">戻る</a>
<%} %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Laboratory</title>
<link rel="stylesheet"href="css/login.css">
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String errorCode=request.getParameter("error");
	if(errorCode!=null&&errorCode.equals("1")){
%>
<a class="titlelogo">ログイン画面</a>
<div class="loginbox">
	<div class="searchbox">
		<form action="./LoginExcuteServlet" method="post">
			<p style="color:red; text-align: center;font-size: 1.3rem">ログインに失敗しました。</p>
			<a>メールアドレス</a><br>
			<input type="email"name="email"class="search_a"autocomplete="off"><br><br>
			<a>パスワード</a><br>
			<input type="password"name="pass"class="search_b"autocomplete="off"><br><br>
			<a class="button"href="" onclick="history.go(-1); return false;">戻る</a>
			<input type="submit"class="button_s"value="ログイン">
		</form>
		
	</div>
</div>

<a class="button_a"href="./RegisterUser1Servlet">会員IDをお持ちでない方はこちら　　　　　　　▷</a>
<%}else{ %>
<a class="titlelogo">ログイン画面</a>
<div class="loginbox">
	<div class="searchbox">
		<form action="./LoginExcuteServlet" method="post">
			<a>メールアドレス</a><br>
			<input type="email"name="email"class="search_a"autocomplete="off"><br><br>
			<a>パスワード</a><br>
			<input type="password"name="pass"class="search_b"autocomplete="off"><br><br>
			<a class="button"href="" onclick="history.go(-1); return false;">戻る</a>
			<input type="submit"class="button_s"value="ログイン">
		</form>
		
	</div>
</div>

<a class="button_a"href="./RegisterUser1Servlet">会員IDをお持ちでない方はこちら　　　　　　　▷</a>
<%} %>
</body>
</html>
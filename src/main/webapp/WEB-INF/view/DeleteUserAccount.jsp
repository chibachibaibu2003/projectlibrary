<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Laboratory</title>
<link rel="stylesheet"href="css/delete.css">
</head>
<body>

<header>
    <div class="header">
    	<div class="center">
    		<a>アカウント削除画面</a>
    	</div>
    </div>
</header>
<br>
<br>
<br>
<br>
<form action="./DeleteServlet2" method="post">
	<input type="password"name="pass"class="search"autocomplete="off"placeholder="パスワード"><br>
	<input type="submit"class="button_b"value="削除"><br>
</form>
<br>
<a class="button_a"href="./HomeServlet" >戻る</a>

</body>
</html>
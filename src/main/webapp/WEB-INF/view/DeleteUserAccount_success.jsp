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
    		<a>アカウントを削除します。</a>
    	</div>
    </div>
</header>
<a class="text">アカウントの削除を行います。</a><br>
<a class="text">この作業が完了しますと下記のデータが削除されます。</a><br>
<a class="text"style="color:red">・ユーザー情報の全て</a><br>
<a class="text"style="color:red">・投稿した口コミ投稿</a><br>
<a class="text">尚、この作業が完了しますと上記の内容は復元できませんのでご注意下さい</a><br>
<h2>・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・</h2>
<a class="text">ご利用いただきありがとうございました。</a><br>
<a class="text">これより削除処理を行います。本当によろしいですか？</a><br>

<a class="button_a"href="./HomeServlet">やっぱりやめる</a><br>
<a class="button_b"href="./DeleteServlet3">アカウントを削除する</a><br>
</body>
</html>
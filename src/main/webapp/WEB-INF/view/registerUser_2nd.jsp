<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Laboratory</title>
<link rel="stylesheet" href="css/register2.css">
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String email=request.getParameter("email");
%>
<header>
    <div class="header">
    	<div class="center">
    		<a>会員ID新規登録</a>
    	</div>
    </div>
</header>
<div class="checkpoint">
	<img src="img/register3.png"alt="">
</div>
<p>
	<%=email %>へ、本人確認用の<br>
	メールを送信しました。<br>
	メールをご確認いただき、メールに記載されたURLをクリック<br>
	してアカウント登録の次のステップに進んでください。
</p>
<h2>・・・・・・・・・・・・・・・・・・メールが届かない方は・・・・・・・・・・・・・・・・・・・</h2>
<a class="title">受信メールが届かない方はこちらをご覧ください。</a><br><br>
<a class="text">・迷惑メールフォルダに振り分けられていないか。</a><br>
<a class="text">・メールの配信に時間がかかる場合が有ります。数分程度待ったうえで、再度ご確認お願いします。</a><br>
<a class="text">・ご登録にご使用中のメールアドレス<%=email %>が正しいかどうかご確認下さい。</a><br><br>
<div class="loginbutton">
<a class="button_a"href="./RegisterUser2Servlet?email=<%=email %>&button=on">確認メールの再送信はこちら</a>
</div>
</body>
</html>
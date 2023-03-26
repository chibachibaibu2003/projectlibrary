<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page import="dto.reviewList" %>
<%@page import="dto.account" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Laboratory</title>
<link rel="stylesheet" href="css/review.css">
</head>
<body>
<body bgcolor="#F2FDFF">
  <header>
    <div class="header">
    <div class="left"><h1 class="title"><img src="img/aikon.png"alt="" width="70" height="70">Book Laboratory</h1></div>
      <div class="right">
        <form action="./SearchBookServlet"method="get" >
      	<input type="text"style="width: 200px; height: 31px "name="word" class="search" placeholder="本　　検索欄">
    	<input type="submit" class="search_button"style="height:40px" value="検索">
      </form>
      </div>
    <nav class="nav">
      <ul class="menu-group">
      </ul>
    </nav>
  </div>
  </header>
  <div class="box1">
  	<img src="img/aikon.png"alt="" width="70" height="70">
  	<font size="6">
  		<a href="./HomeServlet">ホーム</a>
  		<a href="./SearchServlet">検索</a>
  		<a href="">マイページ</a>
  	</font>
  	<div class="tate">
  		<a class="linebox_c" href="./LogoutServlet">ログアウト</a>
  	</div>
  </div>
<%
	List<reviewList> list=(List<reviewList>)session.getAttribute("ReviewBookInfo");
	int point=(int)session.getAttribute("BookPoint");
	for(reviewList info:list){
%>
	<div class="category">
		<a style="font-size:2.4rem"><%=info.getCategory() %></a>
	</div>
	<div class="bookimg">
		<img src="data:image/png;base64,<%=info.getUrl() %>"width="200" height="274">
	</div>
	<div class="bookinfo">
		<a class="bookname"><%=info.getBookName() %></a><br>
		<a styl="font-size:2rem"class="authorname"><%=info.getAuthorName() %></a><br>
		<a styl="font-size:2rem"class="infotext">評価：<%=point %>.0/5.0</a><br>
	</div>
	<div class="button_a">
		<a class="infobutton"href="">本の詳細へ</a>
	</div>
<%} %>
<%
	account user=(account) session.getAttribute("info");
%>
	<div class="titlebox">
		<div class="leftboxtop">名前</div>
		<div class="leftbox">評価</div>
		<div class="leftbox">口コミタイトル</div>
		<div class="leftboxbottom">口コミ本文</div>
	</div>
	<form action="./ReviewWrite2Servlet"method="post">
		<div class="rightTitlebox">
			<div class="rightboxtop">
				<%=user.getName() %>さん<br>
				口コミを投稿する際に表示されます
			</div>
			<div class="rightbox">
				1<input type="radio"name="option"value="1">　
				2<input type="radio"name="option"value="2">　
				3<input type="radio"name="option"value="3">　
				4<input type="radio"name="option"value="4">　
				5<input type="radio"name="option"value="5">　
			</div>
			<div class="rightbox">
				<input type="text"style="font-size:1.5rem;width: 500px; height: 40px "name="title"class="commenttitle"placeholder="20文字まで(この入力スペースいっぱいです)"> 
			</div>
			<div class="rightboxbottom">
				<textarea rows="10" cols="40"style="font-size:1.5rem"name="comment"></textarea>
			</div>
		</div>
		<div　class="submitbox">
			<input type="submit"value="口コミを送信"class="submitbutton">
		</div>
	</form>
</body>
</html>
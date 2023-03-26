<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="dto.account" %>
<%@page import="dto.book" %>
<%@page import="dto.reviewList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Laboratory</title>
<link rel="stylesheet" href="css/menu2.css">
</head>
<body bgcolor="#F2FDFF">

  <header>
    <div class="header">
    	<div class="left">
    		<h1 class="title">
    		<img src="img/aikon.png"alt="" width="70" height="70">Book Laboratory</h1>
    	</div>
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
  		<a href="">ホーム</a>
  		<a href="./SearchServlet">検索</a>
  		<a href="./MypageServlet">マイページ</a>
  	</font>
  	<div class="tate">
  		<a class="linebox_c" href="./LogoutServlet">ログアウト</a>
  	</div>
  </div>
  
<div class="osusume">
	<font size="7"><p>おすすめの本</p></font>
</div>

<div class="yoko">
<%
	List<book> pointlist=(List<book>)session.getAttribute("HighPoint");
	for(book pointtitle :pointlist){
%>
	<div class="osusume_title_1">
		<font size="5" >
			<p class="booktitle_a"><%=pointtitle.getBook_name() %></p>
		</font>
	</div>
<%} %>
</div>
<div class="osusume_itiran">
<%
	for(book pointimg : pointlist){
%>
	<div class="osusume_book_1">
		<img src="data:image/png;base64,<%=pointimg.getURL()%>" alt="" width="180" height="254">
	</div>
<%} %>
</div>

<h2>・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・</h2>
<div class="osusume">
	<font size="7"><p>今借りている本</p></font>
</div>

<div class="yoko">
<%
	List<reviewList> reviewlist=(List<reviewList>)session.getAttribute("lendNowList");
	int num=0;
	for(reviewList reviewtitle :reviewlist){
	num++;
%>
	<div class="osusume_title_1">
		<font size="5" >
			<p class="booktitle_a"><%=reviewtitle.getBookName() %></p>
		</font>
	</div>
<%} %>
</div>
<div class="osusume_itiran">
<%
	for(reviewList reviewimg : reviewlist){
%>
	<div class="osusume_book_1">
		<img src="data:image/png;base64,<%=reviewimg.getUrl()%>" alt="" width="180" height="254">
	</div>
<%}%>
</div>
</body>
</html>
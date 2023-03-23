<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Laboratory</title>
<link rel="stylesheet" href="css/menu.css">
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
  		<a href="index.jsp">ホーム</a>
  		<a href="./SearchServlet">検索</a>
  		<a href="./LoginServlet">マイページ</a>
  	</font>
  	<div class="tate">
  		<a class="linebox_c" href="./LogoutServlet">ログアウト</a>
  	</div>
  </div>
<div class="osusume">
<font size="7"><p>おすすめの本</p></font>
</div>


    

<div class="dotted_line"> 
<p class=""></p>
</div>
</body>
</html>
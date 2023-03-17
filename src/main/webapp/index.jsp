<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Laboratory</title>
<link rel="stylesheet" href="css/menu.css">
</head>
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
  		<a href="">本一覧</a>
  		<a href="">検索</a>
  		<a href="">マイページ</a>
  	</font>
  	<div class="tate">
  		<a class="linebox_a" href="./RegisterUser1Servlet">新規登録</a>
  		<a class="linebox_b" href="./LoginServlet">ログイン</a>
  	</div>
  </div>
<div class="osusume">
<font size="7"><p>おすすめの本</p></font>
</div>
<div class="yoko">
<div class="osusume_title_1">
<font size="5" ><p>ドラゴンボール</p></font>
</div>
<div class="osusume_title_2">
<font size="5" ><p>ドラゴンボール</p></font>
</div>
<div class="osusume_title_3">
<font size="5" ><p>ドラゴンボール</p></font>
</div>
<div class="osusume_title_4">
<font size="5" ><p>ドラゴンボール</p></font>
</div>
</div>
<div class="osusume_itiran">
<div class="osusume_book_1">
<img src="img/1.jpg" alt="" width="" height="">
</div>
<div class="osusume_book_2">
  <img src="img/1.jpg" alt="" width="" height="">
  </div>
  <div class="osusume_book_3">
    <img src="img/1.jpg" alt="" width="" height="">
    </div>
    <div class="osusume_book_4">
      <img src="img/1.jpg" alt="" width="" height="">
      </div>
    </div>
    <div class="yoko">
      <div class="osusume_book_evaluation_1">
      <font size="5"><p>評価0.0/0.0</p></font>
    </div>
    <div class="osusume_book_evaluation_2">
      <font size="5"><p>評価0.0/0.0</p></font>
    </div>
    <div class="osusume_book_evaluation_3">
      <font size="5"><p>評価0.0/0.0</p></font>
    </div>
    <div class="osusume_book_evaluation_4">
      <font size="5"><p>評価0.0/0.0</p></font>
    </div>
    </div>
    <div>
    <div class="dotted_line"> 
      <p class=""></p>
    </div>
  </div>
    <div class="yoko">
      <div class="osusume_title_1">
      <font size="5" ><p>ドラゴンボール</p></font>
      </div>
      <div class="osusume_title_2">
      <font size="5" ><p>ドラゴンボール</p></font>
      </div>
      <div class="osusume_title_3">
      <font size="5" ><p>ドラゴンボール</p></font>
      </div>
      <div class="osusume_title_4">
      <font size="5" ><p>ドラゴンボール</p></font>
      </div>
      </div>
      <div class="osusume_itiran">
      <div class="osusume_book_1">
      <img src="img/1.jpg" alt="" width="" height="">
      </div>
      <div class="osusume_book_2">
        <img src="img/1.jpg" alt="" width="" height="">
        </div>
        <div class="osusume_book_3">
          <img src="img/1.jpg" alt="" width="" height="">
          </div>
          <div class="osusume_book_4">
            <img src="img/1.jpg" alt="" width="" height="">
            </div>
          </div>
          <div class="yoko">
            <div class="osusume_book_evaluation_1">
            <font size="5"><p>評価0.0/0.0</p></font>
          </div>
          <div class="osusume_book_evaluation_2">
            <font size="5"><p>評価0.0/0.0</p></font>
          </div>
          <div class="osusume_book_evaluation_3">
            <font size="5"><p>評価0.0/0.0</p></font>
          </div>
          <div class="osusume_book_evaluation_4">
            <font size="5"><p>評価0.0/0.0</p></font>
          </div>
          </div>
</body>
</html>
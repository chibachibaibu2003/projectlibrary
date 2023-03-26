<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="css/search_result.css">
</head>
<body bgcolor="#F2FDFF">
  <header>
    <div class="header">
    <div class="left"><h1 class="title"><img src="img/aikon.png"alt="" width="70" height="70">Book Laboratory</h1>
    </div>
      </div>
    <nav class="nav">
      <ul class="menu-group">
      </ul>
    </nav>
  </header>
  <div class="box1">
  <img src="img/aikon.png"alt="" width="70" height="70"><font size="6"><a>ホーム</a><a>検索</a><a>マイページ</a></font>
  <div class="logout">
<a href=""><button class="logout" style="font-size: 25px;">ログアウト</button></a>
</div>
  </div>
 <div class="box2">
 <p class="search_Word" style="font-size: 1.2rem;">検索ワード</p>
 <p class="search_text" style="font-size: 1.2rem;">・ドラゴンボール</p>
 </div>
 <div class="box3">
 <p>検索結果*件ヒット</p>
 <p class="narabi">並び替え:</p>
 <select>
    <option value="">おすすめ順</option>
    <option>出版日(降順)</option>
    <option>出版日(昇順)</option>
</select>
 </div>
 <div class="yoko_narabi">
<div class="book_cover">  
<img src="img/1.jpg">  
 </div>
 <div class="tate_narabi">
 <p class="book_title" style="font-size:3.5rem;">title</p>
 <div class="author">
 <p style="font-size:1.5rem;">作者:</p>
  </div>
  <div class="category">
  <p style="font-size:1.5rem;">カテゴリー:</p>
  </div>
  <div class="publication">
   <p style="font-size:1.5rem;">出版日:</p>
   </div>
   <div class="evaluation">
    <p style="font-size:1.5rem;">評価:</p>
    </div>
    </div>
    <a href="" class="btn btn--orange" >本の詳細ページ</a> 
    </div>
         
  </body>
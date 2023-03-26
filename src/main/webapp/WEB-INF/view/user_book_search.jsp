<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="css/user_book_search.css">
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
  <div class="yoko_narabi">
<div class="category">
<select>
    <option value="">すべてのカテゴリー</option>
    <option>選択肢のサンプル2</option>
    <option>選択肢のサンプル3</option>
    <option>選択肢のサンプル4</option>
    <option>選択肢のサンプル5</option>
    <option>選択肢のサンプル6</option>
    <option>選択肢のサンプル7</option>
</select>
</div>
<form action="SearchResultServlet"method="post">
<div class="right">

    <input class="search" type="search" placeholder="キーワードを入力してください">

   <button class="search_button" href=""><img src="img/2.png" alt="" width="45" height="45"></button>
   
  </div>
  </div>
  </form>
<div style="text-align: center">
<button type="submit"  class="super_search_button" style="font-size: 1.2rem;"  onclick="document.getElementById('divtestbox').style.display='block';">詳しく検索</button>
</div>
<div id="divtestbox"style="display:none" action="user_book_search.jsp"method="get">

<form action="SearchResultServlet2"method="post">
<div class="box2" id="element">
 <div class="yoko_narabi">
<div class="category_2">
<select>
    <option value="">すべてのカテゴリー</option>
    <option>選択肢のサンプル2</option>
    <option>選択肢のサンプル3</option>
    <option>選択肢のサンプル4</option>
    <option>選択肢のサンプル5</option>
    <option>選択肢のサンプル6</option>
    <option>選択肢のサンプル7</option>
</select>
</div>
<div class="tate_narabi">
<div class="tate_narabi">
<div class="book_title_search_text">
<p style="font-size:1.2rem;">本の題名</p>
</div>
 <input class="book_title_search" type="search">
</div>
<div class="tate_narabi">
<div class="book_title_search_text">
<p style="font-size:1.2rem;">本の題名</p>
</div>
 <input class="book_title_search" type="search">
</div>
</div>
<div class="tate_narabi">
<div class="tate_narabi">
<div class="book_title_search_text">
<p style="font-size:1.2rem;">本の題名</p>
</div>
 <input class="book_title_search" type="search">
</div>
<div class="tate_narabi">
<div class="book_title_search_text">
<p style="font-size:1.2rem;">本の題名</p>
</div>
 <input class="book_title_search" type="search">
</div>
</div>
</div>
<button class="s_search_button" style="font-size:1.2rem;" >詳細検索</button>
</div>
</form>
</div>
</body>
</html>
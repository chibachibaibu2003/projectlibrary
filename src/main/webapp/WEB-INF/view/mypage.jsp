<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dto.account" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Laboratory</title>
<link rel="stylesheet" href="css/mypage.css"> 
</head>
<body>
<%
	account info=(account)session.getAttribute("info");
%>
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
<div class="kari">
	<p style="font-size: 1.8rem;">現在借りている本</p>
</div>
<div class="yoko_narabi">
	<div class="ures_name_ID">
    	<p style="font-size: 1.8rem;margin-right:-250px"><%=info.getName() %></p>
    	<p style="font-size: 1.8rem;margin-right:-250px"><%=info.getMail() %></p>
    </div>
	<div class="yoko_narabi">
		<div class="kariteru_book_1">
			<img src="img/1.jpg" alt="" width="120" height="163">
		</div>
		<div class="kariteru_book_2">
			<img src="img/1.jpg" alt="" width="120" height="163">
		</div>
		<div class="kariteru_book_3">
			<img src="img/1.jpg" alt="" width="120" height="163">
		</div>
		<div class="kariteru_book_4">
			<img src="img/1.jpg" alt="" width="120" height="163">
		</div>
		<div class="kariteru_book_5">
			<img src="img/1.jpg" alt="" width="120" height="163">
		</div>
	</div>
</div>
<p></p>       
<div class="dotted_line"></div>

<div class="kutikomi">
<P style="font-size: 2rem;">貴方の口コミ</P>
</div>
<div style="overflow: auto;" class="kutikomi_itiran_box1">
        <table style="border-collapse: collapse; border-spacing: 80px;" align="left">
        <tr>
        <td class="kutikomi_img">
            <img src="img/1.jpg" alt="">
        </td>
        </tr>
       
      </table>
      <table style="border-collapse: collapse; border-spacing: 80px;" class="kutikomi_text">
        <tr class="border">
            <td class="max-width" valign="top">
    <P style="font-size: 2rem;" class="book_title">本のタイトル</P>
    <p style="font-size: 1.2rem;" class="book_kutikomi_text">ああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああ</p>
            </td>
            </tr>
      </table>
      <table style="border-collapse: collapse; border-spacing: 80px;" align="left">
        <tr>
        <td class="kutikomi_img">
            <img src="img/1.jpg" alt="">
        </td>
        </tr>
       
      </table>
      <table style="border-collapse: collapse; border-spacing: 80px;" class="kutikomi_text">
        <tr class="border">
            <td class="max-width" valign="top">
    <P style="font-size: 2rem;" class="book_title">本のタイトル</P>
    <p style="font-size: 1.2rem;" class="book_kutikomi_text">ああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああ</p>
            </td>
            </tr>
      </table>
    </div>
</div>
</div>
</body>
</html>
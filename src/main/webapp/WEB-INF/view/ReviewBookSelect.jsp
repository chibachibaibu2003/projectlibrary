<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page import="dto.book" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Laboratory</title>
<link rel="stylesheet" href="css/mypage.css"
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
  		<a href="./MypageServlet">マイページ</a>
  	</font>
  	<div class="tate">
  		<a class="linebox_c" href="./LogoutServlet">ログアウト</a>
  	</div>
  </div>
<div class="kutikomi">
<p style="font-size: 2rem;">口コミ投稿可能な本</p>
</div>
<div style="overflow: auto;" class="kutikomi_itiran_box1">
<%
	List<book> booklist=(List<book>)session.getAttribute("CanReviewList");
	for(book bo : booklist){
%>
        <table style="border-collapse: collapse; border-spacing: 80px;" align="left">
        	<tr>
        		<td class="kutikomi_img">
            		<img src="data:image/png;base64,<%=bo.getURL() %>" alt=""width="180" height="254">
        		</td>
        	</tr>
      	</table>
      <table style="border-collapse: collapse; border-spacing: 80px;" class="kutikomi_text">
        <tr class="border">
            <td class="max-width" valign="top">
   				<a style="font-size: 2.5rem;" class="book_title"><%=bo.getBook_name() %></a><br>
   				<a style="font-size: 3rem;" class="book_kutikomi_text2" href="./ReviewWriteServlet?isbn=<%=bo.getIsbn()%>">
   				この本の口コミを書く
   				</a>
            </td>
         </tr>
      </table>
<%} %>
</div>
</body>
</html>
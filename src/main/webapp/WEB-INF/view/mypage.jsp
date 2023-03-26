<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page import="dto.account" %>
<%@page import="dto.reviewList" %>
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
    	<p style="font-size: 1.8rem;margin-right:150px"><%=info.getName() %></p>
    	<p style="font-size: 1.8rem;margin-right:150px"><%=info.getMail() %></p>
    </div>
    <div class="yoko_narabi">
<%
	List<String> lendlist = (List<String>) session.getAttribute("lendNow");
	for(String lend:lendlist){
%>
			<img src="data:image/png;base64,<%=lend %>" alt=""width="120" height="163" style="margin:0" >
<%} %>
	</div>
</div>
  
<h2>・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・・</h2>


<div class="kutikomi">
<p style="font-size: 2rem;">貴方の口コミ</p>
</div>
<div style="overflow: auto;" class="kutikomi_itiran_box1">
<%
	List<reviewList> reviewlist=(List<reviewList>)session.getAttribute("reviewList");
	for(reviewList review : reviewlist){
%>
        <table style="border-collapse: collapse; border-spacing: 80px;" align="left">
        	<tr>
        		<td class="kutikomi_img">
            		<img src="data:image/png;base64,<%=review.getUrl() %>" alt=""width="180" height="254">
        		</td>
        	</tr>
      	</table>
      <table style="border-collapse: collapse; border-spacing: 80px;" class="kutikomi_text">
        <tr class="border">
            <td class="max-width" valign="top"style="">
   				<p style="font-size: 2rem;" class="book_title"><%=review.getBookName() %></p>
     			<p style="font-size: 1.2rem;" class="book_kutikomi_text"><%=review.getComment()%></p>
            </td>
         </tr>
      </table>
<%} %>
<div style="display:flex; justify-content:center;">
	<a class="reviewbutton"href="./reviewServlet">口コミを書く</a>
</div>

</div>
<div style="display:flex; justify-content:center;">
	<a class="deletebutton"href="./DeleteServlet">アカウントの削除</a>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.account" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Laboratory</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8");
   account ac = (account)session.getAttribute("account");
%>

<p><%=ac.getMail() %>さん</p>
</body>
</html>
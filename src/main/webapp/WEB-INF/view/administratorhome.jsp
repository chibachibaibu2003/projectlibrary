<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin home</title>
<link rel="stylesheet" href="css/adminhome.css">
</head>
<body>
<h1>管理者ホーム</h1>
    <div class="content">
        <div class="inner">
        <a href="LendBookServlet" class="button1">図書貸出</a>
        <a href="ReturnBookServlet" class="button1">図書返却</a>
        </div>
    </div> 
    
    <div class="content2">
        <div class="inner2">
        <a href="RegisterBookServlet" class="button">新規図書登録</a>
        <a href="DeleteServlet" class="button">図書削除</a>
        <a href="SearchServlet" class="button">図書検索</a>
        </div>
    </div>    

    <div class="content2">
        <div class="inner2">
            <a href="RegisterAdminServlet" class="button">アカウント登録</a>
            <a href="DeleteAccountServlet" class="button">アカウント削除</a>
            <a href="AccountSearchServlet" class="button">アカウント情報検索</a>
        </div>
    </div>    

    <div class="content2">
        <div class="inner2">
        <a href="AddCategoryServlet" class="button">カテゴリーの追加</a>
        <a href="LogoutServlet" class="button">ログアウト</a>
        <a href="#" class="button" style="background-color: transparent;"></a>
        </div>
    </div>    
</body>
</html>
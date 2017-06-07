<%-- 
    Document   : top
    Created on : 2017/05/29, 14:57:44
    Author     : K.Yamazaki
--%>

<!--トップ画面を表示させるJSP-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>課題：Java/DB操作/エラーハンドリング/在庫管理システムの作成</title>
    </head>
    <body>
        <h3>トップページ</h3>
        
<!--        SQLのテーブル情報を取得し、商品一覧ページ(productList)へ遷移させる-->
    <a href="http://localhost:8080/dbOperation13_controlStock/TopToProductList">
        商品一覧
    </a><br>
    
<!--        SQLのテーブル情報を取得し、商品追加ページ(addProduct)へ遷移させる-->
    <a href="http://localhost:8080/dbOperation13_controlStock/TopToAddProduct">
        商品追加
    </a><br>
    <br>
    
<!--    ログアウトボタン-->
    <form action="Logout" method="post">
        <input type="submit" name="btnSubmit" value="ログアウト"/><br>
    </form>

    </body>
</html>

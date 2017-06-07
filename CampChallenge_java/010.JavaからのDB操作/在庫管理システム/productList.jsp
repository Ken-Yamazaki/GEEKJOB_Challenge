<%-- 
    Document   : productList5
    Created on : 2017/05/29, 14:22:35
    Author     : K.Yamazaki
--%>

<!--MySQLテーブルの商品情報一覧を表示させるjsp-->
<%@page import="java.util.ArrayList"%>
<%@page import="javabeans.ProductList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="servlet.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            //リクエストスコープから商品情報を取得する
            ProductList list = (ProductList)request.getAttribute("list");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>課題：Java/DB操作/エラーハンドリング/在庫管理システムの作成</title>
    </head>
    <body>
        <h3>商品一覧ページ</h3>
        <%
            //JavaBeansのゲッターで、リクエストスコープに登録してある商品情報を取得し、表示する
            ArrayList<String> pName = list.getPName();
            ArrayList<Integer> price = list.getPrice();
            for(int i=0; i<pName.size(); i++){
                out.println("-----------------------------<br>");
                out.println("商品名：" + pName.get(i) + "<br>");
                out.println("価格：" + price.get(i) + "円<br>");
                }
            out.println("-----------------------------");
        %>
        
        <br><br>
        <!--    ログアウトボタン-->
    <form action="Logout" method="post">
        <input type="submit" name="btnSubmit" value="ログアウト"/><br>
    </form>
    </body>
</html>

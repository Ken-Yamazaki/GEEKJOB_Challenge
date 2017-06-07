<%-- 
    Document   : reAddProduct
    Created on : 2017/06/06, 15:08:07
    Author     : K.Yamazaki
--%>

<!--MySQLのテーブルに商品を追加させるjsp（2回目以降）-->
<%@page import="java.util.ArrayList"%>
<%@page import="javabeans.ProductList"%>
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
        
        <form action="AddProduct" method="post">
            <h3>商品追加ページ</h3>
            <font color="red">商品が追加されました。</font><br>
            <br>
            商品名と価格を入力してください。<br>
            <br>
            商品名　<input type="text" name="pName" value=""><br>
            価格　　<input type="number" name="price" value=""><br>
            <br>
            <input type="submit" name="btnSubmit" value="追加"><br>
            <br><br>
            登録済みの商品<br>
            <%
                //JavaBeansのゲッターで、リクエストスコープに登録してある
                //商品情報を取得し、表示する
                ArrayList<Integer> id = list.getId();
                ArrayList<String> pName = list.getPName();
                ArrayList<Integer> price = list.getPrice();
                System.out.println("テスト1");
                System.out.println(price.size());
                for(int i=0; i<id.size(); i++) {
                    out.println("-----------------------------<br>");
                    if(i == id.size()-1) {
                        out.println("<font color=red>当商品が追加されました。</font><br>");
                    }
                    out.println("ID：" + id.get(i) + "<br>");
                    out.println("商品名：" + pName.get(i) + "<br>");
                    out.println("価格：" + price.get(i) + "円<br>");
                }
                out.println("-----------------------------");
            %>
        </form>
        
        <br><br>
        <!--        トップ(top.jsp)へ戻る-->
    <a href="http://localhost:8080/dbOperation13_controlStock/top.jsp">
        トップページへ戻る
    </a>
        
        <!--    ログアウトボタン-->
    <form action="Logout" method="post">
        <input type="submit" name="btnSubmit" value="ログアウト"/><br>
    </form>
        
    </body>
</html>

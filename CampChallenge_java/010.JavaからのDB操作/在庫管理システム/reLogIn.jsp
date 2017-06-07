<%-- 
    Document   : reLogIn
    Created on : 2017/05/31, 14:53:41
    Author     : K.Yamazaki
--%>

<!--一度、ID・パスワード入力ミスをして以降のログイン画面を表示させるJSP-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>課題：Java/DB操作/エラーハンドリング/在庫管理システムの作成</title>
    </head>
    <body>
        <form action="ForwardTopServlet" method="post">
            <h3>ログイン画面</h3>
            <br>
            <font color="red">ユーザーIDまたはパスワードが違います。</font><br>
            ユーザーIDとパスワードを入力してください。<br>
            <br>
            ユーザーID　<input type="text" name="id" value="" /><br>
            パスワード　<input type="password" name="pass" value="" /><br>
            <br>
            <input type="submit" name="btnSubmit" value="ログイン"/><br>
        </form>
    </body>
</html>

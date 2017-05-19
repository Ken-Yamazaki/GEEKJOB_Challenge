<%-- 
    Document   : dataOperation_session
    Created on : 2017/05/19, 13:00:28
    Author     : K.Yamazaki
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>課題：Java/データ操作/セッション/セッションの作成</title>
    </head>
    <body>
        
<%
    //を記録する
    HttpSession hs = request.getSession();      //セッションを作成
    long ct = session.getLastAccessedTime();    //最終アクセス日時を取得①
    Date date = new Date(ct);                   //最終アクセス日時を取得②
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String d = sdf.format(date);                //Date型を文字列に変換
    
    //セッション作成日時を表示する
    out.println("最終アクセス日時：" + d);
%>

    </body>
</html>

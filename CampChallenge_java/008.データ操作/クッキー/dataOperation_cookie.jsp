<%-- 
    Document   : cookie
    Created on : 2017/05/19, 11:09:43
    Author     : K.Yamazaki
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>課題：Java/データ操作/クッキー/クッキーの記録と表示</title>
    </head>
    <body>
        
<%
    //現在時刻を記録する
    Date d = new Date();                        //現在時刻を取得
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String date = sdf.format(d);                //Date型を文字列に変換
    Cookie c = new Cookie("LastLogin", date);    //"現在時刻"という名前で現在時刻を登録
    response.addCookie(c);      //cookieに反映
    
    //前回記録した日時を表示する
    Cookie[] cs = request.getCookies();
    for(int i=0; i<cs.length; i++) {
        if(cs[i].getName().equals("LastLogin")) {
            out.print("前回のアクセス日時は" + cs[i].getValue());
            break;
        }
    }

%>
        
    </body>
</html>

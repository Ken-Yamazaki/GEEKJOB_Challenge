<%-- 
    Document   : programing-basic2-7_配列の作成
    Created on : 2017/05/01, 13:43:55
    Author     : K.Yamazaki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    //配列を定義
    String[] val = new String[7];
    
    //配列の中身を初期化
    val[0] = "10";
    val[1] = "100";
    val[2] = "soeda";
    val[3] = "hayashi";
    val[4] = "-20";
    val[5] = "118";
    val[6] = "END";
    
    //各配列の要素を出力
    for(String s:val) {
        out.print(s + ",");
    }

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
    </body>
</html>

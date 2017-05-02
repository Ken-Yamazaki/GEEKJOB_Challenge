<%-- 
    Document   : FortuneTellingResult
    Created on : 2017/05/02, 14:20:40
    Author     : K.Yamazaki
--%>

<%//JavaBeansをimportする%>
<%@page import="org.camp.servlet.ResultData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%//ResultData型の変数dataを用意する
          //リクエストスコープから運勢データを取り出す
          //dataに運勢データを代入する
        %>
        <%
            ResultData data = (ResultData)request.getAttribute("DATA");
            
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(data != null) {
                out.print("<h1>あなたの" + data.getD() + "の運勢は、" + data.getLuck() + "です！</h1>");
            }
        %>
    </body>
</html>

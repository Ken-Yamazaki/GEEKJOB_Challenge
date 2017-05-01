<%-- 
    Document   : programing-basic2-3_for文1
    Created on : 2017/05/01, 11:38:58
    Author     : K.Yamazaki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int v = 8;
    int sum = 1;
    for(int i = 1; i<=8; i++) {
        sum = sum * v;
    }
    out.print(sum);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    </body>
</html>

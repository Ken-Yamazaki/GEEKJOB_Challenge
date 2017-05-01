<%-- 
    Document   : programing-basic2-6_while文
    Created on : 2017/05/01, 13:27:59
    Author     : K.Yamazaki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int val = 1000;
    while(val >= 100) {
        out.print(val + ",");
        val = val / 2;
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

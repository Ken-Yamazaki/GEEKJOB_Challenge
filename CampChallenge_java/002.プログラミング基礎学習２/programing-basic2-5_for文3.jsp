<%-- 
    Document   : programing-basic2-5_for文3
    Created on : 2017/05/01, 13:20:14
    Author     : K.Yamazaki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int sum = 0;
    for(int i = 1; i<=100; i++) {
        sum = sum + i;
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

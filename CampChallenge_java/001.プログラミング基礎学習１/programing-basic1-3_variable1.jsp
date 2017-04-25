<%-- 
    Document   : programing-basic1-3_variable1
    Created on : 2017/04/25, 20:22:15
    Author     : K.Yamazaki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String s1 = "こんにちは";
    String s2 = "山崎です";
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            out.println(s1);
            out.println(s2);
        %>
    </body>
</html>

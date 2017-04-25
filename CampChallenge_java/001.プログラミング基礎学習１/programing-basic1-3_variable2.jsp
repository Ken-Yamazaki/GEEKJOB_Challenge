<%-- 
    Document   : programing-basic1-3_variable2
    Created on : 2017/04/25, 20:38:58
    Author     : K.Yamazaki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int a = 6;
    final int b = 2;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            out.println(a + b);
            out.println(a - b);
            out.println(a * b);
            out.println(a / b);
            a = a - 2;
            out.println(a + b);
            out.println(a - b);
            out.println(a * b);
            out.println(a / b);
        %>
    </body>
</html>

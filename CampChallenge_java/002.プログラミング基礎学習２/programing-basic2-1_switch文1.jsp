<%-- 
    Document   : programing-basic2-1_switch文1
    Created on : 2017/05/01, 11:08:08
    Author     : K.Yamazaki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int a = 3;
    String str = "";
    switch(a) {
        case 1:
            str = "one";
            break;
        case 2:
            str = "two";
            break;
        default:
            str = "想定外です";
            break;
    
    }
    out.print(str);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    </body>
</html>

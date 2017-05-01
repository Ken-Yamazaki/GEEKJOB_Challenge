<%-- 
    Document   : programing-basic2-1_switch文2
    Created on : 2017/05/01, 11:20:31
    Author     : K.Yamazaki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    char key = '1';
    String message = "";
    
    switch(key) {
        case 'A':
            message = "英語";
            break;
        case 'あ':
            message = "日本語";
            break;
        default:     
    }
    out.print(message);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    </body>
</html>

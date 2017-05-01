<%-- 
    Document   : programing-basic2-4_for文2
    Created on : 2017/05/01, 13:09:51
    Author     : K.Yamazaki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String v = "A";
    String vJoined = "";
    for(int i = 1; i<=30; i++) {
        vJoined = vJoined + v + "[" + i + "]";
    }
    out.print(vJoined);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    </body>
</html>

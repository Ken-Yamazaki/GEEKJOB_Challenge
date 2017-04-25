<%-- 
    Document   : programing-basic1_disp-str-combined
    Created on : 2017/04/25, 19:57:41
    Author     : K.Yamazaki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String s1 = "groove";
    String s2 = "-";
    String s3 = "gear";
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%=s1 + s2 + s3%>
    </body>
</html>

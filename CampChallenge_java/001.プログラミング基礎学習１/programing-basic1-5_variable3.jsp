<%-- 
    Document   : programing-basic1-5_variable3
    Created on : 2017/04/25, 21:13:55
    Author     : K.Yamazaki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int a = 1;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(a == 1) {
                out.println("1です！");                
            } else if (a == 2) {
                out.println("プログラミングキャンプ！");
            } else {
                out.println("その他です！");
            }
        %>
    </body>
</html>

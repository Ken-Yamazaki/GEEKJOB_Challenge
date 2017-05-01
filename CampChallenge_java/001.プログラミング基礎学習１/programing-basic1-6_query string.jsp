<%-- 
    Document   : programing-basic1-6_query string
    Created on : 2017/04/25, 21:41:00
    Author     : K.Yamazaki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    //商品種別3種類
    String product1 ="雑貨";
    String product2 ="生鮮食品";
    String product3 ="その他";
    
    //商品種別ごとの総額をクエリストリングで取得
    String sum1 = request.getParameter("sum1");
    String sum2 = request.getParameter("sum2");
    String sum3 = request.getParameter("sum3");
    int s1 = Integer.parseInt(sum1);
    int s2 = Integer.parseInt(sum2);
    int s3 = Integer.parseInt(sum3);
    
    //購入個数をクエリストリングで取得
    String num1 = request.getParameter("num1");
    String num2 = request.getParameter("num2");
    String num3 = request.getParameter("num3");
    int n1 = Integer.parseInt(num1);
    int n2 = Integer.parseInt(num2);
    int n3 = Integer.parseInt(num3);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            //雑貨
            out.println("１：" + product1);
            out.println(s1 / n1 + "円");
        %> <br>
        <%
            //生鮮食品
            out.println("２：" + product2);
            out.println(s2 / n2 + "円");
        %> <br>
        <%
            //その他
            out.println("３：" + product3);
            out.println(s3 / n3 + "円");
        %>
        <br>
        <%
            if (s1+s2+s3 >= 3000) {
                if (s1+s2+s3 >= 5000) {
                    out.println("5000円以上購入されたため、5%のポイントが付きます");
                } else {
                    out.println("3000円以上購入されたため、4%のポイントが付きます");
                }
            } else {
                
            }
        %>
        
    </body>
</html>

<%-- 
    Document   : programing-basic1-6_query string
    Created on : 2017/04/25, 21:41:00
    Author     : K.Yamazaki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    //商品種別3種類
    String comm1 ="雑貨";
    String comm2 ="生鮮食品";
    String comm3 ="その他";
    
    //商品種別ごとの総額・そのときの個数
    int sum1 = 1000;
    int sum2 = 800;
    int sum3 = 1200;
    int num1 = 2;
    int num2 = 3;
    int num3 = 4;
    
    //購入価格
    int buy = 3000;

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            //雑貨
            out.println("１：" + comm1);
            out.println(sum1 / num1 + "円");
        %> <br>
        <%
            //生鮮食品
            out.println("２：" + comm2);
            out.println(sum2 / num2 + "円");
        %> <br>
        <%
            //その他
            out.println("３：" + comm3);
            out.println(sum3 / num3 + "円");
        %>
        <br>
        <%
            if (buy >= 3000) {
                if (buy > 5000) {
                    out.println("5000円以上購入されたため、5%のポイントが付きます");
                } else {
                    out.println("3000円以上購入されたため、4%のポイントが付きます");
                }
            }
        %>
        
    </body>
</html>

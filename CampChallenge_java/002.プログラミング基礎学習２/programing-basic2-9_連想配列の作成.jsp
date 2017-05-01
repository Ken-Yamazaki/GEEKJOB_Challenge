<%-- 
    Document   : programing-basic2-9_連想配列の作成
    Created on : 2017/05/01, 15:44:24
    Author     : K.Yamazaki
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HashMap<String, String>hMap = new HashMap<String, String>();
    
    hMap.put("1", "AAA");
    hMap.put("hello", "world");
    hMap.put("soeda", "33");
    hMap.put("20", "20");
    
    hMap.get("1");
    hMap.get("hello");
    hMap.get("soeda");
    hMap.get("20");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<%
        out.print("Keyを表示します。");
        for(Map.Entry<String, String> val:hMap.entrySet()) {
            out.print(val.getKey() + ",");
        }
%>        
        <br>
<%
        out.print("Valueを表示します。");
        for(Map.Entry<String, String> val:hMap.entrySet()) {
            out.print(val.getValue() + ",");
        }
%>
    </body>
</html>

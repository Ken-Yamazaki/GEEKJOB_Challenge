<%-- 
    Document   : programing-basic2-10_クエリストリング（簡易素因数分解）
    Created on : 2017/05/01, 16:31:01
    Author     : K.Yamazaki
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    //入力する数値をクエリストリングで取得
    //baseFは素因数分解する対象の数値
    String bF = request.getParameter("bF");
    int F = Integer.parseInt(bF);
    
    try{
        Integer.parseInt(bF);
    } catch(NumberFormatException e) {
        out.println("入力された文字列を整数に変換できませんでした");
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>課題：Java/データ操作/クエリストリング/クエリストリング（簡易素因数分解）</title>
    </head>
    <body>
<%
    out.println("入力された数値は" + F + "<br>");
    //1ケタの素因数を用意
    ArrayList<Integer> a = new ArrayList<Integer>();
    a.add(2);
    a.add(3);
    a.add(5);
    a.add(7);
    int i = 0;
    
    //素因数分解を実行する
    out.println("1ケタの素因数");
    while(F/a.get(i) != 1) {        //それ以上割り切れなくなるまで繰り返す
        if(F%a.get(i) == 0) {       //Fをiで割り切れる数のとき、中の処理に進む
            out.println(a.get(i) + "×");
            F = F/a.get(i);
        } else {                    //2で割り切れないときは3で、3で割り切れないときは…
            i++;
            if(i ==4 ) {
                break;
            }
        }
    }
    if(F < 10) {
        out.println(F);
    } else if(F > 10) {
        out.println(1);
    }

    if(F > 10) {                        //1ケタの素数で割り切れなかったとき
        out.println("<br>余った値(2ケタの素数は)" + F);
    }
    /*
2ケタ以上の素数が含まれた数値の場合は、
「元の値　1ケタの素因数　余った値」と表記してください。
    */


%>
    <br>
    </body>
</html>

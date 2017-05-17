/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dataOperation.getInput;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 課題：Java/データ操作/入力内容の取得/HTMLのタグについて
 * 整数をユーザーに入力させ、その計算結果を表示する
 * @author K.Yamazaki
 */
public class TagServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String title = "課題：Java/データ操作/入力内容の取得/HTMLのタグについて";
        try (PrintWriter out = response.getWriter()) {
            
            request.setCharacterEncoding("UTF-8");  //日本語が含まれるパラメータを処理する方法
            
            //HTMLからの情報を取得する
            //入力有無のチェックのために、一度String型の変数で受け取る
            String strIn1 = request.getParameter("in1");
            String strIn2 = request.getParameter("in2");
            String strAns1 = request.getParameter("ans1");
            String strAns2 = request.getParameter("ans2");
//            String strAns3 = request.getParameter("ans3");
//            String strAns4 = request.getParameter("ans4");
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>" + title + "</title>");            
            out.println("</head>");
            out.println("<body>");
            
            try{    //未入力項目があった場合、そのほか型変換ができない場合に再入力させる
                //HTMLから受け取ったString型の変数を整数型または小数型へ変換
                int in1 = Integer.parseInt(strIn1);
                int in2 = Integer.parseInt(request.getParameter("in2"));
                int ans1 = Integer.parseInt(strAns1);
                int ans2 = Integer.parseInt(strAns2);
//                int ans3 = Integer.parseInt(strAns3);
//                double ans4 = Integer.parseInt(strAns4);
                
                //HTMLから取得した情報を表示する
                out.println("入力された数値は【値1：" + in1 +"】と【値2：" + in2 + "】です<br>");
                out.println("計算結果は次の通りです<br>");
                out.println("値1＋値2：" + in1 + "＋" + in2 + " = " + (in1 + in2) + "<br>");
                out.println("値1－値2：" + in1 + "－" + in2 + " = " + (in1 - in2) + "<br>");
//                out.println("値1×値2：" + in1 + "×" + in2 + " = " + (in1 * in2) + "<br>");
//                //除算の結果は、小数を含むかどうかチェックしてから表示する
//                if((in1/in2) - Math.floor(in1/in2) != 0) {          //ans4(除算の結果)が小数のときは、小数(double)のまま表示する
//                    out.println("値1÷値2：" + in1 + "÷" + in2 + " = " + (double)(in1 / in2) + "<br>");
//                } else {                                            //ans4(除算の結果)が整数のときは、整数へ型変換してから表示する
//                    int intAns4 = (int)ans4;
//                    out.println(intAns4);
//                }

                //HTMLファイルから取得した計算予測結果を表示する
                out.println("<br>予測した結果は次の通りです<br>");
                out.println("値1＋値2：" + ans1+ "<br>");
                out.println("値1－値2：" + ans2+ "<br>");
//                out.println("値1×値2：" + ans3+ "<br>");
                //小数を含むかどうかチェックしてから表示する
//                if(ans4 - Math.floor(ans4) != 0) {          //ans4が小数のときは、小数(double)のまま表示する
//                    out.println("値1÷値2：" + ans4 + "<br>");
//                } else {                                    //ans4が整数のときは、整数へ型変換
//                    int intAns4 = (int)ans4;
//                    out.println("値1÷値2：" + intAns4 + "<br>");
//                }
            } catch(NullPointerException e){
                out.println("未入力項目があります");
                out.println("前ページに戻って再入力してください");
            }
            
            out.println("</body>");
        out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

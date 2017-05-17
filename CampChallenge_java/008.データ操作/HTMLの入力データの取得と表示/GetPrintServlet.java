/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dataOperation.getInput;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 課題：Java/データ操作/入力内容の取得/HTMLの入力データの取得と表示
 * @author K.Yamazaki
 */
@WebServlet(name = "GetPrintServlet", urlPatterns = {"/GetPrintServlet"})
public class GetPrintServlet extends HttpServlet {

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
        String title = "課題：Java/データ操作/入力内容の取得/HTMLの入力データの取得と表示";
        
        try (PrintWriter out = response.getWriter()) {
            
            request.setCharacterEncoding("UTF-8");      //日本語が含まれるパラメータを処理する方法
                                                        //参考URL⇒https://www.javadrive.jp/servlet/request/index4.html
                                                        //リクエストボディに含まれるデータの文字コードを指定した値に書き換えるメソッド（リクエストボディは↓URLを参照）
                                                        //参考URL⇒http://itdoc.hitachi.co.jp/manuals/link/cosmi_v0950/03Y4230D/EY420105.HTM
            String n = request.getParameter("txtName");     //名前テキストボックスへの入力内容を取得
            String s = request.getParameter("rdSex");       //性別ラジオボタンの選択内容を取得
            String h = request.getParameter("txtHobby");    //趣味テキストボックスへの入力内容を取得
        
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>" + title + "</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("名前：" + n);
            out.println("性別：" + s);
            out.println("趣味：" + h);
            
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

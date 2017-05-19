/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dataOperation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 課題：Java/データ操作/セッション/入力フィールドの作成と実装
 * @author K.Yamazaki
 */
public class Session_IinputField extends HttpServlet {

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
        
        String title = "課題：Java/データ操作/セッション/入力フィールドの作成と実装";
        try (PrintWriter out = response.getWriter()) {
            
            //HTMLファイルから、ユーザー入力のデータを受け取る
            request.setCharacterEncoding("UTF-8");
            String n = request.getParameter("txtName");     //名前テキストボックスへの入力内容を取得
            String s = request.getParameter("rdSex");       //性別ラジオボタンの選択内容を取得
            String h = request.getParameter("txtHobby");    //趣味テキストボックスへの入力内容を取得
            
            //セッションを作成し、HTMLファイルから送られた、ユーザー入力情報をセッションへ登録
            HttpSession hs = request.getSession();
            hs.setAttribute("name", n);
            hs.setAttribute("sex", s);
            hs.setAttribute("hobby", h);
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>" + title + "</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<form action=\"Session_IinputField\" method=\"post\">");
            out.println("名前　<input type=text name=txtName value=" + hs.getAttribute("name") + ">");
            out.println("<br><br>");
            out.println("性別<br>");
            if(hs.getAttribute("sex").equals("man")) {
                out.println("男性<input type=\"radio\" name=\"rdSex\" value=\"man\" checked>");
                out.println("女性<input type=\"radio\" name=\"rdSex\" value=\"woman\">");
            } else {
                out.println("男性<input type=\"radio\" name=\"rdSex\" value=\"man\">");
                out.println("女性<input type=\"radio\" name=\"rdSex\" value=\"woman\" checked>");
            }
            out.println("<br><br>");
            out.println("趣味");
            out.println("<textarea name=\"txtHobby\">" + hs.getAttribute("hobby") + "</textarea>");
            out.println("<br><br>");
            out.println("<input type=\"submit\" name=\"btnSubmit\" value=\"送信する\">");
            out.println();
            out.println();
            
            
            
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

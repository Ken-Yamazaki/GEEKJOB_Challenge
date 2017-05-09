/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 課題：引数、戻り値1／メソッド／Java
 */

/**
 *
 * @author K.Yamazaki
 */
@WebServlet(name = "ParamReturn1", urlPatterns = {"/ParamReturn1"})
public class ParamReturn1 extends HttpServlet {

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
        
        //webページのタイトルを設定
        String title = "引数、戻り値1／メソッド／Java";
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>" + title + "</title>");
            out.println("</head>");
            out.println("<body>");
            
            //引数としてIDを渡し、戻り値を表示させる
            HashMap<String, String> profile = new HashMap<String, String>();
            profile = getProfile(3);
            out.println("名前：" + profile.get("name") + "<br>");
            out.println("生年月日：" + profile.get("birthday") + "<br>");
            out.println("住所：" + profile.get("location") + "<br>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * IDを受け取ってプロフィールを返すメソッド
     * @param ID
     * @return 
     */
    HashMap<String, String> getProfile(int ID) {
        HashMap<String, String> profile = new HashMap<String, String>();
        
        switch(ID) {
            case 1:
                profile.put("name", "山崎");
                profile.put("birthday", "1988年8月13日");
                profile.put("location", "東京都");
                break;
            case 2:
                profile.put("name", "ヤマザキ");
                profile.put("birthday", "S63年8月13日");
                profile.put("location", "山梨県");
                break;
            case 3:
                profile.put("name", "やまざき");
                profile.put("birthday", "1988/8/13");
                profile.put("location", "神奈川県");
                break;
        }        
        
        return profile;
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

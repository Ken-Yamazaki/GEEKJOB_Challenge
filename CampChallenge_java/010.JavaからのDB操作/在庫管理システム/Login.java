/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * 課題：Java/DB操作/エラーハンドリング/在庫管理システムの作成
 * 　ログインページの入力内容（IDとパスワード）を判別して、
 * 　正しければトップページへ、正しくなければ再ログインページへ
 * 　遷移させるサーブレットクラス
 * @author K.Yamazaki
 */
public class Login extends HttpServlet {
    
    //DB接続・操作用のフィールドを用意
    static public Connection db_con = null;
    static public PreparedStatement db_st = null;
    static public ResultSet db_data = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            //DBへ接続
            //ユーザー名【KenYamazaki】でログイン
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/Challenge_db";
            db_con = DriverManager.getConnection(url, "KenYamazaki", "irodori2");
            
            //フォーム（logIn.jsp）の入力内容を受け取る
            request.setCharacterEncoding("UTF-8");
            String id = request.getParameter("id");
            String pass = request.getParameter("pass");
            
            //MySQLのdb13_userテーブルからIDとpassを取得する
            String sqlSe = "SELECT ID,pass FROM db13_user";
            db_st = db_con.prepareStatement(sqlSe);
            db_data = db_st.executeQuery();
            
            /*フォームから受け取ったユーザーIDとパスワードを判別する。
            　両者が正しければトップページである「top.jsp」へ、
            　一つでも間違っていれば、再入力用のログインページ「reLogIn.jsp」へ遷移する。
            */
            ArrayList<String> idSelect = new ArrayList<>();            
            ArrayList<String> passSelect = new ArrayList<>();
            int i = 0;
            while (db_data.next()) {
                idSelect.add(db_data.getString("ID"));
                passSelect.add(db_data.getString("pass"));
                //フォームの入力内容とSQLのdb13_userテーブルの情報(ID,pass)を比較し、
                //IDとpassの両者が一致したとき、トップページ（top.jsp）へ遷移する
                if(id.equals(idSelect.get(i)) && pass.equals(passSelect.get(i))) {
                    RequestDispatcher rd = request.getRequestDispatcher(Path.path.top.pathName());
                    rd.forward(request, response);
                    //セッションを開始する。
                    HttpSession session = request.getSession(true);
                    //入力フォームから受け取ったIDとパスワードをセッションへ登録する
                    session.setAttribute("ID", id);
                    session.setAttribute("pass", pass);
                }
                i++;
            }
            
            //フォームの入力内容とSQLのdb13_userテーブルの情報(ID,pass)を比較し、
            //IDとpass両者が一致しなかった場合、再ログインページへ遷移する
            RequestDispatcher rd = request.getRequestDispatcher(Path.path.reLogin.pathName());
            rd.forward(request, response);
            
        } finally {
            if(db_st != null || db_data != null || db_con != null) {
                try {
                    db_st.close();
                    db_data.close();
                    db_con.close();
                } catch (SQLException ex) {
                }
            }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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

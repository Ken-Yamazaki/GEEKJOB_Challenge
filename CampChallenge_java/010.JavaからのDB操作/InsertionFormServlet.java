/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dbOperation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.*;

/**
 * 課題：Java/DB操作/エラーハンドリング/フォームからデータを挿入
 * @author K.Yamazaki
 */
public class InsertionFormServlet extends HttpServlet {
    
    //DB操作用のフィールドを用意
    static Connection db_con = null;
    static PreparedStatement db_st = null;
    static ResultSet db_data = null;

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
        
        String title = "課題：Java/DB操作/エラーハンドリング/フォームからデータを挿入";
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>" + title + "</title>");            
            out.println("</head>");
            out.println("<body>");
            
            //フォームの入力内容（HTMLが送信する内容）を受け取る
            request.setCharacterEncoding("UTF-8");
            String table = request.getParameter("txtTable");
            String insertId = request.getParameter("numId");
            String insertName = request.getParameter("txtName");
            String insertTell = request.getParameter("txtTell");
            String insertAge = request.getParameter("numAge");
            String insertBirthday = request.getParameter("dateBirthday");
            
            //DBへ接続
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "root", "");
            out.println("MySQLの接続に成功しました。<br>");
            
            //MySQLのTABLEへ情報をINSERT（追加）する処理
            String sqlIn = "INSERT INTO "+table+" (profilesID, name, tell, age, birthday)"
                    + " VALUES ("+insertId+",'"+insertName+"','"+insertTell+"',"+Integer.parseInt(insertAge)+",'"+insertBirthday+"')";
            db_st = db_con.prepareStatement(sqlIn);
            db_st.executeUpdate();
            out.println("<br>入力された情報をテーブルへ追加します。<br>");
            
            //追加したメンバー情報を表示する
            out.println("追加する情報は下記です。<br>");
            out.println("------------------------------<br>");
            out.println("ID：" + insertId + "<br>");
            out.println("名前：" + insertName + "<br>");
            out.println("電話番号：" + insertTell + "<br>");
            out.println("年齢：" + insertAge + "<br>");
            out.println("誕生日：" + insertBirthday + "<br>");
            out.println("------------------------------<br>");
            
            //MySQLのTABLEの情報をSELECT（取得）する処理
            String sqlSe = "SELECT * FROM profiles";
            db_st = db_con.prepareStatement(sqlSe);
            db_data = db_st.executeQuery();
            
            //SQL文実行後のテーブル情報を表示させる
            out.println("<br><br>更新後のメンバー情報を表示します。<br>");
            while(db_data.next()) {
                out.println("------------------------------<br>");
                out.println("ID：" + db_data.getString("profilesID") + "<br>");
                out.println("名前：" + db_data.getString("name") + "<br>");
                out.println("電話番号：" + db_data.getString("tell") + "<br>");
                out.println("年齢：" + db_data.getString("age") + "<br>");
                out.println("誕生日：" + db_data.getString("birthday") + "<br>");
                out.println("");        //改行のため
            }
            out.println("------------------------------<br>");
            
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            System.out.println("MySQLの接続に失敗しました。");
            Logger.getLogger(DetectionFormServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            System.out.println("JDBCドライバのロードに失敗しました。");
            Logger.getLogger(DetectionFormServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(db_st != null || db_data != null || db_con != null) {
                try {
                    db_st.close();
                    db_data.close();
                    db_con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DetectionFormServlet.class.getName()).log(Level.SEVERE, null, ex);
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

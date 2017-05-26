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
import java.text.SimpleDateFormat;
import java.util.logging.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * 課題：Java/DB操作/エラーハンドリング/特定のレコードの更新
 * @author K.Yamazaki
 */
public class Db11_updateSpecifiedRecordServlet extends HttpServlet {
    
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
        
        String title = "課題：Java/DB操作/エラーハンドリング/特定のレコードの更新";
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
            String updateId = request.getParameter("numId");
            String updateName = request.getParameter("txtName");
            String updateTell = request.getParameter("txtTell");
            String updateAge = request.getParameter("txtAge");
            String y = request.getParameter("y");
            String m = request.getParameter("m");
            String d = request.getParameter("d");
            
            Calendar c = Calendar.getInstance();            
            c.set(Integer.parseInt(y), Integer.parseInt(m), Integer.parseInt(d));
            java.util.Date date = c.getTime();
            Date sqlDate = new Date(date.getTime());
            
            //DBへ接続
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "root", "");
            out.println("MySQLの接続に成功しました。<br><br>");
            
            //MySQLのTABLEのレコードをUPDATE（更新）する処理
            String sql ="UPDATE "+table+" SET name = ? , tell = ? , age = ? ,"
                    + "birthday = ? WHERE profilesID = ?";
            db_st = db_con.prepareStatement(sql);
            db_st.setString(1, updateName);
            db_st.setString(2, updateTell);
            db_st.setInt(3, Integer.parseInt(updateAge));
            db_st.setDate(4, sqlDate);
            db_st.setInt(5, Integer.parseInt(updateId));
            db_st.executeUpdate();
            out.println("IDが【" + updateId + "】のメンバー情報を更新します。");
            
            //MySQLのTABLE情報をSELECT（取得する）処理
            String sqlSe = "SELECT * FROM " + table;
            db_st = db_con.prepareStatement(sqlSe);
            db_data = db_st.executeQuery();
            
            //SQL文実行後、テーブルの内容を表示する
            while (db_data.next()) {                
                out.println("ID：" + db_data.getString("profilesID") + "<br>");
                out.println("名前：" + db_data.getString("name") + "<br>");
                out.println("電話番号：" + db_data.getString("tell") + "<br>");
                out.println("年齢：" + db_data.getString("age") + "<br>");
                out.println("誕生日：" + db_data.getString("birthday") + "<br>");
                out.println("");
            }
            
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

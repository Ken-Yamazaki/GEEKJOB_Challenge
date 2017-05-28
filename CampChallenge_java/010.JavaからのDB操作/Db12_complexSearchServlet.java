/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dbOperation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.Calendar;
import java.util.logging.*;

/**
 * 課題：Java/DB操作/エラーハンドリング/複合検索
 * @author K.Yamazaki
 */
@WebServlet(name = "Db12_complexSearchServlet", urlPatterns = {"/Db12_complexSearchServlet"})
public class Db12_complexSearchServlet extends HttpServlet {
    
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
        
        String title = "課題：Java/DB操作/エラーハンドリング/複合検索";
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
            String name = request.getParameter("txtName");
            String tell = request.getParameter("txtTell");
            String age = request.getParameter("numAge");
            String y = request.getParameter("y");
            String m = request.getParameter("m");
            String d = request.getParameter("d");
            //年、月、日をDate型に変換
            Date sqlDate = null;
            if(!(y.equals("")) && !(m.equals("")) && !(d.equals(""))) {
                Calendar c = Calendar.getInstance();        //Calendarクラスをインスタンス化
                c.set(Integer.parseInt(y), Integer.parseInt(m), Integer.parseInt(d));   //フィールドに年月日を設定
                java.util.Date date = c.getTime();      //1970年1月1日からの経過ミリ秒を取得する
                sqlDate = new Date(date.getTime());    //DateオブジェクトsqlDateを生成する
            }
            if(!(table.equals("")) && !(name.equals("")) && !(tell.equals("")) &&
                    !(age.equals("")) && !(sqlDate==null)) {   //すべての項目が入力済みならば、そのまま次の処理へ進む
            } else {        //入力フォーム内で一つでも未入力項目があった場合
                out.println("未入力項目があります。<br>");
                out.println("前ページへ戻って再入力してください。<br>");
            }
            
            //DBへ接続
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "root", "");
            
            //MySQLのTABLEの情報をSELECT（検索）する処理
            String sql = "SELECT * FROM " + table + " WHERE name = ? OR "
                    + "age = ? OR birthday = ?";
            db_st = db_con.prepareStatement(sql);
            db_st.setString(1, name);
            db_st.setInt(2, Integer.parseInt(age));
            db_st.setDate(3, sqlDate);            
            db_data = db_st.executeQuery();
            
            //検索条件を表示します。
            out.println("名前が【"+name+"】");
            out.println("または年齢が【"+age+"】");
            out.println("または誕生日が【"+y+"-"+m+"-"+d+"】");
            out.println("<br>の人を検索します。<br><br>");
            
            //MySQLのUPDATE処理後、TABLEの内容を表示する
            out.println("検索結果を表示します。<br>");
            print(out);
            
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
    
    //MySQLのUPDATE処理後、TABLEの内容を表示する
    static void print(PrintWriter pw) throws SQLException {
        while (db_data.next()) {
            pw.println("--------------------------------------------<br>");
            pw.println("ID："+db_data.getString("profilesID")+"<br>");
            pw.println("名前："+db_data.getString("name")+"<br>");
            pw.println("電話番号："+db_data.getString("tell")+"<br>");
            pw.println("年齢："+db_data.getString("age")+"<br>");
            pw.println("誕生日："+db_data.getString("birthday")+"<br>");
            pw.println("");        //改行のため
        }
        pw.println("--------------------------------------------");
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

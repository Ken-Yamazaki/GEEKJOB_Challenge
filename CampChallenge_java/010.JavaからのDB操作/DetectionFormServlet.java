/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dbOperation;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 課題：Java/DB操作/エラーハンドリング/検索用フォームの用意と検索（部分一致）
 * @author K.Yamazaki
 */
public class DetectionFormServlet extends HttpServlet {
    
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
        
        String title = "課題：Java/DB操作/エラーハンドリング/検索用フォームの用意と検索（部分一致）";
        try (PrintWriter out = response.getWriter()) {
            
            //フォームの入力内容（HTMLからの送信内容）を受け取る
            request.setCharacterEncoding("UTF-8");          //日本語が含まれるパラメータを処理する
            String inName = request.getParameter("txtName");  //名前テキストボックスへの入力内容を取得
            
            //DBへ接続
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "root", "");
            out.println("MySQLの接続に成功しました。<br><br>");
            
            //MySQLのTABELの情報をSELECT（取得）する処理
            String sql = "SELECT * FROM profiles WHERE name LIKE '%" + inName + "%'";
            db_st = db_con.prepareStatement(sql);
            db_data = db_st.executeQuery();     //SELECTなどの問い合わせ文のSQL文を実行する
            out.println("名前に【" + inName + "】を含むメンバー情報の検索結果を出力します。<br>");
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>" + title + "</title>");            
            out.println("</head>");
            out.println("<body>");
            
            //検索結果を表示させる
//            display();

        try {
            while(db_data.next()) {
                out.println("ID：" + db_data.getString("profilesID") + "<br>");
                out.println("名前：" + db_data.getString("name") + "<br>");
                out.println("電話番号：" + db_data.getString("tell") + "<br>");
                out.println("年齢：" + db_data.getString("age") + "<br>");
                out.println("誕生日：" + db_data.getString("birthday") + "<br>");
                out.println("");        //改行のため
            }
        } catch (SQLException ex) {
            System.out.println("エラーが発生しました。");
            Logger.getLogger(DetectionFormServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            db_st.close();
            db_data.close();
            db_con.close();
            
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
    
    //MySQLのTABLE情報を表示するメソッド
//    public static void display() {
//        try {
//            while(db_data.next()) {
//                out.println("ID：" + db_data.getString("profilesID"));
//                out.println("名前：" + db_data.getString("name"));
//                out.println("電話番号：" + db_data.getString("tell"));
//                out.println("年齢：" + db_data.getString("age"));
//                out.println("誕生日：" + db_data.getString("birthday"));
//                out.println("");        //改行のため
//            }
//        } catch (SQLException ex) {
//            System.out.println("エラーが発生しました。");
//            Logger.getLogger(DetectionFormServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

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

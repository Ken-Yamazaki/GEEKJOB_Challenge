/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javabeans.ProductList;

/**
 * 課題：Java/DB操作/エラーハンドリング/在庫管理システムの作成
 * 　トップページから商品追加ページへ遷移させるサーブレットクラス
 * @author K.Yamazaki
 */
public class TopToAddProduct extends HttpServlet {
    
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
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, 
            SQLException, InstantiationException, IllegalAccessException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            //DBへ接続
            //ユーザー名【KenYamazaki】でログイン
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/Challenge_db";
            db_con = DriverManager.getConnection(url, "KenYamazaki", "irodori2");
            
            //MySQLのdb13_productテーブルから商品情報（ID,name,price）を取得する
            String sql = "SELECT * FROM db13_product";
            db_st = db_con.prepareStatement(sql);
            db_data = db_st.executeQuery();
            
            //配列にID,name,priceを格納する
            ArrayList<Integer> id = new ArrayList<>();
            ArrayList<String> pName = new ArrayList<>();
            ArrayList<Integer> price = new ArrayList<>();
            while(db_data.next()) {
                id.add(db_data.getInt("ID"));
                pName.add(db_data.getString("Name"));
                price.add(db_data.getInt("price"));
            }
            
            //JavaBeans(ProductList.java)に商品情報（ID,name,price）をセットする
            ProductList list = new ProductList();
            //MySQLのdb13_productテーブルから取得したID,name,priceを引数として、
            //JavaBeansのセッターメソッドを呼び出す
            list.setId(id);
            list.setPName(pName);
            list.setPrice(price);
            //JavaBeansのフィールドに代入した内容をリクエストスコープに登録する
            request.setAttribute("list", list);
            
            RequestDispatcher rd = request.getRequestDispatcher(Path.path.addProduct.pathName());
            rd.forward(request, response);
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
            Logger.getLogger(TopToAddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TopToAddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TopToAddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TopToAddProduct.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TopToAddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TopToAddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TopToAddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TopToAddProduct.class.getName()).log(Level.SEVERE, null, ex);
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

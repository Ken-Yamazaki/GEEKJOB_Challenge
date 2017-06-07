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
 * 　addProduct.jspで入力した内容の商品をMySQLテーブルに追加するサーブレットクラス
 * @author K.Yamazaki
 */
public class AddProduct extends HttpServlet {
    
    //DB接続・操作用のフィールドを用意
    static public Connection db_con = null;
    static public PreparedStatement db_st = null;
    static public ResultSet db_data = null;
    //このサーブレットクラスから遷移させるjspへのパス
    static public String pathReAddProduct = "WEB-INF/jsp/reAddProduct.jsp";

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
            throws ServletException, IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            
            //DBへ接続
            //ユーザー名【KenYamazaki】でログイン
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/Challenge_db";
            db_con = DriverManager.getConnection(url, "KenYamazaki", "irodori2");
            
            //フォーム（addProduct.jsp）の入力内容を受け取る
            request.setCharacterEncoding("UTF-8");
            String pNameSt = request.getParameter("pName");
            String priceSt = request.getParameter("price");
            int priceInt = Integer.parseInt(priceSt);
            
            //その時点でのIDの最大数を取得する
            String sqlId = "SELECT ID FROM db13_product";
            db_st = db_con.prepareStatement(sqlId);
            db_data = db_st.executeQuery();
            int idInt = 0;
            while(db_data.next()) {
                idInt = db_data.getInt("ID");
            }
            
            //MySQLのdb13_productテーブルに商品情報（name,price）を追加する
            String sqlIn = "INSERT INTO db13_product (ID, name, price) VALUES (?, ?, ?)";
            db_st = db_con.prepareStatement(sqlIn);
            db_st.setInt(1, idInt+1);
            db_st.setString(2, pNameSt);
            db_st.setInt(3, priceInt);
            db_st.executeUpdate();
            
            //MySQLのdb13_productテーブルから情報をSELECT(取得)する処理
            String sqlSe = "SELECT * FROM db13_product";
            db_st = db_con.prepareStatement(sqlSe);
            db_data = db_st.executeQuery();
            
            //配列にID,name,priceを格納する
            ArrayList<Integer> id = new ArrayList<>();
            ArrayList<String> pName = new ArrayList<>();
            ArrayList<Integer> price = new ArrayList<>();
            while(db_data.next()) {
                id.add(db_data.getInt("ID"));
                pName.add(db_data.getString("name"));
                price.add(db_data.getInt("price"));
            }
            
            //JavaBeans(ProductList.java)に商品情報(ID,name,price)をセットし、
            //セッターメソッドを呼ぶ
            ProductList list = new ProductList();
            list.setId(id);
            list.setPName(pName);
            list.setPrice(price);
            //JavaBeansのフィールドに代入した内容をリクエストスコープに登録する
            request.setAttribute("list", list);
            
            RequestDispatcher rd = request.getRequestDispatcher(Path.path.reAddProduct.pathName());
            rd.forward(request, response);

        } finally {
            if(db_st != null || db_data != null || db_con != null) {
                    db_st.close();
                    db_data.close();
                    db_con.close();
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
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
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

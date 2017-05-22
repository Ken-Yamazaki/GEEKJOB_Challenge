/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dbOperation;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 課題：Java/DB操作/エラーハンドリング/テーブルへ情報を格納
 * @author K.Yamazaki
 */
public class StoringInfo {
    
    static Connection db_con = null;
    static PreparedStatement db_st = null;
    
    //メインメソッド
    public static void main(String[] args) {
        
        try {
            
            //DBへ接続
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "root", "");
            System.out.println("MySQLの接続に成功しました。");
            
            //MySQLのTABLEへ情報を追加する処理
            insert();
            
            db_con.close();
            db_st.close();
            
        } catch (SQLException ex) {
            System.out.println("MySQLの接続に失敗しました。");
            Logger.getLogger(MakeConnectionToDb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            System.out.println("JDBCドライバのロードに失敗しました。");
            Logger.getLogger(MakeConnectionToDb.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(db_con != null) {
                try {
                    db_con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MakeConnectionToDb.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //MySQLのTABLEに情報を追加するメソッド
    public static void insert() {
        try {
            String sql = "INSERT INTO profiles (profilesID, name, tell, age, birthday) VALUES (?,?,?,?,?)";
            db_st = db_con.prepareStatement(sql);
            db_st.setInt(1, 6); //ID
            db_st.setString(2, "山崎 健"); //name
            db_st.setString(3, "090-6177-2180"); //tell
            db_st.setInt(4, 28); //age
            db_st.setString(5, "1988-08-13"); //birthday
            db_st.executeUpdate();  //前処理済みのSQL文を実行する
        } catch (SQLException ex) {
            Logger.getLogger(StoringInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

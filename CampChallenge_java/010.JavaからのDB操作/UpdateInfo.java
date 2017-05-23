/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dbOperation;

import static java.lang.System.out;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 課題：Java/DB操作/エラーハンドリング/特定のレコードの更新
 * @author K.Yamazaki
 */
public class UpdateInfo {
   
    static Connection db_con = null;
    static PreparedStatement db_st = null;
    static ResultSet db_data = null;
    
    //メインメソッド
    public static void main(String[] args) {
        
        try {
            
            //DBへ接続
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "root", "");
            System.out.println("MySQLの接続に成功しました。");
            
            //MySQLのTABLEの情報をUPDATE(更新)する処理
            String sqlDe = "UPDATE profiles SET name = '松岡修造', age = 48, birthday = '1967-11-06' WHERE profilesID = 1";
            db_st = db_con.prepareStatement(sqlDe);
            db_st.executeUpdate();      //追加・削除などの更新のSQL文を実行する
                        
            //MySQLのTABLEの情報をSELECT(取得)する処理
            String sqlSe = "SELECT * FROM profiles";
            db_st = db_con.prepareStatement(sqlSe);
            db_data = db_st.executeQuery();  //SELECTなどの問い合わせ文のSQL文を実行する
            
            out.println("すべての情報を表示します");
            
            print();
            
            db_st.close();
            db_data.close();
            db_con.close();
            
        } catch (SQLException ex) {
            System.out.println("MySQLの接続に失敗しました。");
            Logger.getLogger(AllInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            System.out.println("JDBCドライバのロードに失敗しました。");
            Logger.getLogger(AllInfo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(db_st != null || db_data != null || db_con != null) {
                try {
                    db_st.close();
                    db_data.close();
                    db_con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MakeConnectionToDb.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //MySQLのTABLEの情報を表示するメソッド
    public static void print() {
        
        try {
            
            while(db_data.next()) {
                out.println("ID：" + db_data.getString("profilesID"));
                out.println("名前：" + db_data.getString("name"));
                out.println("電話番号：" + db_data.getString("tell"));
                out.println("年齢：" + db_data.getString("age"));
                out.println("誕生日：" + db_data.getString("birthday"));
                out.println("");        //改行のため
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

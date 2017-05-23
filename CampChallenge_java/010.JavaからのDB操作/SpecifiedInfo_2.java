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
 * 課題：Java/DB操作/エラーハンドリング/特定のレコードの情報取得と表示2
 * @author K.Yamazaki
 */
public class SpecifiedInfo_2 {
    
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
            
            //MySQLのTABLEの情報をSELECT(取得)する処理
            String sql = "SELECT * FROM profiles WHERE name LIKE ?";  //取得するcolumnは後で指定する
            db_st = db_con.prepareStatement(sql);
            db_st.setString(1, "%茂%");     //情報を取得する対象は、IDが1である人
            out.println("nameに「茂」を含む情報を表示します");
            
            getAndPrint();
            
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
    
    //MySQLのTABLEの情報を取得し、表示するメソッド
    public static void getAndPrint() {
        
        try {
            
            db_data = db_st.executeQuery();  //SELECTなどの問い合わせ文のSQL文を実行する
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

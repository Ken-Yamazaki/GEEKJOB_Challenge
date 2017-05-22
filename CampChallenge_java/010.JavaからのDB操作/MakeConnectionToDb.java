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
import jdk.nashorn.internal.ir.ForNode;

/**
 * 課題：Java/DB操作/エラーハンドリング/エラーハンドリングを含んだ接続の確立
 * @author K.Yamazaki
 */
public class MakeConnectionToDb {
    
    public static void main(String[] args) {
        
        Connection db_con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();       //JDBCドライバのインスタンスを作成
            db_con = DriverManager.getConnection("jdbc:mysql://localhost/Challenge_db", "root", "");        //DBへの接続を取得
            System.out.println("MySQLの接続に成功しました。");
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
}

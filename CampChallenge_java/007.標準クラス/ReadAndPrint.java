/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.normalclass.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 課題：Java／標準クラス／ファイル操作編／ファイルから読み出しと表示
 * @author K.Yamazaki
 */
public class ReadAndPrint {
    public static void main(String[] args) throws IOException {     //"throws"は、"readLine"を記述した際にAlt+Enterで表示される自動入力を利用した
        FileReader fr = null;   //FileReader変数を定義
        //"try-catch-finally"は、Alt+Enterで表示される自動入力を利用した
        try {
            File f = new File("C:\\Users\\K.Yamazaki\\Documents\\test.txt");    //ファイルを開く
            fr = new FileReader(f);     //FileReaderを作成？
            BufferedReader br = new BufferedReader(fr);     //BufferedReaderを作成？
            
            /*ファイルの先頭から最後まで読み込むための記述
              readメソッドは、1文字ずつファイルの中身を読み込む
            */
            int a;
            while((a = fr.read()) != -1) {        //ファイルの最後に達したとき、readメソッドは"-1"を返す
                System.out.print((char)a);  //ファイルの内容を1文字ずつ表示させる
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadAndPrint.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
                fr.close();     //ファイルを閉じる
        }
    }
}

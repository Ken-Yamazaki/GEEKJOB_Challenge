/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.normalclass.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 課題：Java／標準クラス／ファイル操作編／ファイルの書き出しと保存
 * @author K.Yamazaki
 */
public class WriteAndSave {

    public static void main(String[] args) throws IOException {
        //自己紹介文を作成
        String myName = "山崎";
        String info = "Javaを勉強中です";
        //ファイルへ書き込む予定の内容を表示させる
        System.out.println("山崎です");
        System.out.println("Javaを勉強中です");
        
        File f = new File("C:\\Users\\K.Yamazaki\\Documents\\test.txt");    //ファイルを開く
        FileWriter fw = new FileWriter(f);      //FileWriterをインスタンス化
        fw.write(myName + "です");      //テキストファイルへの書き込み
        fw.write("\n");     //改行
        fw.write(info);     //テキストファイルへの書き込み
        fw.close();     //ファイルを閉じる
    }
}

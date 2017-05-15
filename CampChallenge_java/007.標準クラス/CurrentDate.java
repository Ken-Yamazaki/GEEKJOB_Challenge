/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.normalclass;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 課題：Java／標準クラス／日付編／現在の日時の表示
 * @author K.Yamazaki
 */
public class CurrentDate {
    public static void main(String[] args) {
        Date d = new Date();                    //現在の日時を取得
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     //フォーマット(書式)を指定
        System.out.println(sdf.format(d));      //Date型を文字列に変換
    }
    
}

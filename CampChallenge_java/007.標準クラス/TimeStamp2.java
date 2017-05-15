/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.normalclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 課題：Java／標準クラス／日付編／タイムスタンプの表示2
 * @author K.Yamazaki
 */
public class TimeStamp2 {
    public static void main(String[] args) throws ParseException {       //“throws ParseException”は、parseの行で出現するヒントから自動入力した
                
        Date d1 = new Date();       //Dateをインスタンス化
        Date d2 = new Date();       //同上
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     //SimpleDateFormatをインスタンス化
        d1 = sdf.parse("2015-01-01 0:0:0");             //Date型を文字列に変換＆日時を指定
        d2 = sdf.parse("2015-12-31 23:59:59");          //同上
        long t1 = d1.getTime();     //タイムスタンプを取得し、Date型オブジェクトを整数へ代入
        long t2 = d2.getTime();
        System.out.println("2015年1月1日 0時0分0秒のタイムスタンプ：" + t1);
        System.out.println("2015年12月31日 23時59分59秒のタイムスタンプ：" + t2);
        long large = Math.max(t1, t2);  //t1,t2のうち大きい数値を取得する
        long small = Math.min(t1, t2);  //t1,t2のうち小さい数値を取得する
        System.out.println();       //改行のため
        System.out.println("タイムスタンプの差は" + (large - small)/1000);
    }
}

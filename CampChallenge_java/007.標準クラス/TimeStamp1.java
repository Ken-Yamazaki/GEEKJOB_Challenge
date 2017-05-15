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
 * 課題：Java／標準クラス／日付編／タイムスタンプの表示1
 * @author K.Yamazaki
 */
public class TimeStamp1 {
    public static void main(String[] args) throws ParseException {              //“throws ParseException”は、parseの行で出現するヒントから自動入力した
        Date d = new Date();                    //Dateをインスタンス化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     //SimpleDateFormatをインスタンス化
        String date = sdf.format(d);            //Date型を文字列に変換
        System.out.println(date);
    }
}

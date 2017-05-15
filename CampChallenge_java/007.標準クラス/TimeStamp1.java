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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     //SimpleDateFormatのインスタンスを作成
        Date d = sdf.parse("2016-11-04 10:0:0");     //引数に指定した文字列を解釈して、Dateオブジェクトを返す
        long timeStamp = d.getTime();       //取得したDate型オブジェクトを整数へ代入
        System.out.println(timeStamp);
    }
}

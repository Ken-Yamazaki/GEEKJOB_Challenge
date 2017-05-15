/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.normalclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



/**
 * 課題：Java／標準クラス／日付編／タイムスタンプの作成
 * 参考URL:http://tatuas.hatenablog.com/entry/2014/06/29/051834
 * @author K.Yamazaki
 */
public class DateTimeStamp {
    public static void main(String[] args) throws ParseException {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy'/'m'/'dd' 'HH':'mm':'ss");    //SimpleDateFormatのインスタンスを作成
        sdf.applyPattern("yyyy/MM/dd HH:mm:ss");        //フォーマットパターンを変更
        Date d = sdf.parse("2016/01/01 0:0:0");     //引数に指定した文字列を解釈して、Dateオブジェクトを返す
        long timeStamp = d.getTime();       //取得したDate型オブジェクトを整数へ代入
        System.out.println(timeStamp);
    }
}

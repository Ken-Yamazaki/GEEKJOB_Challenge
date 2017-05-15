/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.normalclass;

/**
 * 課題：Java／標準クラス／文字列編／バイト数と文字数の取得
 * @author K.Yamazaki
 */
public class StringLine {
    public static void main(String[] args) {
        String kanji = "山崎健";            //名前を定義
        String hiragana = "やまざきけん";   //名前を定義
        System.out.println(kanji + "の文字数は" + "【" + kanji.length() + "】");                    //漢字名の文字数を表示
        System.out.println(kanji + "のバイト数は" + "【" + kanji.getBytes().length + "】");         //漢字名のバイト数を表示
        System.out.println(hiragana + "の文字数は" + "【" + hiragana.length() + "】");              //ひらがな名の文字数を表示
        System.out.println(hiragana + "のバイト数は" + "【" + hiragana.getBytes().length + "】");   //ひらがな名のバイト数を表示
    }
    
}

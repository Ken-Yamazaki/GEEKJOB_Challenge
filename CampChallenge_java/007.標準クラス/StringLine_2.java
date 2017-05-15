/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.normalclass;

/**
 * 課題：Java／標準クラス／文字列編／文字数の取得
 * @author K.Yamazaki
 */
public class StringLine_2 {
    public static void main(String[] args) {
        String mail = "yamazaki0053@gmail.com";     //メールアドレス名(文字列)を記述
        int a = mail.indexOf("@");                  //"@"が現れる文字位置を取得(先頭の文字から何番目に"@"が現れるか)
        System.out.println("メールアドレスの「@」の文字を表示します");
        System.out.println(mail.substring(a));      //"@"以降の文字を表示する
    }
}

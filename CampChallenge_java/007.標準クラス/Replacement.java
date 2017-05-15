/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.normalclass;

/**
 * 課題：Java／標準クラス／文字列編／文字の入れ替え
 * @author K.Yamazaki
 */
public class Replacement {
    public static void main(String[] args) {
        
        String before = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
        /*「I」⇒「い」に、「U」⇒「う」に入れ替える処理を作成し、
          結果を表示する。
        */
        String after1 = before.replace("I", "い");
        String after2 = after1.replace("U", "う");
        
        System.out.println("置換前の文字列は【" + before + "】");
        System.out.println("置換後の文字列は【" + after2 + "】");
    }
}

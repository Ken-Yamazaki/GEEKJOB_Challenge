/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.Class;

/**
 * 課題：Java／クラス／クラスの継承
 * @author K.Yamazaki
 */
public class Inheritance extends UseClass {
    
    public static void main (String[] args) {
        clearVal();
        printVal();
    }
    //２つの変数の中身をクリアするパブリックなメソッド
    public static void clearVal() {
        name = "";
        age = 0;
    }
}

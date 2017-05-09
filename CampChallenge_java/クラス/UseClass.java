/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.Class;

/**
 *
 * @author K.Yamazaki
 */

//クラスを作成
public class UseClass {
    
    /**
     * mainメソッド
     * @param args 
     */
    public static void main (String[] args) {
        setVal();
        printVal();
    }
    
    //パブリックな2つの変数を作成
    public static String name;
    public static int age;
    
    //2つの変数に値を設定するパブリックなメソッド
    public static void setVal() {
        name = "山崎";
        age = 28;
    }
    
    //2つの変数の中身をprintするパブリックなメソッド
    public static void printVal() {
        System.out.println(name);
        System.out.println(age);
    }
}

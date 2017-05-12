/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.blacjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 課題：Java／クラス／抽象クラス（ブラックジャック）
 * @author K.Yamazaki
 */
public class User extends Human {

    //最初にディーラーから2枚のカードを配ってもらう
    @Override
    public void setCard(ArrayList<Integer> a) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for(int i=0; i<a.size(); i++) {
            myCards.add(a.get(i));
        }
    }
    
    //ArrayList型の変数myCardsの中身の数値を合計し、返す（手札の2枚のカードの合計値を計算する）
    @Override
    public int open() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int sum = 0;                            //手札2枚のカードの合計値用の変数を定義する
        for(int i=0; i<myCards.size();i++) {    //持っている枚数分だけカードの数値を足し合わせる
            sum = sum + myCards.get(i);
        }
        return sum;
    }
    
    //myCards(手札)を確認し、まだカードが必要ならtrue、必要無ければfalseを返す（abstract Humanクラスのabstractメソッド）
    int i = 0;      //カードを引く回数を数えるために用意する
    @Override
    public boolean checkSum() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        //カードを引くか否かをユーザーに聞く
        System.out.println("ユーザーはカードを引きますか？");
        System.out.println("カードを引く場合は“y”を入力し、Enterを押してください");
        System.out.println("カードを引かない場合は“n”を入力し、Enterを押してください");
        //キーボードからの文字入力を受け取る準備
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String str = "";
        
        int a = open();     //手札合計を入れる変数aを用意
        if(a < 21) {        //手札合計が21を超えない場合、カードを引く・引かないを選択できる
            try {
                str = br.readLine();     //キーボードからの文字入力を受け取る
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(a > 21) {    //手札合計が21を超えたらカードを引けなくなる
            System.out.println("ユーザーの手札合計が21を超えました");
            str = "n";
        }
        //tyr{}catch{}はAlt+Enterで出現するヒントを利用して自動入力した
            do {
                switch(str) {
                    case "y":                                   //"y"を入力し、Enterを押すとtrueを返す
                        System.out.println("カードを引きます");
                        System.out.println("");     //改行のため
                        Dealer de = new Dealer();
                        myCards.add(de.hit().get(0));       //手札(myCards)に1枚カードを加える
                        i++;        //カードを引いた回数をカウントする
                        break;
                    case "n":                                   //"n"を入力し、Enterを押すとfalseを返す
                        System.out.println("この手札で勝負します");
                        System.out.println("");                 //改行のため
                        break;
                    default:
                        System.out.println("yかnを入力してください");
                        try {
                            str = br.readLine();        //キーボード入力させる
                        } catch (IOException ex) {
                            Logger.getLogger(Dealer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                }
            } while(!(str.equals("y")) && !(str.equals("n")));
        if(str.equals("y")) {
            return true;
        } else {
            return false;   
        }
    }
    
}

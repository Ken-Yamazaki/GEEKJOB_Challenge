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
public class Dealer extends Human {
    
    ArrayList<Integer> cards;
    
    /**
     * コンストラクタ
     * ArrayList型の変数cardsにトランプ1～13×4(No.1～52)を持たせる
     * 0～12番目がエース(1)～キング(13)、13～25番目がエース(1)～キング(13)、…
     */
    Dealer() {
        this.cards = new ArrayList<>();
        for(int i=1; i<=4; i++) {       //4種類のマークごとに1～13のカードを用意する
            for(int j=1; j<=13; j++) {  //1～13のカードを用意する
                if(j <= 10) {     //カードの数値が10以下の場合は、数値をそのまま使用する
                    cards.add(j);
                } else if(10 < j) {     //ジャック(11)、クイーン(12)、キング(13)の場合、数値は10とする
                    cards.add(10);
                }
            }
        }
    }

    //最初にユーザーに2枚のカードを配る
    @Override
    public void setCard(ArrayList<Integer> a) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for(int i=0; i<a.size(); i++) {
            myCards.add(a.get(i));
        }
    }
    
    //ランダムで2枚のカードをArrayList型の変数drawCardsに返す（最初に配る2枚のカードを決定する）
    public ArrayList<Integer> deal() {

        Random r = new Random();        //52枚あるカードのうち、0～51番目のどのカードを引くか
        ArrayList<Integer> drawCards = new ArrayList<>();       //return用のArrayList型の変数drawCardsを用意
        for(int a=0; a<=1; a++) {           //カードを2枚引くために2回ループさせる
            int cardNum = r.nextInt(51);    //コンストラクタで0から51番目まで要素を作ったcardsのうち、何番目を引くか決める
            cards.get(cardNum);             //カードを引く
            drawCards.add(this.cards.get(cardNum));     //引いたカードを、return用のArrayList型の変数drawCardsに代入する
        }
        return drawCards;               //引いた2枚のカードを返す
    }
    
    //ランダムで1枚のカードをArrayListに返す（カードを1枚引く）
    ArrayList<Integer> plusCard = new ArrayList<>();    //return用のArrayList型の変数plusCardを用意
    public ArrayList<Integer> hit() {
        Random r = new Random();        //52枚あるカードのうち、0～51番目のどのカードを引くか
        int cardNum = r.nextInt(51);    //コンストラクタで0から51番目まで要素を作ったcardsのうち、何番目を引くか決める
        cards.get(cardNum);             //カードを引く
        plusCard.add(this.cards.get(cardNum));      //引いたカードを、return用のArrayList型の変数plusCardsに代入する
        return plusCard;              //引いた1枚のカードを返す
    }
    
    //手札(myCards)の中身の数値を合計し、返す
    @Override
    public int open() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int sum = 0;                            //手札2枚のカードの合計値用の変数を定義する
        for(int i=0; i<myCards.size();i++) {    //持っている枚数分だけカードの数値を足し合わせる
            sum = sum + myCards.get(i);
        }
        return sum;
    }
    
    //myCards(手札)を確認し、まだカードが必要ならtrue、必要無ければfalseを返す
    int i = 0;      //カードを引く回数を数えるために用意する
    @Override
    public boolean checkSum() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        int a = open();
        String str = "";
        //キーボードからの文字入力を受け取る準備
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        //手札の2枚のカード数値の合計が17未満であれば、カードを引く
        if(a < 17) {
            System.out.println("ディーラーはカード合計が17未満なので、カードを引く必要があります");
            str = "y";
        } else if(17 <=a && a<=21){
            //手札合計が17以上21以下のとき、カードを引くか否かをディーラーに聞く
            System.out.println("ディーラーのカード合計は17以上21以下です。カードを引きますか？");
            System.out.println("カードを引く場合は“y”を入力し、Enterを押してください");
            System.out.println("カードを引かない場合は“n”を入力し、Enterを押してください");
            //tyr{}catch{}はAlt+Enterで出現するヒントを利用して自動入力した
            try {
                //キーボードからの入力を受け取る
                //tyr{}catch{}はAlt+Enterで出現するヒントを利用して自動入力した
                str = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Dealer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(21 < a) {
            System.out.println("ディーラーの手札合計が21を超えました");
            str = "n";
        }
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
        } while( !(str.equals("y")) && !(str.equals("n")) );
        if(str.equals("y")) {
            return true;
        } else {
            return false;
        }
    }
    
}
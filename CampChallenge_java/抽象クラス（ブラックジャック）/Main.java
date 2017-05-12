 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.blacjack;

/**
 *
 * @author K.Yamazaki
 */
public class Main {
    public static void main(String[] args) {
        
        //DealerクラスとUserクラスのインスタンスを生成
        Dealer de = new Dealer();
        User us = new User();

        //ディーラーとユーザーにカードを2枚ずつ配る
        de.setCard(de.deal());
        us.setCard(de.deal());

        /*checkSumの戻り値がtrue　⇒　カードを引く
                           false　⇒　openメソッドを呼び出す
        */
        int i = 0;          //DealerクラスのhitメソッドからのArrayList型の戻り値plusCardに要素を追加していくための変数
        while(us.checkSum() == true) {        //trueが返ってくる限り、カードを引く
//            de.hit();
            us.myCards.add(de.hit().get(i));
            i++;
        }
        i = 0;
        while(de.checkSum() == true) {          //trueが返ってくる限り、カードを引く
//            de.hit();
            de.myCards.add(de.hit().get(i));    //手札(myCards)にカードを1枚追加する
            i++;
        }

        //勝負する
        int usum = us.open();
        int dsum = de.open();
        System.out.println("ディーラーのカードの合計は" + dsum + "です");
        System.out.println("ユーザーのカードの合計は" + usum + "です");
        if(dsum > 21) {     //ディーラーの手札合計が21を超えていたら
            if(usum > 21) {
                System.out.println("ユーザーもディーラーもカードの合計が21を超えました");
                System.out.println("引き分けです");
            } else if (usum < 21) {
                System.out.println("ディーラーのカードの合計が21を超えているため、ユーザーの勝ちです");
            }
        }
        else if(dsum < 21) {        //ディーラーの手札合計が21以下だったら
            if(usum > 21) {
                System.out.println("ユーザーのカードの合計が21を超えているため、ディーラーの勝ちです");
            } else {
                if(usum > dsum){
                    System.out.println("ユーザーの勝ちです");
                } else if(usum < dsum) {
                    System.out.println("ディーラーの勝ちです");
                } else if(usum == dsum) {
                    System.out.println("引き分けです");
                }
            }
        }
    }
}
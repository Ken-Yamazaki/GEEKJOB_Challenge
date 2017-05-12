/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.blacjack;

import java.util.ArrayList;

/**
 * 課題：Java／クラス／抽象クラス   
 * @author K.Yamazaki
 */
public abstract class Human {
    
    public abstract int open();
    public abstract void setCard(ArrayList<Integer> a);
    public abstract boolean checkSum();
    ArrayList<Integer> myCards = new ArrayList<>();
    
}

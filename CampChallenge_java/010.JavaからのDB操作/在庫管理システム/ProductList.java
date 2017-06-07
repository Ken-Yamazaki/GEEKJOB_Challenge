/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.util.ArrayList;

/**
 * 課題：Java/DB操作/エラーハンドリング/在庫管理システムの作成
 * 　SQLのdb13_productテーブルの情報を格納するJavaBeans
 * @author K.Yamazaki
 */
public class ProductList implements java.io.Serializable {
    private ArrayList<Integer> id = new ArrayList<>();
    private ArrayList<String> pName = new ArrayList<>();
    private ArrayList<Integer> price = new ArrayList<>();
    
    //コンストラクタ
    public ProductList() {}
    
    /**
     * @return id
     */
    public ArrayList<Integer> getId() {
        return id;
    }
    
    /**
     * @param id 
     */
    public void setId(ArrayList<Integer> id) {
        this.id = id;
    }
    
    /**
     * @return pName
     */
    public ArrayList<String> getPName() {
        return pName;
    }
    
    /**
     * @param pName 
     */
    public void setPName(ArrayList<String> pName) {
        this.pName = pName;
    }
    
    /**
     * @return price
     */
    public ArrayList<Integer> getPrice() {
        return price;
    }
    
    /**
     * @param price 
     */
    public void setPrice(ArrayList<Integer> price) {
        this.price = price;
    }
    
}

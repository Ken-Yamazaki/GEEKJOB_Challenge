/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

//まずJavaBeansを満たすための条件①～④を作る

//①java.io.Serializableインターフェースを実装する
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author K.Yamazaki
 */
public class ResultData {
    
    //②プライベートなフィールド
    private Date d;
    private String luck;
    //③publicで引数の無いコンストラクタ
    public ResultData() {}
    //④getter、setter
    /**
     * @return the d
     */
    public Date getD() {
        return d;
    }
    /**
     * @param d the d to set
     */
    public void setD(Date d) {
        this.d = d;
    }
    /**
     * @return the luck
     */
    public String getLuck() {
        return luck;
    }
    /**
     * @param luck the luck to set
     */
    public void setLuck(String luck) {
        this.luck = luck;
    }
}

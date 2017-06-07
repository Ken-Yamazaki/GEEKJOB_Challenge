/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

/**
 *
 * 参考URL：http://bleis-tift.hatenablog.com/entry/20090916/1253084400
 * @author K.Yamazaki
 */
public class Path {
    
    public enum path {
        top, reLogin, productList, addProduct, reAddProduct, login;
        public String pathName() {
            switch (this) {
                case top: return "WEB-INF/jsp/top.jsp";
                case reLogin: return "WEB-INF/jsp/reLogin.jsp";
                case productList: return "WEB-INF/jsp/productList.jsp";
                case addProduct: return "WEB-INF/jsp/addProduct.jsp";
                case reAddProduct: return "WEB-INF/jsp/reAddProduct.jsp";
                case login: return "logIn.jsp";
                default: throw new IllegalStateException();
            }
        }
    }
    
}

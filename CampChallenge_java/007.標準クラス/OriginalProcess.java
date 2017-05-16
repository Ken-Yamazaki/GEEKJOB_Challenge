/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.normalclass.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 課題：Java／標準クラス／ファイル操作編／標準クラスを利用して処理を作成
 * 名前と年齢を入力させ、正しい情報が入力されると処理を終了する
 * @author K.Yamazaki
 */
public class OriginalProcess {
    
    
    //ログファイル作成のための準備
    final static Date d = new Date();        //現在の日付を取得する（のちにログファイル名に使用する）
    final static SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd_HHmmss");   //インスタンス化
    final static String DATE = sdf.format(d);                            //取得した日時（Date型）を文字列に変換する
    final static String PATH = "C:\\tmp\\" + DATE + "log.txt";          //ファイルパスを定義しておく
    
    
    //メインメソッド
    public static void main(String[] args) throws IOException {
        
        
        /*ログファイルを作成する
          参考URL：https://www.javadrive.jp/start/file/index4.html
        */
        File log = new File(PATH);                              //ファイルを作成する
        try{
            if(log.createNewFile()) {                               //ログファイルを作成する
                System.out.println("ファイルの作成に成功しました");
            } else if(log.exists()) {                               //同名のファイルが存在した場合
                System.out.println("ファイルは存在します");
            } else {
                System.out.println("ファイルの作成に失敗しました");
            }
        } catch(IOException e) {
            System.out.println(e);
        }
        
        System.out.println("処理を開始します");        
        input();        //inputメソッドを呼び出す
        
    }
    
    //キーボード入力させ、入力内容をチェックするメソッド
    public static void input() throws IOException {
        
        
        /*キーボードから入力させる
          参考URL：https://eng-entrance.com/java-scanner-type
                  http://qiita.com/dk_masu/items/eec89bb622981ceda0ed
        */
        Scanner scan = new Scanner(System.in);      //Scannerクラスをインスタンス化。引数で指定したところから値を読み込む。引数に"System.in"を使用したら、キーボードから読み込む対象のテキストを入力する。
        System.out.println("名前を入力してください");
        String name = scan.next();      //文字を読み込む。キーボードからの入力後、Enterキーを押す
        System.out.println("【" + name + "】" + "が入力されました");
        System.out.println("年齢を入力してください");
        int age = scan.nextInt();       //文字を読み込む。キーボードからの入力後、Enterキーを押す
        System.out.println("【" + age + "】" + "が入力されました");
        
        /*キーボード入力内容をログファイルに書き込む
        　この記述だと、close()を呼び出さなくても自動でcloseをしてくれるとのこと
          参考URL：http://www.task-notes.com/entry/20150504/1430708400
        */
        File f = new File(PATH);                //ログファイルを開く
        FileWriter fw1 = null;
        try {
            fw1 = new FileWriter(f); //FileWriterインスタンスを作成
        } catch (IOException ex) {
            Logger.getLogger(OriginalProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        fw1.write("【" + name + "】" + "が入力されました");  //キーボード入力内容をログファイルに記述する
        fw1.write("【" + age + "】" + "が入力されました");   //キーボード入力内容をログファイルに記述する
        fw1.close();
        
        /*入力した名前と年齢が違った場合、再入力させる
          指定してある内容と入力内容が合致しない限り、入力させ続ける
        */
        while(!(name.equals("KenYamazaki"))) {          //"name"が"KenYamazaki"でないとき、名前を再入力させる
            FileWriter fw2 = new FileWriter(f, true);    //FileWriterインスタンスを作成（ファイルを開く）
            System.out.println("名前が違います。もう一度入力してください");
            System.out.println("");                 //改行のため
            name = scan.next();                     //キーボードからの入力後、Enterキーを押す
            System.out.println("【" + name + "】" + "が入力されました");
            fw2.write("入力された名前は" + name);     //ファイルに書き込み
            fw2.close();
        }
        while(age != 28) {                          //"age"が"28"でないとき、年齢を再入力させる
            FileWriter fw3 = new FileWriter(f, true);     //FileWriterインスタンスを作成（ファイルを開く）
            System.out.println("年齢が違います。もう一度入力してください");
            System.out.println("");                 //改行のため
            age = scan.nextInt();                   //キーボードからの入力後、Enterキーを押す
            System.out.println("【" + age + "】" + "が入力されました");
            fw3.write("入力された年齢は" + age);     //ファイルに書き込み
            fw3.close();
        }
    }

}

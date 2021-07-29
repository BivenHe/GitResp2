package com.zd.singleton;

/**
 * @author: Dong
 * @date: 2021/7/29 - 11:47
 * @Description: com.zd.singleton
 * @version: 1.0
 */

/**
 * lazy loading
 * 减少同步代码块发生了线程不安全的问题
 * 在同步代码块后再加if(null)，可以解决线程不安全问题，但效率仍然下降
 * */
public class Mgr06 {
    private static Mgr06 Instance;
    private Mgr06(){}
    public static Mgr06 getInstance(){
        if (Instance==null){
            synchronized (Mgr06.class){
                if (Instance==null){
                    Instance=new Mgr06();
                }
            }
        }
        return Instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr06.getInstance().hashCode());
            }).start();
        }
    }
}

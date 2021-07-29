package com.zd.singleton;

/**
 * @author: Dong
 * @date: 2021/7/25 - 12:50
 * @Description: com.zd.INSTANCE
 * @version: 1.0
 */

/**
 * lazy loading
 * 懒汉式
 * 虽然达到了按需初始化的目的，但却带来显示不安全
 */
public class Singleton {

    private static Singleton INSTANCE;
    private Singleton(){}

    public static Singleton getInstance(){
        if (INSTANCE ==null)
            INSTANCE = new Singleton();
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton s1= Singleton.getInstance();
        Singleton s2= Singleton.getInstance();
        System.out.println(s1==s2);
    }


}

package com.zd.singleton;

/**
 * @author: Dong
 * @date: 2021/7/28 - 2:48
 * @Description: com.zd.singleton
 * @version: 1.0
 */

/**
 * 懒汉式
 * 虽然达到了按需初始化的目的，但引入了线程不安全的问题
 * 当第一个线程在进行创建类加载初始化时，其他的线程会判断为null，继续创建了单例对象
 */
public class Mgr03 {

    private static Mgr03 INSTANCE;
    private Mgr03(){}
    public static Mgr03 getInstance(){
        if (INSTANCE==null) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }
    public void show(){
        System.out.println(INSTANCE.getClass());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr03.getInstance());
            }).start();
        }

    }
}

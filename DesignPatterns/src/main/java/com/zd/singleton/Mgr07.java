package com.zd.singleton;

/**
 * @author: Dong
 * @date: 2021/7/29 - 13:01
 * @Description: com.zd.singleton
 * @version: 1.0
 */

/**
 *静态内部类实现懒加载：
 * JVM保证单例,也不会出现线程不安全问题
 * 加载外部内时，不会加载内部类，这样就可以实现懒加载
 */
public class Mgr07 {

    private Mgr07(){}

    private static class Mgr07Holder{
        private static final Mgr07 Instance=new Mgr07();
    }

    public static Mgr07 getInstance(){return Mgr07Holder.Instance;}

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr07.getInstance().hashCode());
            }).start();
        }
    }

}

package com.zd.singleton;

/**
 * @author: Dong
 * @date: 2021/7/28 - 2:42
 * @Description: com.zd.singleton
 * @version: 1.0
 */

/**
 * 将final的初始化放入静态初始化块中
 * 与mgr01一样
 */
public class Mgr02 {
    private static final Mgr02 INSTANCE;
    static {
        INSTANCE=new Mgr02();
    }
    private Mgr02(){}
    public static Mgr02 getInstance(){
        return INSTANCE;
    }
    void show(){
        System.out.println(INSTANCE.getClass());
    }

    public static void main(String[] args) {
        Mgr02 m1 = Mgr02.getInstance();
        Mgr02 m2 = Mgr02.getInstance();
        System.out.println(m1==m2);
        m1.show();
    }
}

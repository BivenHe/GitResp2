package com.zd.singleton;

/**
 * @author: Dong
 * @date: 2021/7/28 - 3:09
 * @Description: com.zd.singleton
 * @version: 1.0
 */

/**
 *lazy loading 通过synchronized保证线程安全问题，但会带来效率下降问题
 * 优化效率问题，减少同步代码块，然而不可行，依然存在线程不安全：
 * 在synchronized之前 仍然有线程进来getINSTANCE()
 */
public class Mgr05 {
    private static Mgr05 INSTANCE;
    private Mgr05(){}
    public static Mgr05 getINSTANCE(){
        if (INSTANCE==null){
            synchronized (Mgr05.class){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Mgr05();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr05.getINSTANCE().hashCode());

            }).start();
        }
    }
}

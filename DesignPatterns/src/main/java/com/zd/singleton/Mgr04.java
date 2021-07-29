package com.zd.singleton;

/**
 * @author: Dong
 * @date: 2021/7/28 - 3:05
 * @Description: com.zd.singleton
 * @version: 1.0
 */

/**
 * lazy loading
 * 懒汉式的线程不安全可以通过synchronized解决，但会带来效率下降
 */
public class Mgr04 {
    private static Mgr04 INSTANCE;
    private Mgr04(){}
    public static synchronized Mgr04 getINSTANCE(){
        if(INSTANCE == null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE=new Mgr04();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {

            new Thread(()->{
                System.out.println(Mgr04.getINSTANCE().hashCode());
            }).start();

        }
    }
}

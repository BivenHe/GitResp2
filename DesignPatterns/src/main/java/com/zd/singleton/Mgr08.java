package com.zd.singleton;

/**
 * @author: Dong
 * @date: 2021/7/29 - 13:49
 * @Description: com.zd.singleton
 * @version: 1.0
 */


/**
 * 枚举类实现懒加载单例：
 * 不仅可以解决线程安全问题，还可以防止反序列化：
 * JVM会保证一个类的（）方法在多线程环境中被正确的加锁、同步，所以枚举实现实在实例化时，是线程安全的；
 * Java规范中规定，每一个枚举类型及其定义的枚举变量是唯一的，因为在枚举的序列化和反序列化上，Java做了特殊的规定：
 * 在序列化时，Java仅仅是将枚举对象的name属性输出到结果中，在反序列化时，则是通过java.lang.Enum的valueof()方法来根据名字查找枚举对象
 */
public enum Mgr08 {
    INSTANCE;
    String name="haha";
    public void m(){
        System.out.println("enum");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr08.INSTANCE.hashCode());
                INSTANCE.m();
                System.out.println(INSTANCE.name);
            }).start();
        }
    }


}

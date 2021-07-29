package com.zd.singleton;

/**
 * @author: Dong
 * @date: 2021/7/28 - 1:46
 * @Description: com.zd.singleton
 * @version: 1.0
 */

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用！
 * 唯一缺点：不管用到与否，类装载时都会完成实例化
 * Class.forName("")
 * (话说你不用的，你装载它干啥)
 * ---------------------------
 *Java类加载机制:
 * 类加载的时机
 * 隐式加载 new 创建类的实例,
 * 显式加载：loaderClass,forName等
 * 访问类的静态变量，或者为静态变量赋值
 * 调用类的静态方法
 * 使用反射方式创建某个类或者接口对象的Class对象。
 * 初始化某个类的子类
 * 直接使用java.exe命令来运行某个主类
 *
 */
public class Mgr01 {
    private static final Mgr01 INSTANCE=new Mgr01();
    private Mgr01(){}
    public static Mgr01 getInstance(){
        return INSTANCE;
    }
    void show(){
        System.out.println(INSTANCE.getClass().getName());
    }

    public static void main(String[] args) {
//    Mgr01 m1= new Mgr01().getInstance();
//    Mgr01 m2=new Mgr01().getInstance();
        Mgr01 m1 = Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
        System.out.println(m1==m2);
        m1.show();
    }
}

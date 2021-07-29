package com.zd.singleton;

/**
 * @author: Dong
 * @date: 2021/7/29 - 14:04
 * @Description: com.zd.singleton
 * @version: 1.0
 */

import sun.security.jca.GetInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 多个皇帝
 * List接收
 */
public class Emperor {
    private static final List<Emperor> emperorLists=new ArrayList<>();
    private static final List<String> nameList=new ArrayList<>();
    private static int maxEmperorNum=2;
    private static int countOfEmperor=0;
        static {
        for (int i = 0; i < maxEmperorNum; i++) {
            emperorLists.add(new Emperor("皇"+i+"帝"));
        }
    }
    private Emperor(String name){
        nameList.add(name);
    }
    public static Emperor getInstance(){
        Random random=new Random();
        countOfEmperor = random.nextInt(maxEmperorNum);
        return emperorLists.get(countOfEmperor);
    }
    public static void say(){
        System.out.println(nameList.get(countOfEmperor));
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                Emperor instance = Emperor.getInstance();
                System.out.println(instance.hashCode());
                instance.say();
            }).start();
        }
    }
}

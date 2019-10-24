package com.gn.stu.observer;

/**
 * @program stu
 * @description:
 * @author: gaoning
 * @create: 2019/08/19 15:13
 */
public class Main {

    public static void main(String[] args) {
        //被观察者
        ToBeObserver ob = new ToBeObserver();
        //添加观察者MyObserver
        ob.addObserver(new MyObserver());
        ob.setAge(19);
        ob.setAge(20);
    }
}

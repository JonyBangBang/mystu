package com.gn.stu.observer;

import java.util.Observable;

/**
 * @program stu
 * @description:
 * @author: gaoning
 * @create: 2019/08/19 15:11
 */
public class ToBeObserver extends Observable {
    private int age = 10;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        setChanged();
        System.out.println(hasChanged());
//        notifyObservers();
        notifyObservers(this);
    }
    public String toString(){
        return "年龄是："+this.age;
    }
}

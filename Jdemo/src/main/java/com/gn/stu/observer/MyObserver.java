package com.gn.stu.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @program stu
 * @description: 观察者
 * @author: gaoning
 * @create: 2019/08/19 15:09
 */
public class MyObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        ToBeObserver a = (ToBeObserver) o;
        System.out.println("改变了。。。"+((ToBeObserver) o).getAge());
        System.out.println(arg.toString());
    }
}

package com.gn.stu.athink;

/**
 * @program stu
 * @description:
 * @author: gaoning
 * @create: 2019/08/09 20:25
 */
public class Hello implements Runnable   {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        Thread.sleep(1000*100);
        System.out.println("sleep 100s ...");



    }

    @Override
    public void run() {

    }
}

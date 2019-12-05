package com.gn.stu.athink;

/**
 * @program mystu
 * @description: 可继承的ThreadLocal
 * @author: gaoning
 * @create: 2019/12/02 11:32
 */
public class InheritableThreadLocalDemo {

    public static void main(String[] args) {

        ThreadLocal  threadLocal = new ThreadLocal();
        threadLocal.set("threadLocal!");

        InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal();
        inheritableThreadLocal.set("inheritableThreadLocal!");

        new Thread(new Runnable() {
            InheritableThreadLocal inheritableThreadLocal2 = new InheritableThreadLocal();

            @Override
            public void run() {
                inheritableThreadLocal2.set("inheritableThreadLocal2!");
                System.out.println("1-threadLocal:"+threadLocal.get());
                System.out.println("1-inheritableThreadLocal:"+inheritableThreadLocal.get());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("2-threadLocal:"+threadLocal.get());
                        System.out.println("2-inheritableThreadLocal:"+inheritableThreadLocal.get());
                        System.out.println("2-inheritableThreadLocal-2:"+inheritableThreadLocal2.get());
                    }
                }).start();
            }
        }).start();
    }
}

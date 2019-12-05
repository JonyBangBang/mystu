package com.gn.stu.athink;

/**
 * @program mystu
 * @description: 线程AB控制
 * @author: gaoning
 * @create: 2019/11/30 21:58
 */
public class ABThreadContrl {
    private static final Object obj = new Object();
    private static int index = 1;
    private static boolean flag = false;

    class ThreadA implements Runnable{
        @Override
        public void run() {
            synchronized (obj){
                for(int i=0;i<50;i++){
                    while(flag){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+index++);
                    flag = true;
                    obj.notifyAll();
                }
            }
        }
    }
    class ThreadB implements Runnable{
        @Override
        public void run() {
            synchronized (obj){
                for(int i=0;i<50;i++){
                    while(!flag){
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+index++);
                    flag = false;
                    obj.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        ABThreadContrl abThreadContrl = new ABThreadContrl();
        ThreadA at = abThreadContrl.new ThreadA();
        ThreadB bt = abThreadContrl.new ThreadB();
        Thread a = new Thread(at,"ThreadA");
        Thread b = new Thread(bt,"ThreadB");
        a.start();
        b.start();
        System.currentTimeMillis();
    }
}

package com.gn.stu.athink;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program mystu
 * @description: use lock condition
 * @author: gaoning
 * @create: 2019/11/27 22:40
 */
public class ThreadContrlDemo2 {

    private static final Lock lock = new ReentrantLock();  //表示对象锁
    private static Condition con = lock.newCondition();

    private volatile int index = 1;//表示要输出的数字

    private volatile boolean aHasPrint = false;      //记录A是否被打印过

    class A implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                lock.lock();
                    while (aHasPrint) {//如果A已经打印过就进行阻塞
                        try {
                            con.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A:" + index);//A没有打印过则输出A的值
                    index++;//输出的值增加1
                    aHasPrint = true;//表示A已经打印过
                    con.signalAll();//唤醒其它线程执行
                lock.unlock();
            }
        }
    }

    class B implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                lock.lock();
                    while (!aHasPrint) {               //如果A没有打印过则阻塞
                        try {
                            con.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("B:" + index);//输出B的值
                    index++;//计数加一
                    aHasPrint = false;//B打印完了说明新的一轮开始了，将标识为计为A没有打印过
                    con.signalAll();//唤醒阻塞线程
               lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        ThreadContrlDemo2 solution2 = new ThreadContrlDemo2();
        Thread threadA = new Thread(solution2.new A());
        Thread threadB = new Thread(solution2.new B());
        threadA.start();
        threadB.start();
    }

}

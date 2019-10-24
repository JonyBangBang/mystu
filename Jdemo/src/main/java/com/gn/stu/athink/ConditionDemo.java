package com.gn.stu.athink;

import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @program stu
 * @description:
 * @author: gaoning
 * @create: 2019/08/08 21:30
 */
public class ConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        Executor exe = Executors.newCachedThreadPool();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            A a = new A();
            B b = new B();
            C c = new C();
            D d = new D();
            while(n-->0){
                Thread t1 = new Thread(a);
                t1.start();
                t1.join();
                Thread t2 = new Thread(b);
                t2.start();
                t2.join();
                Thread t3 = new Thread(c);
                t3.start();
                t3.join();
                Thread t4 = new Thread(d);
                t4.start();
                t4.join();
            }
        }
    }

  static  class A implements Runnable{
        @Override
        public void run() {
            System.out.print("A");
        }
    }
    static class B implements Runnable{
        @Override
        public void run() {
            System.out.print("B");
        }
    }
    static class C implements Runnable{

        @Override
        public void run() {
          System.out.print("C");
        }
    }
    static class D implements Runnable{
        @Override
        public void run() {
            System.out.print("D");
        }
    }
}

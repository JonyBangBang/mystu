package com.gn.stu.athink;

/**
 * @program Jdemo
 * @description:一个java类型存储的问题
 * @author: gaoning
 * @create: 2020/02/29 21:28
 */
public class AJavaQuestion {
    public static void f() {
        String[] a = new String[2];
        Object[] b = a;
        a[0] = "hi";
        b[1] = Integer.valueOf(142);
    }
    public static void main(String[] args) {
        f();
    }
}

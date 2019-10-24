package com.gn.stu.athink;

/**
 * @program stu
 * @description:
 * @author: gaoning
 * @create: 2019/08/18 17:27
 */
public class Singleton {
    /**
     * 类的初始化，
     * 1、编译，将java文件编译成class文件
     * 2、链接，将符号引用变成直接引用
     *     a,验证：验证字节码格式等等
     *     b,准备&解析：在java虚拟机加载class文件并且验证完毕之后，就会正式给类变量分配内存并设置类变量的初始值
     *      比如在 private static int i; 在执行准备阶段的时候，会给value分配内存并设置初始值0
     *
     * 3、初始化：将指定值附给属性变量
     *
     * 如下例子中输出：
     * Singleton.i=9
     * Singleton.j=8
     * com.gn.stu.athink.Singleton@681a9515
     * i=9
     * j=0
     * 当静态变量实例化按照从上到下的顺序
     * java会编译成静态变量表中，保证只被实例化一次；
     * 当静态变量定义之初未被初始化的时候，如下i变量的值在构造方法中被赋值一次，然后不会再次被实例化
     * 但是j的值在构造方法中被赋值一次，然后在静态变量初始化的时候又被赋值为0
     */

    private static Singleton singleton = new Singleton();

    private static int i;

    private static int j=0;

    public Singleton(){
        i+=9;
        j=8;
        System.out.println("Singleton.i="+i);
        System.out.println("Singleton.j="+j);
    }
    public static Singleton getInstance(){
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance());
        System.out.println("i="+Singleton.i);
        System.out.println("j="+Singleton.j);
    }
}

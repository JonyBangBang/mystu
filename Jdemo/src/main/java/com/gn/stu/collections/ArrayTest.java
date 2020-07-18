package com.gn.stu.collections;

import java.time.Instant;

/**
 * @program Jdemo
 * @description:
 * @author: gaoning
 * @create: 2020/03/17 10:41
 */
public class ArrayTest {
    public static void main(String[] args) {
        //sublist操作是list的视图
        /*List list = new ArrayList();
        for(int i=0;i<10;i++){
            list.add(i);
        }
        List list2 = list.subList(2,5);
        list2.add(11);
        System.out.println(list2.toString());
        System.out.printf(list.toString());*/

       /* String[] str = new String[] { "a", "b" };
        List list = Arrays.asList(str);
        //运行时异常 java.lang.UnsupportedOperationException
        list.add("c");
        System.out.printf(list.toString());*/

        System.out.printf(Instant.now().toString());
    }
}

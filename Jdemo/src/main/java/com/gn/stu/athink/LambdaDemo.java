package com.gn.stu.athink;

import java.util.ArrayList;
import java.util.List;

/**
 * @program mystu
 * @description: lambda表达式demo
 * @author: gaoning
 * @create: 2019/10/24 15:56
 */
public class LambdaDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        for(int i=0;i<10000000;i++){
            list.add(i);
        }
        long a = System.currentTimeMillis();
        int temp = list.get(0);

        for(int i=0;i<10000000-1;i++){
            if(temp < list.get(i+1)){
                temp = list.get(i+1);
            }
        }
        System.out.println(temp);
        //time1:22
        System.out.println("time1:"+(System.currentTimeMillis()-a));

        long b = System.currentTimeMillis();
        list.stream().max((i,j)->i.compareTo(j)).get();
        //time2:76
        System.out.println("time2:"+(System.currentTimeMillis()-b));
        //获取最大值
        System.out.println(list.stream().max((i,j)->i.compareTo(j)).get());
        //求和
        System.out.println(list.stream().mapToInt(Integer::intValue).sum());
        //平均值
        System.out.println(list.stream().mapToInt(Integer::intValue).average().getAsDouble());


    }
}

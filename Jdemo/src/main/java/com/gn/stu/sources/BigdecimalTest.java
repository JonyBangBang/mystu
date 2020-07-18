package com.gn.stu.sources;

import java.math.BigDecimal;

/**
 * @program Jdemo
 * @description:
 * @author: gaoning
 * @create: 2020/02/27 20:36
 */
public class BigdecimalTest {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(0.00);
        if(bigDecimal.floatValue()==0){
            System.out.println(true);
        }else {
            System.out.println(false);
        }

        System.out.println(bigDecimal.compareTo(new BigDecimal(0)));

    }
}

package com.gn.stu.athink;

import java.util.Arrays;

/**
 * @program mystu
 * @description: 冒泡排序
 * @author: gaoning
 * @create: 2019/11/27 10:47
 */
public class PopSort {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,7,6,5,8,9,100,23,45,10,16};
        for(int i=0;i<a.length;i++){
            for(int j=i;j<a.length;j++){
//                swap(a[i],a[j]);
                int temp;
                if(a[i]>a[j]){
                    temp = a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        System.out.print(Arrays.toString(a));
    }
}

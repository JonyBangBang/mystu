package com.gn.stu.athink;

import java.util.Arrays;

/**
 * @program mystu
 * @description: 两个有序数组合并
 * @author: gaoning
 * @create: 2019/10/31 16:39
 */
public class MergeArrays {
    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,7,8,8};
        int[] b = new int[]{2,5,7,9,10,12,14,23,61,77};
        int[] c = new int[a.length+b.length];
        int i= 0;
        int j= 0;
        int index = 0;
        while(i<a.length||j<b.length){
            if(a[i]>b[j]){
                c[index]=b[j];
                j++;
            }else{
                c[index]=a[i];
                i++;
            }
            index++;
            if(i>=a.length){
                for(int k=j;k<b.length;k++){
                    c[index++] = b[k];
                }
                break;
            }
            if(j>=b.length){
                for(int k=i;k<a.length;k++){
                    c[index++] = a[k];
                }
                break;
            }
        }
        System.out.println(Arrays.toString(c));
    }
}

package com.gn.stu.athink;

import java.util.*;

/**
 * @program stu
 * @description: 背包算法
 * @author: gaoning
 * @create: 2019/08/08 09:50
 */
public class ksnap {
    public static  void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //总钱数
            int totalMoney = sc.nextInt();
            //总商品数量
            int count = sc.nextInt();
            //商品价格
            int[] price = new int[count];
            //商品级别 1 2 3 4 5
            int[] level = new int[count];
            //商品类型 主 附
            int[] type = new int[count];
            //每个商品的期望值
            int[] weight = new int[count];
            for(int i=0;i<count;i++){
                price[i] = sc.nextInt();
                level[i] = sc.nextInt();
                weight[i] = price[i]* level[i];
                type[i] = sc.nextInt();
            }
            //在给定的资金下，求出最大期望值
            //新建一个期望值二维表
            int[][] wArr = new int[count+1][totalMoney+1];
            for(int k=1;k<=count;k++){
                for(int j=1;j<=totalMoney;j++){
                    //只购买主件
                    if(type[k-1]==0){
                        if(price[k-1]<=j){
                            wArr[k][j] = Math.max(wArr[k-1][j],wArr[k-1][j-price[k-1]]+weight[k-1]);
                        }
                    }//购买附件必须搭配主件
                    else{
                        if(price[k-1]+price[type[k-1]]<=j){
                            wArr[k][j] = Math.max(wArr[k-1][j],wArr[k-1][j-price[k-1]]+weight[k-1]);
                        }
                    }
                }
            }
            System.out.println(wArr[count][totalMoney]);
            for(int i=0;i<=count;i++){
                for(int j=0;j<=totalMoney;j++){
                    System.out.print(wArr[i][j]+" ");
                }
                System.out.print("\n");
            }
        }
    }
}

package com.gn.stu.athink;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program mystu
 * @description:
 * @author: gaoning
 * @create: 2019/12/01 13:55
 */
class MianClass{
    public  static List getMatchList(int[] candidates,int target){
        List resList = new ArrayList();
        List list = Arrays.asList(candidates);
        int max = getMax(candidates);
        int min = getMin(candidates);

        for(int i=0;i<candidates.length;i++){
            List oneList = new ArrayList();
            int startNum = candidates[i];
            int restNum = target-startNum;
            if(restNum < 0){
                break;
            }else{
                oneList.add(startNum);
            }
            out:for(int j=0;j<candidates.length;j++){
                if(candidates[j] <= restNum){
                    oneList.add(candidates[j]);
                    restNum = restNum - candidates[j];
                    if(restNum==0){
                        resList.add(oneList);
                        break out;
                    }else if(restNum<0){
                        continue;
                    }else{
                        if(restNum<min){
                            continue;
                        }
                        j--;
                    }
                }
            }

        }
        return resList;
    }
    public static int getMax(int[] a){
        int temp=0;
        for(int i=0;i<a.length-1;i++){
            if(a[i]>a[i+1]){
                temp = a[i];
            }else{
                temp = a[i+1];
            }
        }
        return temp;
    }
    public static int getMin(int[] a){
        int temp=0;
        for(int i=0;i<a.length-1;i++){
            if(a[i]<a[i+1]){
                temp = a[i];
            }else{
                temp = a[i+1];
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        int[] a = new int[]{2,3,5};
        int num = 8;
        System.out.println(getMatchList(a,num).toString());
    }
}

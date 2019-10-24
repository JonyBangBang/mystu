package com.gn.stu.athink;

import java.util.Scanner;

/**
 * @program stu
 * @description: 数字转人民币汉字
 * @author: gaoning
 * @create: 2019/08/08 15:55
 */
public class Rmb {
    final static String[] hanzi = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "拾" };
    static String[] danw = {"","元","拾","佰","仟","万","拾","佰","仟","亿","拾","佰","仟","兆","拾","佰","仟","吉"};
    static String[] danw2 = {"角","分",""};
    public static void  main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String sb = "";
            String s = sc.nextLine();
            String[] strArr;
            String intStr = "";
            String doubStr = "";
            if(s.contains(".")){
                strArr = s.split("\\.");
                intStr = strArr[0];
                doubStr = strArr[1];
            }else {
                intStr = s;
            }
            boolean getZero = false;
            if(intStr!=null&&!intStr.equals("")){
                long num = Long.parseLong(intStr);
                int j=0;
                while(num>0){
                    int i = (int)num%10;
                    int zeroSize = 0;
                    if(i!=0){
                        if ((j == 5) && (zeroSize >= 3)) {
                            sb=danw[6]+sb;
                        }
                        if ((j == 8) && (zeroSize >= 3)) {
                            sb+=danw[9];
                          }
                        sb = hanzi[i]+danw[j+1]+sb;
                        getZero = false;
                    }else{
                        if(!getZero){
                            sb = hanzi[i]+sb;
                        }
                        zeroSize++;
                        if (((j) % 4 == 0) && (num > 0)) {
                            sb=danw[j+1]+sb;
                        }
                        getZero = true;
                    }
                    j++;
                    num /=10;
                }
            }
            String doubs = "";
            if(doubStr!=null&&!doubStr.equals("")){
                char[] cdoub = doubStr.toCharArray();
                for(int i=0;i<cdoub.length;i++){
                    int num = cdoub[i]-'0';
                    if(num==0){
                        if(i==0){
                            doubs +=hanzi[num];
                        }else{

                        }
                    }else {
                        doubs +=hanzi[num]+danw2[i];
                    }

                }
            }
            if(sb.startsWith("壹拾")){
                sb = sb.substring(1);
            }
            System.out.println("人民币"+sb+doubs);
        }
    }
}

package com.gn.stu.athink;

import java.util.*;

/**
 * @program stu
 * @description:
 * @author: gaoning
 * @create: 2019/08/06 16:16
 */
public class StringLength {

    public static int getLastLength(String str){
        if(" ".equals(str)||null==str){
            return 0;
        }
        String[] res = str.split(" ");
        if(res==null||res.length<1){
            return 0;
        }
        int length = res.length;
        String lastStr = res[length-1];

        return lastStr.length();
    }
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()){
//            String str = sc.nextLine();
//            System.out.println(getLastLength(str));
//        }
//    }

    public static int getAlength(String str){
        String[] s = str.split("\n");
        return 0;
    }

//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
////        Scanner sc2 = new Scanner(System.in);
//        String str2 = sc.nextLine();
//        if(str == null ||str2 ==null){
//            return;
//        }
//        char[] char1 = str.toLowerCase().toCharArray();
//        char[] char2 = str2.toLowerCase().toCharArray();
//        int num = 0;
//        for(int i=0;i<char1.length;i++){
//            if(char2[0]==char1[i]){
//                num ++;
//            }
//        }
//        System.out.println(num);
//    }
//    public static void main(String[] args){
//
//            Scanner sc = new Scanner(System.in);
//            while(sc.hasNext()){
//                int n = sc.nextInt();
//                int[] arr = new int[n];
//                List intList = new ArrayList();
//                for(int i=0;i<n;i++){
//                    arr[i] = sc.nextInt();
//                    if(!intList.contains(arr[i])){
//                        intList.add(arr[i]);
//                    }
//                }
//                Object[] newArr = intList.toArray();
//                Arrays.sort(newArr);
//                for(int j=0;j<newArr.length;j++){
//                    System.out.println(newArr[j]);
//                }
//            }
//
//
//    }
    public static void splitStr(String s){
        if(s==null){
            return;
        }
        int length = s.length();
        if(length<8){
            int len = 8-length;
            for(int k=0;k<len;k++){
                s+="0";
            }
            System.out.println(s);
        }else{
            for(int i=0;i<length;i+=8){

                if(i+8<length){
                    String ss = s.substring(i,i+8);
                    System.out.println(ss);
                }else{
                    String s2 = s.substring(i,length);
                    int dl = s2.length();
                    int len = 8-dl;
                    for(int j=0;j<len;j++){
                        s2+="0";
                    }
                    System.out.println(s2);
                }

            }
        }
    }
//    Scanner scan=new Scanner(System.in);
//    ArrayList<String> set=new ArrayList<String>();
//    int num=scan.hasNextLine()?Integer.parseInt(scan.nextLine()):0;
//        while(--num>=0&&scan.hasNextLine()){
//        set.add(scan.nextLine());
//    }
//        Collections.sort(set);
//        for(String str:set){
//        System.out.println(str);
//    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            String[] arr = s.split(";");
            int x=0;
            int y=0;
            for(int i=0;i<arr.length;i++){
                String move = arr[i];
                int temp = 0;
                if(move!=null&&!move.equals("")){
                    try{
                        String ss = move.substring(1);
                        temp = Integer.valueOf(ss);
                    }catch(Exception e){

                    }
                    if(move.startsWith("A")){
                        x-=temp;
                    }else if(move.startsWith("D")){
                        x+=temp;
                    }else if(move.startsWith("W")){
                        y+=temp;
                    }else if(move.startsWith("S")){
                        y-=temp;
                    }else{

                    }
                }
            }
            System.out.println(x+","+y);
        }

    }

    public static void sortArray() {
        Scanner sc = new Scanner(System.in);
//        if (sc.hasNextLine()){
        int num = 0;
        if(sc.hasNext()){
            num = sc.nextInt();
        }
//        int num=sc.hasNextLine()?Integer.parseInt(sc.nextLine()):0;
        List list = new ArrayList();
        while(--num>=0&&sc.hasNextLine()){
            list.add(sc.nextLine());
        }
        Object[] strArr = list.toArray();
        Arrays.sort(strArr);
        for(int j=0;j<strArr.length;j++){
            System.out.println(strArr[j]);
        }
//        }
    }

    //求所有质因子
    public static void getZhishu(Scanner sc) {
        while(sc.hasNext()){
            long num = sc.nextLong();
            long num2 = (long)Math.sqrt(num)+1L;
            int i = 2;
            while(num!=1&&i<num2){
                if(num%i==0){
                    num/=i;
                    System.out.println(i);
                }else {
                    i++;
                }
            }
            if(i>num2-1){
                System.out.println(num);
            }
        }
    }

    /**
     * 16进制转10进制
     * @param sc
     */
    public static void hexToTen(Scanner sc) {
        while(sc.hasNext()){
            int sum = 0;
            String s1 = sc.nextLine();
            if(!s1.startsWith("0x")){
                return;
            }else{
                String s2 = s1.substring(2);
                char[] ca = s2.toCharArray();
                int len = s2.length();
                for(int i=0;i<len;i++){
                    if(ca[i]>='A'&&ca[i]<='F'){
                        sum+=(ca[i]-'A'+10)*Math.pow(16,len-i-1);
                    }else if(ca[i]>='a'&&ca[i]<='f'){
                        sum+=(ca[i]-'a'+10)*Math.pow(16,len-i-1);
                    }else{
                        sum+=(ca[i]-'0')*Math.pow(16,len-i-1);
                    }
                }
            }
            System.out.println(sum);
        }

    }
}

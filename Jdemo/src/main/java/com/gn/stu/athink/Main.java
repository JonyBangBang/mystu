package com.gn.stu.athink;

import java.util.*;

/**
 * @program stu
 * @description:
 * @author: gaoning
 * @create: 2019/08/08 22:22
 * 2019-01-01 08:59:00.123
 * 2019-01-01 08:59:00.123
 * 2018-12-28 10:08:00.999
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map map = new HashMap();
        Map map2 = new HashMap();
       getMap(sc,map,map2);
    }

    public static void getMap(Scanner sc, Map map, Map map2) {
        List<String> list = new ArrayList<String>();
        list.add("2019-01-01 08:59:00.100");
        list.add("2019-01-01 08:59:00.120");
        list.add("2019-01-01 08:59:00.123");
        list.add("2019-01-01 08:59:00.124");
        list.add("2018-12-28 10:08:00.999");
        list.add("2018-12-28 10:08:00.998");
        for(String s :list) {

            String sStart = s.substring(0, s.length() - 4);
            String sEnd = s.substring(s.length() - 3, s.length());
            if(!map2.containsKey(sStart)){
                map2.put(sStart,sEnd);
            }
            if (map.containsKey(sStart)) {
                int oldV = Integer.parseInt(String.valueOf(map2.get(sStart)));
                int intEnd = Integer.parseInt(sEnd);
                if (oldV > intEnd) {
                    map.put(sStart, 1);
                    map2.put(sStart,sEnd);
                } else if (oldV == intEnd) {
                    map.put(sStart, (int) map.get(sStart) + 1);
                }
            } else {
                map.put(sStart, 1);
            }
        }
        Collection col = map.values();
        int sum = 0;
        for(Object i:col){
            sum+=Integer.parseInt(i.toString());
        }
        System.out.println(sum);
    }
}

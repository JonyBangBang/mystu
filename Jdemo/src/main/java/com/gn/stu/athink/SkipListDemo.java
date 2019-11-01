package com.gn.stu.athink;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @program mystu
 * @description: 跳表demo
 * @author: gaoning
 * @create: 2019/10/29 15:00
 */
public class SkipListDemo {
    public static void main(String[] args) {
        ConcurrentSkipListMap skMap = new ConcurrentSkipListMap();
        for(int i=0;i<100;i++){
            skMap.put("key"+i,"value"+i);
        }
        System.out.println(skMap.toString());
    }
}

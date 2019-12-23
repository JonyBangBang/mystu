package com.gn.stu.leetcode;

/**
 * @program mystu
 * @description: 两个数相加
 * @author: gaoning
 * @create: 2019/12/20 16:04
 */
public class LeetCode {
    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        while(p1!=null||p2!=null){
            int x = p1!=null?p1.val:0;
            int y = p2!=null?p2.val:0;
            int sum = carry+x+y;
            carry = sum/10;
            cur.next = new ListNode(sum%10);

            cur = cur.next;
            if(p1 != null){
                p1 = p1.next;
            }
            if(p2 != null){
                p2 = p2.next;
            }

        }
        if(carry>0){
            cur.next = new ListNode(carry);
        }
        return res.next;
    }

    public static void main(String[] args) {
        LeetCode test = new LeetCode();
        ListNode l1 = new ListNode(1);
        ListNode l12= new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(6);
        l1.next = l12;
        l12.next = l13;
        l13.next = l14;
//        System.out.print("l1 ");
//        while(l1 != null){
//            System.out.println(l1.val);
//            l1 = l1.next;
//        }

        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(2);
        ListNode l22 = new ListNode(8);
//        ListNode l23 = new ListNode(6);
        l2.next = l21;
        l21.next = l22;
//        l22.next = l23;
//        System.out.print("l2 ");
//        while(l2 != null){
//            System.out.println(l2.val);
//            l2 = l2.next;
//        }
        ListNode res = test.addTwoNumbers(l1,l2);
        while(res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}

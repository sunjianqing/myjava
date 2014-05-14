package com.jianqing.interview.leetcode;

import java.util.List;

/**
 * Created by jianqsun on 5/12/14.
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null ){
            return head;
        }

        ListNode n1 = head;
        ListNode n2 = head.next;
        head = n2;

        while(n1 != null && n2 != null){



        }
        return head;
    }

    public static void main(String[] args){
        SwapNodesInPairs snip = new SwapNodesInPairs();
        snip.test();
    }

    public void test(){
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode head = new ListNode(1);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        swapPairs(head);
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}



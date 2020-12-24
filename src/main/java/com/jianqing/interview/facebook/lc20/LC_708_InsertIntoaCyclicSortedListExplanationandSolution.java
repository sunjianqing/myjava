package com.jianqing.interview.facebook.lc20;

import com.jianqing.interview.base.ListNode;

/**
 * 循环队列里 插入一个数
 *
 * 看看有几种情况
 *
 * 比最大值大
 * 比最小值小
 * 在最大最小值之间
 *
 * 所以 算法 是
 * 先找最大， 最小值，如果要插入的比max 大， 或者比 min 小， 直接在头部插入
 *
 * 否则循环找位置
 *
 */
public class LC_708_InsertIntoaCyclicSortedListExplanationandSolution {
    public ListNode insert(ListNode node , int v) {
        if(node == null) {
            ListNode res = new ListNode(v);
            res.next = res;
            return res;
        }

        // find max
        ListNode head = node;
        ListNode cur = node;
        int max = node.val;
        int min = node.val;
        while (cur.next != head) {
           cur = cur.next;
        }
        max = cur.val;

        // find min
        min = cur.next.val;
        if (v >= max || v <= min) {
            ListNode newNode = new ListNode(v);
            cur.next = newNode;
            return head;
        }
        else {
            // find position
            cur = head;
            while (cur.next != null && cur.next.val < v) {
                cur = cur.next;
            }
            ListNode newNode = new ListNode(v);
            newNode.next = cur.next;
            cur.next = newNode;
        }

        return head;

    }
}

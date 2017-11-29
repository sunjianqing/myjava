package com.jianqing.interview.leetcode17;

import com.jianqing.interview.base.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by jianqingsun on 11/4/17.
 */
public class lc_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val)
                    return -1;
                else if (o1.val == o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        for (ListNode node: lists) {
            if(node!= null)
                queue.add(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        dummy.next = queue.peek();
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null)
                queue.add(tail.next);
        }

        return dummy.next;

    }
}

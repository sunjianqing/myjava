package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.ListNode;

/**
 * Created by jianqingsun on 4/12/17.
 * 分别build left right part ，最后连起来
 */
public class PartitionList_86 {

    public ListNode partition(ListNode head, int x) {

        if (head == null)
            return head;

        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy ;
        ListNode right = rightDummy;

        while  ( head != null) {
            if(head.val < x) {
                left.next = head;
                left = head;
            }
            else {
                right.next = head;
                right = head;
            }

            head = head.next;
        }

        right.next = null;
        left.next = rightDummy.next;

        return leftDummy.next;


    }
}

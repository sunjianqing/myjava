package com.jianqing.interview.leetcode16;

import com.jianqing.interview.leetcode.ListNode;

/**
 * Created by jianqing_sun on 12/2/16.
 */
public class RemoveDuplicatesfromSortedList_83 implements Solution {
    @Override
    public void solution() {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode p1 = head, p2 = head;
        while(p2 != null){
            if(p2.val == p1.val){
                p2 = p2.next;
                p1.next = p2;
            }
            else {
                p1 = p2;
            }
        }

        return dummyNode.next;


    }
}

package com.jianqing.interview.leetcode16;

import com.jianqing.interview.leetcode.ListNode;

/**
 * Created by jianqingsun on 11/28/16.
 */
public class DeleteNodeinALinkedList_237 implements Solution {
    @Override
    public void solution() {

    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

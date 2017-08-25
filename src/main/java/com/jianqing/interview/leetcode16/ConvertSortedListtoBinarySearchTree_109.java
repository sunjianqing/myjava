package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.ListNode;
import com.jianqing.interview.base.TreeNode;

/**
 * Created by jianqing_sun on 3/30/17.
 * 快慢指针找到中点， 再recursive
 */
public class ConvertSortedListtoBinarySearchTree_109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return toBST(head, null);
    }

    public TreeNode toBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == tail) return null;

        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBST(head, slow);
        thead.right = toBST(slow.next, tail);
        return thead;
    }
}

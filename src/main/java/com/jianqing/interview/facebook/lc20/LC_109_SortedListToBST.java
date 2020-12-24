package com.jianqing.interview.facebook.lc20;

import com.jianqing.interview.base.ListNode;
import com.jianqing.interview.base.TreeNode;

public class LC_109_SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
      if (head == null) return null;

      ListNode pre = null ;
      ListNode slow = head;
      ListNode fast = head;

      while (fast != null && fast.next != null) {
          fast = fast.next.next;
          pre = slow;
          slow = slow.next;
      }

      TreeNode root = new TreeNode(slow.val);

      if (pre != null) {
          // 从中间断开
          pre.next = null;

          root.left = sortedListToBST(head);
          root.right = sortedListToBST(slow.next);
      }
      return root;

    }
}

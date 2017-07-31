package com.jianqing.interview.leetcode16;


import com.jianqing.interview.base.ListNode;

/**
 * Created by jianqingsun on 7/30/17.
 *
 *
 */
public class ReorderList_143 {
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);

        dummy.next = head;

        if(head == null || head.next == null)
            return;

        ListNode p1 = head;
        ListNode p2 = head.next;

        // Step 1 Find the middle one , if total number is odd, middle one is total/2 + 1 , 比如 5/2 + 1 = 3 第三个是中间的 不是数组的那个index 3
        // 1 -> 2 ->3 -> 4-> 5-> 6
        // 找到了3
        while(p2.next != null && p2.next.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }


        // Step 2 Reverse the half after middle
        // 1 -> 2 ->3 -> 6-> 5-> 4
        ListNode middleNode = p1;
        ListNode current = p1.next;
        ListNode preCurrent = null;
        while(current.next != null){
            ListNode tmp = current.next;
            current.next = preCurrent;
            preCurrent = current;
            current = tmp;
        }
        p1.next = current;

        // step 3 reorder one by one
        // 1 -> 6 ->2-> 5-> 3 -> 4
        ListNode p3 = head;
        ListNode p4 = p1.next;

        while(p3 != middleNode){
            ListNode tmp1 = p3.next;
            ListNode tmp2 = p4.next;

            p3.next = p4;
            p3 = tmp1;
            p4.next = tmp1;
            p4 = tmp2;
        }

        p3.next = p4;

    }
}

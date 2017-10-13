package com.jianqing.interview.leetcode17;

import com.jianqing.interview.base.ListNode;

/**
 * Created by jianqing_sun on 10/13/17.
 * <p>
 * Add Two Numbers
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class lc_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l1;
        if (l2 == null)
            return l2;

        ListNode dummuy = new ListNode(0);
        ListNode current = dummuy;
        int carry = 0;
        int v1,v2 =0;
        while (l1 != null || l2 != null) {
            if(l1 != null)
               v1 = l1.val;
            else
                v1 = 0;

            if(l2 != null)
                v2 = l2.val;
            else
                v2 = 0;

            int val = v1 + v2 + carry;

            carry = val / 10 ;

            val = val % 10;

            current.next = new ListNode(val);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            current = current.next;
        }

        if(carry > 0 ){
            current.next = new ListNode(carry);
        }

        return dummuy.next;



    }
}

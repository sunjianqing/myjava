package com.jianqing.interview.leetcode16;

import com.jianqing.interview.leetcode.ListNode;

/**
 * Created by jianqingsun on 3/13/17.
 */
public class InsertionSortList_147 {

    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode plast, pcurrent, pindex;
        plast = head;
        pcurrent = head.next;
        pindex = new ListNode(0);
        pindex = head ;

        int index = 0 ;


        while (pcurrent != null) {
            // find correct index
            int i = 0;
            while (i <= index){
                if(pcurrent.val < pindex.val){
                    plast.next = pcurrent.next;
                }
                else {
                    pindex = pindex.next;
                    i++;
                }
            }

        }

        return null;

    }
}

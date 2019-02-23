package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.ListNode;

/**
 * Created by jianqing_sun on 11/29/17.
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
                    ↘
                        c1 → c2 → c3
                    ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.

 */
public class IntersectionofTwoLinkedLists_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        int lenA = 0;
        int lenB = 0;

        ListNode tmpA = headA;
        ListNode tmpB = headB;


        while (tmpA != null) {
            lenA++;
            tmpA = tmpA.next;
        }

        while (tmpB != null) {
            lenB++;
            tmpB = tmpB.next;
        }

        if(lenA > lenB){
            int i = 1;
            while (i <= lenA - lenB){
                headA = headA.next;
                i++;
            }
        }
        else if(lenB > lenA) {
            int i = 1;
            while (i <= lenB - lenA){
                headB = headB.next;
                i++;
            }
        }


        while(headA != null && headB!= null ){
            if(headA == headB)
                return headA;

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}

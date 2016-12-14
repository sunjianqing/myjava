package com.jianqing.interview.leetcode16;

import com.jianqing.interview.leetcode.ListNode;

/**
 * Created by jianqingsun on 12/4/16.
 */
public class MergeTwoSortedLists_21 implements Solution {
    @Override
    public void solution() {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if ( l2 == null)
            return l1;

        ListNode head = null;
        if (l1.val > l2.val)
            head = l2;
        else
            head = l1;

        // 要保存住上一个结点的指针
        ListNode pre = new ListNode(0);
        pre.next = l1;
        while ( l1 != null && l2 != null){
            if(l1.val > l2.val){
                // l2 小， 就保存l2 的pre 指针
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            }
            else{
                // l1 小， 就保存l1 的pre 指针
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            }
        }

        // 一个list 遍历完了，用pre 把另一个剩下的连起来
        if(l1 != null)
            pre.next = l1;
        else
            pre.next = l2;


        return head;

    }
}

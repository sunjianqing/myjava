package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jianqing_sun on 6/29/17.
 */
public class MergeKSortedLists_23 {
    // Iterative 解法
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;

        List<ListNode> listNodes = Arrays.asList(lists);

        while(listNodes.size() > 1){
            List<ListNode> new_lists = new ArrayList<ListNode>();
            for ( int i = 0 ; i < listNodes.size() -1 ; i+=2){
                new_lists.add(mergeTwoList(listNodes.get(i), listNodes.get(i+1)));
            }
            // 以防最后一个落单
            if (listNodes.size() % 2 == 1) {
                new_lists.add(listNodes.get(listNodes.size() - 1));
            }
            listNodes = new_lists;
        }

        return listNodes.get(0);
    }

    private ListNode mergeTwoList(ListNode l1 , ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(l1 != null && l2 !=null){
            if(l1.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
            }
            else{
                tail.next = l2;
                l2 =  l2.next;
            }

            tail = tail.next;
        }

        if(l1 != null){
            tail.next = l1;
        }

        if(l2 != null){
            tail.next = l2;
        }

        return dummy.next;

    }
}

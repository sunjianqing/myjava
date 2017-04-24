package com.jianqing.interview.leetcode16;

import com.jianqing.interview.leetcode.ListNode;

/**
 * Created by jianqingsun on 3/13/17.
 */
public class InsertionSortList_147 {

    // 用这个算法
    // 算法其实是把原list 劈成了两半， 一半是排过序的 （最后一个元素的next 是null）， 另一半是以current 指针为head
    // 每次就把 current 元素加到已排好序的list 里， 这就跟insertion sort 的原理一样了
    public ListNode insertionSortList_2nd(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        // 注意 !!! 这里的dummy node 不用设定 dummy.head = head
        ListNode cur = head;

        //
        while (cur != null) {
            ListNode next = cur.next;
            ListNode pre = dummy;
            while (pre.next != null && pre.next.val < cur.val)
                pre = pre.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        InsertionSortList_147 ins = new InsertionSortList_147();
        ListNode head = new ListNode(5);
        ListNode node1 = new ListNode(6);
        head.next = node1;
        ListNode node2 = new ListNode(10);
        node1.next = node2;
        ListNode node3 = new ListNode(12);
        node2.next = node3;
        ListNode node4 = new ListNode(8);
        node3.next = node4;

        ins.insertionSortList_2nd(head);
    }
}

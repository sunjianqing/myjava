package com.jianqing.interview.leetcode16;

import com.jianqing.interview.leetcode.ListNode;

/**
 * Created by jianqing_sun on 6/19/17.
 * 这道题主要先理解题意，就是倒着数k个node，从那开始到结尾和之前那部分对调，那个例子就是，4->5拿前面来，1->2->3拿后面去。
 * <p>
 * 几个特殊：
 * <p>
 * k是可以大于整个list的长度的，所以这时要对k对len取模
 * <p>
 * 如果取模之后得0，相当于不用rotate，直接返回
 * <p>
 * 处理完特殊情况后，就用熟悉的faster/slower双指针解决就好（看到这种linkedlist，倒着数数的，就条件反射了）
 * <p>
 * 先对faster设步长为n，然后faster和slower再一起走，知道faster.next==null，说明slower指向要倒着数的开始点的前一个位置。
 * <p>
 * 所以slow.next就是要返回的newhead，保存一下。
 * <p>
 * 然后把faster.next接到head上，slower.next存为null，作队尾。
 * <p>
 * 这样就把list给rotate了。
 * <p>
 * 还有一种解法，还有一种就是把整个list连起来，变成环，找到切分点断开就行。
 */
public class RotateList_61 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        head.next = node;
        RotateList_61 rl = new RotateList_61();
        rl.rotateRight(head, 1);
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        ListNode cntNode = dummy;
        int len = 0;
        while (cntNode.next != null) {
            cntNode = cntNode.next;
            len++;
        }

        k = k % len ;
        if (k == 0) {
            return head;
        }

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode newHead = slow.next;
        fast.next = head;
        slow.next = null;
        return newHead;

    }
}

package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.ListNode;

import java.util.Random;

/**
 * Created by jianqingsun on 12/15/16.
 *
 * Follow up
 * 如果是未知长度的list，就用水塘抽样选，设定水塘size 为1
 */
public class LinkedListRandomNode_382 implements Solution {

    ListNode head;

    @Override
    public void solution() {

    }

    public LinkedListRandomNode_382 (ListNode h) {
        this.head = h;
    }

    /**
     * 水塘抽样 （Reservoir Sampling） 算法
     *
     */
    public int getRandom2() {
        int k = 0;
        ListNode node = head;
        int res = node.val;
        Random random = new Random();
        while (node != null) {
            k++;

            int r = random.nextInt(k);
            if (r == 0) { // 总是跟第0个元素换， 以1/k 概率
                res = node.val;
            }

            node = node.next;
        }
        return res;
    }


    /** Returns a random node's value. 暴力法*/
    public int getRandom() {
        int i = 0 ;
        ListNode pointer = head;
        while( pointer != null){
            i++;
            pointer = pointer.next;
        }

        Random random = new Random();
        int randomNum = random.nextInt(i);
        pointer = head;
        while ( randomNum >= 0){
            pointer = pointer.next;
            randomNum -- ;
        }
        return pointer.val;
    }
}

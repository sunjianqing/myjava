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

    ListNode node;

    @Override
    public void solution() {

    }

    /** Returns a random node's value. */
    public int getRandom() {
        int i = 0 ;
        ListNode pointer = node;
        while( pointer != null){
            i++;
            pointer = pointer.next;
        }

        Random random = new Random();
        int randomNum = random.nextInt(i);
        pointer = node;
        while ( randomNum >= 0){
            pointer = pointer.next;
            randomNum -- ;
        }
        return pointer.val;

    }
}

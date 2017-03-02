package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 1/22/17.
 */
public class GameofLife_289 implements Solution {
    @Override
    public void solution() {

    }

    /**
     * 状态机转化
     *
     0 : 上一轮是0，这一轮过后还是0
     1 : 上一轮是1，这一轮过后还是1
     2 : 上一轮是1，这一轮过后变为0
     3 : 上一轮是0，这一轮过后变为1

     这样，对于一个节点来说，如果它周边的点是1或者2，就说明那个点上一轮是活的。
     最后，在遍历一遍数组，把我们编码再解回去，即0和2都变回0，1和3都变回1，就行了。
     * @param board
     */
    public void gameOfLife(int[][] board) {

    }
}

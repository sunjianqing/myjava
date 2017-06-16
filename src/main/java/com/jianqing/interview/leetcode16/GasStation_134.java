package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 12/9/16.
 */
public class GasStation_134 implements Solution {
    @Override
    public void solution() {

    }
    /*
        See here
        http://bangbingsyb.blogspot.com/2014/11/leetcode-gas-station.html
        0. 如果对所有加油站的sum(gas[i] - cost[i])<0，则无解。否则进入1。

        1. 从0开始计算sum(gas[i] - cost[i])，当遇到i1使sum<0时，说明从0出发无法到达i1。
        根据性质1，0不是起始点。而由于从0出发已经到达了1 ~ i1-1。根据性质2，1 ~ i1-1一定不是正确的起始点。而且因为直到i1-1，sum都是大于0的，所以说明gas[i1] – cost[i1] 一定小于0，所以i1也不是start，所以start = i1 + 1 而不是start = i1

        2. 将sum清0，并从i1出发，假如又遇到i2使sum(gas[i] - cost[i]) < 0 时，说明i1出发无法绕一圈，更具性质1，排除i1。又因为i1+1 ~ i2-1都能从i1出发到达,。根据性质2，它们也必然不是起始点。此时i2为起始点的候选。而且因为直到i2-1，sum都是大于0的，所以说明gas[i2] – cost[i2] 一定小于0，所以i2也不是start，
        所以start = i2 + 1 而不是start = i2

        3. 以此类推，直到遇到ik，使从ik出发可以到达ik+1 ~ n-1。ik 就是解， 因为整个sum(gas[i] - cost[i]) 是正， 前面的几段都是负了，最后解这段ik到 n-1 ，就一定是正的， 并且能够抵消以前的负值， 使得整个和为正
     */

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int sum = 0;
        for ( int i = 0 ; i < gas.length ; i++){
            sum += gas[i] - cost[i];
        }
        if( sum < 0 )
            return -1;

        sum = 0;
        int target = 0;
        for ( int i = 0 ; i < gas.length ; i++){
            sum += gas[i] - cost[i];

            if(sum < 0 ){
                target = i+1;
                sum = 0;
            }
        }

        if(target < gas.length)
            return target;
        else
            return -1;
    }
}

package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 12/1/16.
 */
public class PowerOfThree_326 implements Solution {
    @Override
    public void solution() {

    }

    /**
     * 判断数字是否为3的幂
     * @param n
     * @return
     *
     * 有一种方法仅适用于判断数字是否为质数的幂。
     * 设有两个数字a和b，如果a是b的幂，那么只需要找到另外一个数x，
     * 满足x小于或等于Integer.MAX_VALUE，但x*b大于Integer.MAX_VALUE，
     * 如果a是b的幂，x%a一定是等于0的。Java语言中Integer的最大值是2147483647，
     * 大于3的19次幂为1162261467，小于3的20次幂3486784401。因此我们取1162261467作为这个数x
     */
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        } else {
            return n > 0 && 1162261467 % n == 0; //1162261467=3^19
        }
    }

    public boolean isPowerOfThree2(int n){
        if(n>1)
            while(n%3==0) n /= 3;
        return n==1;
    }

}

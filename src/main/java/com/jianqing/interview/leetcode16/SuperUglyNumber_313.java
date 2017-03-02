package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 1/20/17.
 */
public class SuperUglyNumber_313 implements  Solution {

    public static void main(String[] args) {
        SuperUglyNumber_313 sun = new SuperUglyNumber_313();

        sun.solution();
    }
    @Override
    public void solution() {
        this.nthSuperUglyNumber(20, new int[]{2,7,13,19});
    }

    /**
     * 其实是种动态规划的解法
     * 详情见
     * http://www.cnblogs.com/Liok3187/p/5016076.html
     * 
     * @param n
     * @param primes
     * @return
     */

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] times=new int[primes.length];
        int[] uglynumbers=new int[n];
        uglynumbers[0]=1;
        for(int i=1;i<n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                min=Math.min(min,primes[j]*uglynumbers[times[j]]);
            }
            uglynumbers[i]=min;
            for(int j=0;j<times.length;j++){
                if(primes[j]*uglynumbers[times[j]]==min){
                    times[j]++;
                }
            }
        }
        return uglynumbers[n-1];
    }
}

package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 3/7/18.
 * <p>
 * <p>
 * There are a row of n houses, each house can be painted with one of the three colors:
 * red, blue or green. The cost of painting each house with a certain color is different.
 *
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example,
 *
 * costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with
 * color green, and so on... Find the minimum cost to paint all houses.
 * costs[i][j]
 * i : house
 * j : color : 3
 */
public class PaintHouse_256 {

    public static void main(String[] args) {
        PaintHouse_256 ph = new PaintHouse_256();
        int[][] costs = {
            {1,2,4},
            {2,3,4},
            {2,3,4},
            {2,3,4},
            {2,3,4}
        };

        int res = ph.minCost(costs);
        System.out.println(res);
    }

    public int minCost(int[][] costs) {
        int n = costs.length;

        int[][] dp = new int[n][3];

        helper(dp, n-1, costs);
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }


    //Top Down
    private void helper(int[][] dp, int n, int[][] costs){
        if(n == 0){
            dp[0][0] = costs[0][0];
            dp[0][1] = costs[0][1];
            dp[0][2] = costs[0][2];
            return;
        }
        helper(dp, n-1, costs);
        dp[n][0] = costs[n][0] + Math.min(dp[n-1][1], dp[n-1][2]);
        dp[n][1] = costs[n][1] + Math.min(dp[n-1][0], dp[n-1][2]);
        dp[n][2] = costs[n][2] + Math.min(dp[n-1][0], dp[n-1][1]);

        return;
    }

    //Bottom up
    public int minCost2(int[][] costs) {
        if(costs==null||costs.length==0)
            return 0;

        for(int i=1; i<costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }

        int m = costs.length-1;
        return Math.min(Math.min(costs[m][0], costs[m][1]), costs[m][2]);
    }
}

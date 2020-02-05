package com.jianqing.interview.leetcode18;

/**
 * Number of Ways to Stay in the Same Place After Some Steps
 *
 * DP - Bottom Up
 *
 * 二维dp， 可以压缩空间到一维
 *
 * dp[i][j] 表示 有 i step ， 并且在 j 位置上 可以回到 0 点的可能次数
 * 然后想， dp[i][j] 往后退一步， 是怎么（从 i-1）转化来的，
 * 1)在 i -1 step 时 , 从第j-1 个位置右移 ,
 * 2)在 i -1 step 时， 从第 j+1 个位置左移
 * 3)在 i -1 step 时， 保持不动
 * so
 * dp[i][j] =  dp[i-1][j] + dp[i-1][j+1] + dp[i-1][j-1] // check boundary , 并且， i 也不能超过j/2 ， 不然一路向左回不去了
 */
public class lc_1269 {
}

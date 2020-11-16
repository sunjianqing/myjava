package com.jianqing.interview.leetcode18;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 属于 ISMP 问题
 * The interval scheduling maximization problem (ISMP) is to find a largest compatible set - a set of non-overlapping intervals of maximum size.
 * <p>
 * 找最小的 要remove 的区间， 也就是找最大的没重叠的区间
 * <p>
 * Input: [[1,2],[1,2],[1,2]]
 * Output: 2
 * <p>
 * 按interval ending 排序， loop interval ， 看当年interval 的starting 是不是比 最近一个留下的 ending 小， 如果小， 就是有重叠， 得remove 掉， 不小， 就保留
 * <p>
 * 这个贪心算法核心在， 贪心的选择interval 跨度小的， 给后面留下更多空间
 * 比如， 有
 * [1,3], [1,4], [1,5], [3,5]
 * 反正 [1,3], [1,4], [1,5] 得丢掉两个 ， 还不如丢[1,4],[1,5], 不然， 比如 不丢[1,4], 那后面的[3,5] 就得被丢了
 */
public class LC_435 {

    public static void main(String[] args) {
        int[][] itvls = new int[][]{{1, 2}, {1, 4}, {2, 3}};

        LC_435 lc = new LC_435();
        lc.eraseOverlapIntervals(itvls);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }

        int rvCnt = 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int[] currentItvl = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= currentItvl[1]) {
                currentItvl = intervals[i];
                continue;
            }
            rvCnt++;
        }
        return rvCnt;
    }

}


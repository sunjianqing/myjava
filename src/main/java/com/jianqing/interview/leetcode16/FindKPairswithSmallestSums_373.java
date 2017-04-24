package com.jianqing.interview.leetcode16;

import java.util.*;

/**
 * Created by jianqingsun on 4/23/17.
 *
 * 一种解法是把所有的组合都放到 heap里， 利用heap sort (priority queue) 选出最小的k个
 *
 * 另一种做法 还可以维护一个最小堆，每次取出堆顶的元素，然后把该元素相邻结点加入进去。这样能保证最小。这个方法同时要用m*n的数组记录访问过的结点
 * https://tenderleo.gitbooks.io/leetcode-solutions-/content/GoogleMedium/373.html
 */
public class FindKPairswithSmallestSums_373 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        List<int[]> res = new ArrayList<>();

        if (m == 0 || n == 0) {
            return res;
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] + o1[1] - o2[0] - o2[1]);
            }
        });

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                heap.add(new int[]{nums1[i], nums2[j]});
            }
        }

        while (!heap.isEmpty() && k > 0) {
            res.add(heap.poll());
            k--;
        }

        return res;

    }

    public static void main(String[] args) {
        FindKPairswithSmallestSums_373 fkp = new FindKPairswithSmallestSums_373();

        int[] nums1 = new int[]{1,2,4,5,6};
        int[] nums2 = new int[]{1,3,5,7,9};
        List<int[]> ints = fkp.kSmallestPairs(nums1, nums2, 3);
        Iterator<int[]> iterator = ints.iterator();
        while(iterator.hasNext()){
            int[] next = iterator.next();
            System.out.println(next[0] + "," + next[1]);
        }
    }
}

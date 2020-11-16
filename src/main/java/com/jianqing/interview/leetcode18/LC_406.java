package com.jianqing.interview.leetcode18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Queue Reconstruction by Height(Medium)
 *
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 *
 */
public class LC_406 {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> queue = new ArrayList<>();

        // 身高降序， 如果相等， 按照位置升序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                else {
                    return o2[0] - o1[0];
                }
            }
        });

        // 然后将某个学生插入队列的第 k 个位置中
        for (int[] p : people) {
            queue.add(p[1], p);
        }

        return queue.toArray(new int[queue.size()][]);
    }
}

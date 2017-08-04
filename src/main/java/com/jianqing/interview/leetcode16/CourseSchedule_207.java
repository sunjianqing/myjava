package com.jianqing.interview.leetcode16;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jianqingsun on 7/12/17.
 * BFS Toplogical 模板 拓扑排序模板
 */
public class CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];

        for (int i=0; i<prerequisites.length; i++) {
            int curr = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (graph[pre][curr] == 0)
                indegree[curr]++; //duplicate case
            graph[pre][curr] = 1; // 有边
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i=0; i<numCourses; i++) {
                if (graph[course][i] != 0) {  // 有边
                    if (--indegree[i] == 0)
                        queue.offer(i);
                }
            }
        }
        return count == numCourses;
    }
}

package com.jianqing.interview.leetcode16;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by jianqing_sun on 2/20/18.
 *
 * Grid 里的数字是 0 到n*n -1 的全排列
 * 这个特点就可以用二分搜索， 一直从(0,0)位置试探下去，每次试一个中值， 如果从(0,0) DFS 一路能到（路上所有的grid里面的值都小于中值），
 * 那就是一个解， 再降低high，再试，知道low >= high
 * 如果不是(0,0) DFS没有路径到终点， 那就得提高low的值，反正low 最大就是n*n - 1
 */
public class SwiminRisingWater_778 {
    public static void main(String[] args) {
        SwiminRisingWater_778 s = new SwiminRisingWater_778();

        int[][] grid =
                {
                    {0,13,20,19,15},
                    {24,23,22,21,5},
                    {18,12,1,4,16},
                    {17,11,14,3,2},
                    {10,9,8,7,6}
                };

        /*
            0  1  2  3  4
            24 23 22 21  5
            12 13 14 15 16
            11 17 18 19 20
            10  9  8  7  6
         */
        int i = s.swimInWater(grid);
        System.out.println("result is " + i);

    }

    public int swimInWater(int[][] grid) {
        int N = grid.length;
        int lo = grid[0][0], hi = N * N;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (!possible(mi, grid)) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo;
    }

    public boolean possible(int T, int[][] grid) {
        int N = grid.length;
        Set<Integer> seen = new HashSet();
        seen.add(0);
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};

        Stack<Integer> stack = new Stack();
        stack.add(0);

        while (!stack.empty()) {
            int k = stack.pop();
            int r = k / N, c = k % N;
            if (r == N-1 && c == N-1) return true;

            for (int i = 0; i < 4; ++i) {
                int cr = r + dr[i], cc = c + dc[i];
                int ck = cr * N + cc;

                if (0 <= cr && cr < N && 0 <= cc && cc < N
                        && !seen.contains(ck) ) {
                    System.out.println(cr + " " + cc);
                    if( grid[cr][cc] <= T){
                        seen.add(ck);
                        stack.add(ck);
                    }
                }
            }

        }

        System.out.println("======");

        return false;
    }
}

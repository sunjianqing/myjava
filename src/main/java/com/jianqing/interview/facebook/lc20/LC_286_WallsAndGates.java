package com.jianqing.interview.facebook.lc20;

/**
 * DFS
 * BFS
 *
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 *
 * output
 *
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 *
 */
public class LC_286_WallsAndGates {

    public static void main(String[] args) {
        LC_286_WallsAndGates s = new LC_286_WallsAndGates();
        int[][] rooms = new int[][]{{Integer.MIN_VALUE, -1, 0, Integer.MIN_VALUE},
                {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, -1},
                {Integer.MIN_VALUE, -1, Integer.MIN_VALUE, -1},
                {0, -1, Integer.MIN_VALUE, Integer.MIN_VALUE}};

        s.wallsAndGates(rooms);
        int m = rooms.length;
        int n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println("");
        }
    }


    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }

        int m = rooms.length;
        int n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    // go to update surrounding rooms
                    dfs(rooms, i, j, 0);
                }
            }
        }


    }


    public void dfs(int[][] rooms, int i, int j, int dist) {
        if(i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || (rooms[i][j] != Integer.MIN_VALUE && rooms[i][j] < dist)) {
            return;
        }
        rooms[i][j] = dist;
        dfs(rooms, i + 1, j, dist + 1);
        dfs(rooms, i - 1, j, dist + 1);
        dfs(rooms, i, j + 1, dist + 1);
        dfs(rooms, i, j - 1, dist + 1);

    }
}

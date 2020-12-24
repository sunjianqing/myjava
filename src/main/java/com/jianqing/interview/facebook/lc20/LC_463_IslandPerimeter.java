package com.jianqing.interview.facebook.lc20;

/**
 * 每次碰到1 ， 结果加4， 如果当前单元的上面是1， 那就是当前单元的上边跟它上面的单元的下边重合， 这两个都不是周长的边了，所以要减2
 * 如果当前单元的左面是1， 那就是当前单元的左border跟它左面的单元的右border重合， 这两个都不是周长的边了，所以要减2
 */
public class LC_463_IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0)  {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {

                    res += 4;
                    if (i - 1 >= 0 && grid[i-1][j] == 1) res -= 2;
                    if (j - 1 >= 0 && grid[i][j-1] == 1) res -= 2;
                }
            }
        }

        return res;
    }
}

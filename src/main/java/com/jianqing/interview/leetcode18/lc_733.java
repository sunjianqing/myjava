package com.jianqing.interview.leetcode18;

public class lc_733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) {
            return image;
        }

        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int startCol, int newColor) {
        if(sr < 0 || sc < 0 || sr > image.length - 1 || sc > image[0].length -1)
            return;

        if(image[sr][sc] == startCol)
            image[sr][sc] = newColor;
        else
            return;

        dfs(image, sr-1, sc, startCol, newColor);
        dfs(image, sr+1, sc, startCol, newColor);

        dfs(image, sr, sc-1, startCol, newColor);
        dfs(image, sr, sc+1, startCol, newColor);

    }
}

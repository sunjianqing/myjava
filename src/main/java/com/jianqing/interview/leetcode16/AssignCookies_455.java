package com.jianqing.interview.leetcode16;

import java.util.Arrays;

/**
 * Created by jianqing_sun on 11/22/16.
 */
public class AssignCookies_455 implements Solution{
    @Override
    public void solution() {
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{2,2,3};

        this.findContentChildren(g,s);
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j =0;
        int cnt = 0;
        while(i<g.length && j < s.length){
            if(s[j] >= g[i]){
                cnt++;
                i++;
                j++;
            }
            else {
                j++;
            }
        }

        return cnt;
    }
}

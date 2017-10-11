package com.jianqing.interview.leetcode17;

/**
 * Created by jianqing_sun on 10/9/17.
 */
public class lc_657 {
    public static void main(String[] args) {
        lc_657 lc = new lc_657();
        boolean ud = lc.judgeCircle("UD");
        System.out.println(ud);

    }
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;

        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    y += 1;
                    break;
                case 'D':
                    y -= 1;
                    break;
                case 'R':
                    x += 1;
                    break;
                case 'L':
                    x -= 1;
                    break;
            }

        }

        if (x == 0 && y == 0)
            return true;
        else
            return false;
    }
}

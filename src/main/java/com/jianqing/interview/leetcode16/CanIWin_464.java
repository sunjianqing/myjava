package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianqing_sun on 6/20/17.
 */
public class CanIWin_464 {
    public static void main(String[] args) {
        CanIWin_464 ciw = new CanIWin_464();
        ciw.canIWin(5, 11);
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal)
            return true;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= maxChoosableInteger; i++) {
            list.add(i);
        }
        return helper(list, true, desiredTotal);
    }

    public boolean helper(List<Integer> list, boolean win, int remaining) {
        if (list.isEmpty())
            return false;

        if (findMatch(list, remaining)) {
            return !win;
        }

        for (int i = 0; i < list.size(); i++) {
            Integer removeEle = list.remove(i);
            if (helper(list, !win, remaining - removeEle) == win)
                return false;
            list.add(removeEle);
        }

        return true;
    }

    private boolean findMatch(List<Integer> list, int target) {
        for (Integer i : list) {
            if (i >= target)
                return true;
        }
        return false;
    }
}

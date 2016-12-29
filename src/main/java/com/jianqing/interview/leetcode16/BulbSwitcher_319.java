package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 12/23/16.
 */
public class BulbSwitcher_319 implements Solution {
    @Override
    public void solution() {

    }

    /*
     列举之后发现只有平方数会导致最后的灯是亮的
     比如当n为36时，它的因数有(1,36), (2,18), (3,12), (4,9), (6,6), 可以看到前四个括号里成对出现的因数各不相同，
     括号中前面的数改变了灯泡状态，后面的数又变回去了，等于锁的状态没有发生变化，只有最后那个(6,6)，在次数6的时候改变了一次状态，
     没有对应其它的状态能将其变回去了，所以锁就一直是打开状态的。所以所有平方数都有这么一个相等的因数对，即所有平方数的灯泡都将会是打开的状态。
     */
    public int bulbSwitch(int n) {
        Double sqrt = Math.sqrt(n);
        return sqrt.intValue();
    }
}

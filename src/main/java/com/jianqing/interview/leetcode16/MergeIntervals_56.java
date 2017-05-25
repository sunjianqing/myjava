package com.jianqing.interview.leetcode16;

import util.Interval;

import java.util.*;

/**
 * Created by jianqingsun on 4/27/17.
 */
public class MergeIntervals_56 {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1)
            return intervals;

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start)
                    return o1.end - o2.end;
                else
                    return o1.start - o2.start;
            }
        });

        List<Interval> list = new ArrayList<>();
        Interval pre = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start <= pre.end) {
                if (cur.end > pre.end) {
                    pre.end = cur.end;
                }
            } else {
                list.add(pre);
                pre = cur;
            }
        }

        list.add(pre);

        return list;

    }

    public static void main(String[] args) {
        MergeIntervals_56 mi = new MergeIntervals_56();
        List<Interval> intervals = Arrays.asList(new Interval(1, 4), new Interval(5, 6));
        mi.merge(intervals);
    }

}

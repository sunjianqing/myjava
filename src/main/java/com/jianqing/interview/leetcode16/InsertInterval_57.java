package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.Interval;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jianqingsun on 7/19/17.
 */
public class InsertInterval_57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            result.add(intervals.get(i++));

        // merge all overlapping intervals to one considering newInterval
        // 一直找到一个interval 的起点大于 newInterval 的终点 ， 也就是说把前面起点小于newInterval 的都merge 到一起了
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval( // we could mutate newInterval here also
                    Math.min(newInterval.start, intervals.get(i).start),
                    Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        result.add(newInterval); // add the union of intervals we got

        // add all the rest
        while (i < intervals.size()) result.add(intervals.get(i++));

        return result;
    }
}

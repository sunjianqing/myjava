package com.jianqing.interview.leetcode16;

import com.jianqing.interview.base.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by jianqingsun on 1/25/17.
 */
public class MeetingRooms_252 {

    public boolean canAttendMeetings(Interval[] intervals) {

        if (intervals.length == 0)
            return false;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        if (intervals.length == 1)
            return true;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end)
                return false;
        }

        return true;

    }


}

package com.jianqing.interview.leetcode16;

import util.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by jianqing_sun on 1/25/17.
 */
public class MeetingRoomsII_253 {
    // http://www.jyuan92.com/blog/leetcode-meeting-rooms-ii/
    public int minMeetingRoomsWithConstantSpace(Interval[] intervals) {
        if (null == intervals || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        int minRoom = 1;
        queue.offer(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < queue.peek()) {
                minRoom++;
            } else {
                queue.poll();
            }
            queue.offer(intervals[i].end);
        }
        return minRoom;
    }

    public int solution(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(intervals[0].end);
        int roomCnt = 1;
        for (int i = 1; i < intervals.length - 1; i++) {
            Integer itvl = queue.peek();
            if(intervals[i].start < itvl){
                roomCnt++;
            }
            else{
                queue.poll();
            }
            queue.offer(intervals[i].end);

        }
        return roomCnt;
    }
}

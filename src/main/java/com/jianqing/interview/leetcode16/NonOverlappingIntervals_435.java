package com.jianqing.interview.leetcode16;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by jianqingsun on 12/20/16.
 */
public class NonOverlappingIntervals_435 implements Solution {

    public static void main(String[] args) {
        NonOverlappingIntervals_435 nonOverlappingIntervals_435 = new NonOverlappingIntervals_435();
        nonOverlappingIntervals_435.solution();
    }
    @Override
    public void solution() {
        Interval[] intervals  = new Interval[5];
        Interval interval0 = new Interval(7,9);
        Interval interval2 = new Interval(2,3);
        Interval interval3 = new Interval(5,8);
        Interval interval4 = new Interval(3,5);
        Interval interval1 = new Interval(1,4);
        intervals[0] = interval0;
        intervals[1] = interval1;
        intervals[2] = interval2;
        intervals[3] = interval3;
        intervals[4] = interval4;

        int i = this.eraseOverlapIntervals(intervals);

        System.out.println("result is " + i );

    }

    public int eraseOverlapIntervals(Interval[] intervals) {
        // 按照起始位置进行排序
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int count=0,j=0;
        // 贪心法，如果上一个位置j和当前位置i冲突了，那么进行判断，如果当前位置的末尾小于上一个边界的末尾，
        // 那么删除上一个位置（因为覆盖的更少，每步选择最有可能不造成重复的），
        // 反之如果当前位置尾部覆盖的更多，那么就删除i的位置。删除的方式通过控制j的取值进行
        for(int i=1;i<intervals.length;i++) {
            if(intervals[j].end>intervals[i].start){
                if(intervals[i].end < intervals[j].end){
                    System.out.println("delete interval [" + intervals[j].start + "," + intervals[j].end + "]");
                }
                else{
                    System.out.println("delete interval [" + intervals[i].start + "," + intervals[i].end + "]");
                }
                j=intervals[i].end<intervals[j].end?i:j;

                count++;
            }else
                //没有重复
                j=i;

        }
        return count;

    }

     class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
}

package com.jianqing.interview.google;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jianqing_sun on 2/7/17.
 * <p>
 * Given a < b , you can only apply +1, -1, *2 , how many mininum steps convert a to b
 *
 * Solution 1 : BFS every level
 * Solution 2: DP
 *  每次求 solution(b-1) , solution(b/2) ， solution((b+1)/2 + 2) 中最小的那个，建个一维的dp数组， 一路从a求上去
 *  (b+1)/2 这种情况要加2， 因为相当于a*2 - 1
 */
public class ConvertAToB {
    public static void main(String[] args) {
        ConvertAToB c = new ConvertAToB();
        int steps = c.solution(10, 17);
        System.out.println("need " +  steps +" steps ");
    }

    public int solution(int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        int times = 0;
        while (!queue.isEmpty()) {
            times++;
            Queue<Integer> tmp = new LinkedList<>();
            boolean found = false;
            while (!queue.isEmpty()) {
                Integer e = queue.poll();
                if (e * 2 == b) {
                    found = true;
                } else {
                    tmp.add(e * 2);
                }

                if (e + 1 == b) {
                    found = true;
                } else {
                    tmp.add(e + 1);
                }

                if (e - 1 == b) {
                    found = true;
                } else {
                    tmp.add(e - 1);
                }
            }
            if ( found )
                break;
            queue.addAll(tmp);
        }

        return times;
    }

}

package com.jianqing.interview.facebook.lc20;

import java.util.Arrays;

/**
 * Greedy
 * <p>
 * CPU 分配
 * 每个相同task之间至少相隔两个slot
 * <p>
 * 拥有最大频率的task的频率是k，
 * 理论值 (k-1)*(n+1) + p , p是跟k有相同频率的task的数量
 */
public class LC_621_TaskScheduler {

    public static void main(String[] args) {
        LC_621_TaskScheduler lc = new LC_621_TaskScheduler();
        int cnt = lc.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B' }, 2);
        System.out.println(cnt);
    }
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        Arrays.sort(freq);

        int len = tasks.length;

        int mostFreq = freq[25];
        int numTasksWithSameMaxFreq = 0;
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == mostFreq) {
                numTasksWithSameMaxFreq++;
            } else {
                break;
            }
        }

        return Math.max(len, (mostFreq - 1) * (n + 1) + numTasksWithSameMaxFreq);
    }

}



package com.jianqing.interview.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianqing_sun on 8/2/17.
 */
public class TaskCoolDown {

    public static void main(String[] args) {
        TaskCoolDown tcd = new TaskCoolDown();
        String solution = tcd.solution(new Character[]{'A', 'B', 'C', 'A', 'A', 'B'}, 3);
        System.out.println(solution);

    }

    public String solution(Character[] tasks, int cooldown) {
        if (tasks == null || tasks.length == 0) {
            return "";
        }

        // 记录task 最后出现的index
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tasks.length; i++) {
            if (!map.containsKey(tasks[i])) {
                map.put(tasks[i], i);
                sb.append(tasks[i]);
            } else {
                // i - last index of task i
                if (i - map.get(tasks[i]) > cooldown) {
                    sb.append(tasks[i]);
                } else {
                    int j = i;
                    while (j - map.get(tasks[i]) <= cooldown) {
                        sb.append("-");
                        j++;
                    }
                    sb.append(tasks[i]);
                }
                map.put(tasks[i], i);
            }

        }

        return sb.toString();
    }
}

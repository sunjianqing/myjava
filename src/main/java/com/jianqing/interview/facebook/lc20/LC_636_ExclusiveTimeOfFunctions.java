package com.jianqing.interview.facebook.lc20;

import java.util.List;
import java.util.Stack;

/**
 * 用Stack
 * https://youtu.be/fdtKNK_etJw
 *
 * 注意 同一个function 可以被recursive的 call 很多次，比如
 * Input: n = 1,
 * logs = ["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
 *
 */
public class LC_636_ExclusiveTimeOfFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];

        if (logs == null || logs.isEmpty()) {
            return res;
        }

        String[] info = logs.get(0).split(":");

        int id = Integer.valueOf(info[0]);
        int pre = Integer.valueOf(info[2]);
        Stack<Integer> stack = new Stack<>();
        stack.push(id);


        for (int i = 1; i < logs.size(); i++) {
            String[] curInfo = logs.get(i).split(":");

            int curId = Integer.valueOf(curInfo[0]);
            String curStatus = curInfo[1];
            int time = Integer.valueOf(curInfo[2]);

            if (curStatus.equals("start")) {
                if(!stack.isEmpty()) {
                    int lastId = stack.peek();
                    res[lastId] += time - pre;
                }
                pre = time;
                stack.push(curId);
            }
            else {
                int last = stack.pop(); // 这里run 完了， 需要pop
                res[last] += time - pre + 1;
                pre = time + 1;
            }
        }

        return  res;
    }
}
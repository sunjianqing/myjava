package com.jianqing.interview.leetcode16;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianqingsun on 5/31/17.
 */
public class RestoreIPAddresses_93 {

    public static void main(String[] args) {
        String s = "1111";
        System.out.println(s.substring(3, 4));

//        RestoreIPAddresses_93 ri = new RestoreIPAddresses_93();
//        List<String> strings = ri.restoreIpAddresses("1111");
//        System.out.println(StringUtils.join(strings, '\n'));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> finalRes = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return finalRes;
        }

        List<String> current = new ArrayList<>();
        dfs(0, s, finalRes, current);
        return finalRes;
    }

    public void dfs(int start, String s, List<String> finalRes, List<String> current) {

        if (start == s.length() && current.size() == 4) {
            String ip = join(current);
            finalRes.add(ip);
            return;
        }

        if (current.size() > 4)
            return;

        if (start > s.length())
            return;

        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length())
                break;
            String subStr = s.substring(start, start + i);
            if (subStr.startsWith("0") && i > 1)
                return;

            if (Integer.valueOf(subStr) < 256) {
                current.add(subStr);
                dfs(start + i, s, finalRes, current);
                current.remove(current.size() - 1);
            }

        }

        return;
    }

    private String join(List<String> current) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < current.size(); i++) {
            sb.append(current.get(i));
            sb.append(".");
        }

        return sb.substring(0, sb.length() - 1).toString();
    }
}

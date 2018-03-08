package com.jianqing.interview.leetcode16;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jianqing_sun on 3/2/18.
 * <p>
 * There is a box protected by a password. The password is n digits, where each letter can be one of the first k digits 0, 1, ..., k-1.
 * <p>
 * You can keep inputting the password, the password will automatically be matched against the last n digits entered.
 * <p>
 * For example, assuming the password is "345", I can open it when I type "012345", but I enter a total of 6 digits.
 * <p>
 * Please return any string of minimum length that is guaranteed to open the box after the entire string is inputted.
 * <p>
 * Example 1:
 * Input: n = 1, k = 2
 * Output: "01"
 * Note: "10" will be accepted too.
 * Example 2:
 * Input: n = 2, k = 2
 * Output: "00110"
 * Note: "01100", "10011", "11001" will be accepted too.
 * Note:
 * n will be in the range [1, 4].
 * k will be in the range [1, 10].
 * k^n will be at most 4096.
 * <p>
 * De Bruijn Sequence
 * 如果不会， 就DFS. 解的总长度是 pow(k,n) + n - 1
 * 图中每个节点是上个节点的最后n-1位， 加上一个新的
 * 比如在n = 3, k = 2 的情况下， 上个节点是 010, 下个就可能是 100 或 111
 */
public class CrackingTheSafe {

    public static void main(String[] args) {
        CrackingTheSafe c = new CrackingTheSafe();
        c.solution(4, 3);

    }

    public String solution(int n, int k) {
        double totalLen = Math.pow((double) k, (double) n) + n - 1;
        StringBuilder sb = new StringBuilder(n);

        // initialize sb
        int i = 0;
        while (i < n) {
            sb.append('0');
            i++;
        }

        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());

        if (dfs(sb, totalLen, n, k, visited)) {
            return sb.toString();
        }

        return "";

    }

    private boolean dfs(StringBuilder sb, double len, int n, int k, Set<String> visited) {
        if (((double) (sb.length())) == len) {
            return true;
        }

        String suffix = sb.substring(sb.length() - n + 1, sb.length());
        for (int c = 0; c < k; c++) {
            String s = suffix + String.valueOf(c);
            if(!visited.contains(s)){
                visited.add(s);
                sb.append(String.valueOf(c));
                if(dfs(sb, len, n, k, visited)){
                    // 不用出栈了， 直接返回
                    return true;
                }

                sb.deleteCharAt(sb.length()-1);
                visited.remove(s);
            }
        }

        return false;
    }
}

package com.jianqing.interview.leetcode16;

/**
 * Created by jianqing_sun on 8/22/17.
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 6.     312211
 * 7.     13112221
 */
public class CountAndSay_38 {
    public static void main(String[] args) {
        CountAndSay_38 cs = new CountAndSay_38();
        String s = cs.countAndSay(7);
        System.out.println(s);
    }

    public String countAndSay(int n) {
        String s = "1";
        while (n-- > 1) {
            StringBuilder next = new StringBuilder(); /* invariant: contain cnt-say before cur */
            int cnt = 1;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i - 1) == s.charAt(i)) {
                    cnt++;
                } else {
                    next.append(cnt).append(s.charAt(i-1));
                    cnt = 1;
                }
            }
            next.append(cnt).append(s.charAt(s.length() - 1 ));

            s = next.toString();
        }
        return s;
    }

}

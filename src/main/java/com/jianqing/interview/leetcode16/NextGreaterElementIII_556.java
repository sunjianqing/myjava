package com.jianqing.interview.leetcode16;

/**
 * Created by jianqingsun on 5/24/17.
 */
public class NextGreaterElementIII_556 {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);

        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = len - 1; i > 0; ) {
            if (s.charAt(i - 1) - s.charAt(i) >= 0) {
                i--;
            } else {
                int j = i;
                // 从i-1 之后找最后一个大于 s[i-1] 的数， 取代它， 然后 reverse digits from i to len-1
                for (; j < len;) {
                    if (s.charAt(j) - s.charAt(i - 1) > 0) {
                        j++;
                    }
                    else
                        break;
                }

                char c = chars[j-1];
                chars[j-1] = chars[i-1];
                chars[i-1] = c;

                int p = i;
                int q = len - 1;
                while (p < q) {
                    c = chars[p];
                    chars[p] = chars[q];
                    chars[q] = c;
                    p++;
                    q--;
                }

                if( Long.valueOf(String.valueOf(chars)) > Integer.MAX_VALUE )
                    return -1;
                else
                   return Integer.valueOf(String.valueOf(chars));

            }
        }

        return -1;
    }
}

package com.jianqing.interview.company.other;

import java.util.HashMap;
import java.util.Map;

/**
 * 两个指针，如果碰见重复的，就把快指针move 回慢，清空map，重新开始
 *
 * 下面这个算法，不是太好理解
 * https://www.baeldung.com/java-longest-substring-without-repeated-characters
 * 它有一句
 * if (visited.containsKey(currChar)) {
 *  start = Math.max(visited.get(currChar)+1, start); // 这里的取最大值不好理解，意思是，有新的start后，
 *  再碰见这个start前面已经出现的字符，还是保持start的当前值，不要更新
 *  比如
 *  acbeabe  ,当start 指向第二个a (start = 4)的时候， 再看见b，不要更新start
 * }
 */
public class FindtheLongestSubstringwithoutRepeatingCharacters {

    public static void main(String[] args) {
        FindtheLongestSubstringwithoutRepeatingCharacters s = new FindtheLongestSubstringwithoutRepeatingCharacters();
        String res = s.longestStr("acbeabe");
        System.out.println(res);
    }

    public String longestStr(String s) {
        if (s == null || s.length()  == 0) return "";

        Map<Character, Integer> map = new HashMap<>();

        String res = "";
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                    j = map.get(s.charAt(i)) + 1;
                    // clear the map
                    map.clear();
                    i = j;
            }

            if (i - j + 1 > res.length()) {
                res = s.substring(j, i+1);
            }

            map.put(s.charAt(i), i);
        }
        return res;
    }
}

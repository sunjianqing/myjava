package com.jianqing.interview.leetcode16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jianqingsun on 6/20/17.
 * 双指针 , 发现重复，移动慢指针， 直到发现重复字符， 再往前一格，继续移快指针， 直到发现重复
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        if (s.length() == 1)
            return 1;
        char[] arr = s.toCharArray();
        int p1 = 0;
        int p2 = 1;
        int max = 1;
        Set<Character> set = new HashSet<>();
        set.add(arr[0]);

        for (p2 = 1; p2 < arr.length; p2++) {
            if (set.contains(arr[p2])) {
                while(p1<p2){
                    set.remove(arr[p1]);
                    if(arr[p1] == arr[p2]){
                        break;
                    }
                    p1++;
                }
                p1++;
                set.add(arr[p2]);
            }
            else{
                set.add(arr[p2]);
                max = Math.max(max, p2 - p1 + 1);
            }
        }
        return max;
    }

    // Others Using HashSet
    public int solution2(String s){
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }

    // Others Using HashMap
    public int solution3(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

}

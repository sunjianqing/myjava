package com.jianqing.interview.facebook.lc20;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Sliding window
 * 有个模板
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
 * <p>
 * public class Solution {
 * public List<Integer> slidingWindowTemplateByHarryChaoyangHe(String s, String t) {
 * //init a collection or int value to save the result according the question.
 * List<Integer> result = new LinkedList<>();
 * if(t.length()> s.length()) return result;
 * <p>
 * //create a hashmap to save the Characters of the target substring.
 * //(K, V) = (Character, Frequence of the Characters)
 * Map<Character, Integer> map = new HashMap<>();
 * for(char c : t.toCharArray()){
 * map.put(c, map.getOrDefault(c, 0) + 1);
 * }
 * //maintain a counter to check whether match the target string.
 * int counter = map.size();//must be the map size, NOT the string size because the char may be duplicate.
 * <p>
 * //Two Pointers: begin - left pointer of the window; end - right pointer of the window
 * int begin = 0, end = 0;
 * <p>
 * //the length of the substring which match the target string.
 * int len = Integer.MAX_VALUE;
 * <p>
 * //loop at the begining of the source string
 * while(end < s.length()){
 * <p>
 * char c = s.charAt(end);//get a character
 * <p>
 * if( map.containsKey(c) ){
 * map.put(c, map.get(c)-1);// plus or minus one
 * if(map.get(c) == 0) counter--;//modify the counter according the requirement(different condition).
 * }
 * end++;
 * <p>
 * //increase begin pointer to make it invalid/valid again
 * // while(counter == 0 // counter condition. different question may have different condition )
 * {
 * <p>
 * //        char tempc = s.charAt(begin);//***be careful here: choose the char at begin pointer, NOT the end pointer
 * //        if(map.containsKey(tempc)){
 * //        map.put(tempc, map.get(tempc) + 1);//plus or minus one
 * //        if(map.get(tempc) > 0) counter++;//modify the counter according the requirement(different condition).
 * //        }
 * //
 * //        save / update(min/max) the result if find a target
 * //        // result collections or result int value
 * //
 * //        begin++;
 * //        }
 * //        }
 * //        return result;
 * //        }
 * //        }
 */
public class LC_438_FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if (t.length() > s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();

        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;


        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1); // 可以持续减下去， 小于0也没事， 说明当前窗口里， 这个字符富余了
                if (map.get(c) == 0) counter--;
            }
            end++;

            while (counter == 0) { // counter 不等于0 之前，window size 都在增加 !!, counter 等于0了， 知道那个window size 里可能有解
                char tempc = s.charAt(begin);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {
                        counter++;
                    }
                }
                // window 正好等于 t 的长度
                if (end - begin == t.length()) {
                    result.add(begin);
                }
                begin++;
            }

        }
        return result;
    }

}

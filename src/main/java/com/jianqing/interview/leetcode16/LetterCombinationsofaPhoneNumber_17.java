package com.jianqing.interview.leetcode16;

import java.util.*;

/**
 * Created by jianqing_sun on 3/30/17.
 */
public class LetterCombinationsofaPhoneNumber_17 {

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber_17 l = new LetterCombinationsofaPhoneNumber_17();
        l.letterCombinations("23");
    }

    // 最优解
    public List<String> letterCombinations2(String digits) {
        LinkedList<String> res = new LinkedList<String>();
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (res.peek().length() == i) { // 只care 当前长度 i ， 不停的remove 后， peek 长度就不是i了, 也就可以退出while
                String t = res.remove();
                for (char s : mapping[x].toCharArray())
                    res.add(t + s); // 加入下一轮
            }
        }
        return res;
    }


    public List<String> letterCombinations(String digits) {

        Map<Character, List<Character>> dict = new HashMap<>();

        dict.put('2', Arrays.asList('a', 'b', 'c'));
        dict.put('3', Arrays.asList('d', 'e', 'f'));
        dict.put('4', Arrays.asList('g', 'h', 'i'));
        dict.put('5', Arrays.asList('j', 'k', 'l'));
        dict.put('6', Arrays.asList('m', 'n', 'o'));
        dict.put('7', Arrays.asList('p', 'q', 'r', 's'));
        dict.put('8', Arrays.asList('t', 'u', 'v'));
        dict.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        StringBuffer sb = new StringBuffer();
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        helper(0, digits, dict, sb, res);

        return res;
    }

    // exponent 指数级解法 dfs
    public void helper(int index, String digits, Map<Character, List<Character>> dict, StringBuffer sb, List<String> res) {

        if (index == digits.length()) {
            res.add(new String(sb.toString()));
            return;
        }

        char c = digits.charAt(index);
        if (dict.containsKey(c)) {
            List<Character> clist = dict.get(c);
            for (int i = 0; i < clist.size(); i++) {
                sb.append(clist.get(i));
                helper(index + 1, digits, dict, sb, res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return;

    }

    // 二刷
    public List<String> letterCombinations20(String digits) {

        if(digits == null || digits.length() == 0)
            return new ArrayList<>();

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        dfs(digits, res, 0, sb);
        return res;
    }

    public void dfs(String digits, List<String> res, int start, StringBuilder sb) {
        List<String> dicts = Arrays.asList(new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"});
        if (start == digits.length()) {
            res.add(sb.toString());
            return;
        }


        int num = Character.getNumericValue(digits.charAt(start));
        String cur = dicts.get(num);

        for (int j = 0; j < cur.length(); j++) {
            sb.append(cur.charAt(j));
            dfs(digits, res, start+1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

}

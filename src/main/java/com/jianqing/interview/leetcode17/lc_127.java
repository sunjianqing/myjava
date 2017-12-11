package com.jianqing.interview.leetcode17;

import java.util.*;

/**
 * Created by jianqing_sun on 11/14/17.
 */
public class lc_127 {
    public static void main(String[] args) {
        lc_127 l = new lc_127();

        // a, c, [a, b, c]
//        int i = l.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
        int i = l.ladderLength("a", "c", Arrays.asList("a","b","c"));

        System.out.println(i);
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null) {
            return 0;
        }

        if (beginWord.equals(endWord)) {
            return 1;
        }

        Set<String> dict = new HashSet<>(); // 优化用的

        for (String w : wordList) {
            dict.add(w);
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(beginWord);
        visited.add(beginWord);

        int len = 1;
        while (!queue.isEmpty()) {
            len++;

            int size = queue.size();
            while(size > 0){
                String w = queue.poll();
                char[] chars = w.toCharArray();
                for (int i = 0; i < w.length(); i++) {
                    // change 1 character
                    char c = w.charAt(i);
                    for (int j = 0; j < 26; j++) {
                        char newc = (char) (j + 'a');
                        if(newc != c){
                            chars[i] = newc;
                            String tmp = new String(chars);

                            if(visited.contains(tmp)){
                                continue;
                            }

                            if(dict.contains(tmp)){
                                if(tmp.equals(endWord))
                                    return len;
                                queue.add(tmp);
                                visited.add(tmp);
                            }

                        }
                    }
                    chars[i] = c;

                }
                size--;
            }

        }

        return 0;

    }
}

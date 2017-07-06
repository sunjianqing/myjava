package com.jianqing.interview.leetcode16;

import java.util.*;

/**
 * Created by jianqing_sun on 6/23/17.
 * 分层 BFS， 直到找到endword
 */
public class WordLadder_127 {
    public static void main(String[] args) {
        WordLadder_127 wl = new WordLadder_127();
        wl.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log"));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null) {
            return 0;
        }

        if (beginWord.equals(endWord)) {
            return 1;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> dict = new HashSet<>(); // 优化用的

        for (String w : wordList) {
            dict.add(w);
        }

        queue.offer(beginWord);
        visited.add(beginWord);

        int len = 1;
        while (!queue.isEmpty()) {
            len++;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String word = queue.poll();

                for (int j = 0; j < word.length(); j++) {
                    // get next word

                    char[] oldChars = word.toCharArray();
                    char old = oldChars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != old) {
                            oldChars[j] = c;
                            String nextWord = new String(oldChars);

                            if (visited.contains(nextWord)) {
                                continue;
                            }

                            if (dict.contains(nextWord)) { // 也可以wordList.contains
                                if (nextWord.equals(endWord))
                                    return len;

                                visited.add(nextWord);
                                queue.offer(nextWord);
                            }

                        }
                    }
                    oldChars[j] = old;
                }
            }
        }

        return 0;

    }
}

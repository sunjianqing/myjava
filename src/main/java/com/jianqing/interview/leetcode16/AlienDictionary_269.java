package com.jianqing.interview.leetcode16;

import java.util.*;

/**
 * Created by jianqingsun on 8/15/17.
 * https://discuss.leetcode.com/topic/28308/java-ac-solution-using-bfs
 * http://www.cnblogs.com/jcliBlogger/p/4758761.html
 * <p>
 *
 *  You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language.
 *  收到的单词数组是外星语言有序的，所以要两两比较，确定图上边的指向
 *
 * build graph , then topological sort
 */
public class AlienDictionary_269 {
    public String alienOrder(String[] words) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Set<Character>> graph = new HashMap<>();

        // degree
        int[] inDegree = new int[26];

        // build graph
        buildGraph(words, graph, inDegree);

        // topological sort
        String order = topologicalSort(graph, inDegree);
        return order.length() == graph.size() ? order : "";
    }

    // build 图的时候， 顺便存了一份inDegree
    private void buildGraph(String[] words, Map<Character, Set<Character>> graph, int[] inDegree) {
        for (String w : words) {
            for (char c : w.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String first = words[i-1];
            String second = words[i];

            int length = Math.min(first.length(), second.length());

            for (int j = 0; j < length; j++) {
                char parent = first.charAt(j);
                char child = second.charAt(j);

                if (parent != child) {
                    if (!graph.get(parent).contains(child)) {
                        graph.get(parent).add(child);
                        inDegree[child - 'a']++;
                    }
                    break; // 一旦有不一样的， 后面就不用比了 ！
                }
            }
        }
    }

    private String topologicalSort(Map<Character, Set<Character>> graph, int[] inDegree) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new ArrayDeque<>();

        for (char c : graph.keySet()) {
            if (inDegree[c - 'a'] == 0) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);

            for (char neighbor : graph.get(c)){
                inDegree[neighbor - 'a']--;
                if (inDegree[neighbor - 'a'] == 0){
                    queue.offer(neighbor);
                }
            }
        }

        return sb.toString();
    }

}

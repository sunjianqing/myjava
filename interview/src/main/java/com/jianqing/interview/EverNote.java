package com.jianqing.interview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by jianqsun on 5/13/14.
 */
public class EverNote {
    public LinkedList<String> solution(String str, int n){
        LinkedList<String> wordList = new LinkedList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        PriorityQueue priorityQueue = new PriorityQueue(n,);

        return wordList;
    }

    private class Node {
        public int cnt;
        public String value;
    }

    private class myComparable<Node> implements Comparable<Node>{

        @Override
        public int compareTo(Node o) {
            return 0;
        }
    }
}

package com.jianqing.interview;

import java.util.*;

/**
 * Created by jianqsun on 5/15/14.
 * The algorithm is using the hashmap to record the frequency of the words,
 * then use the priority queue maintain the highest k words.
 * The final output are elements order by the priority in the priority queue
 */
public class EverNote {
    public LinkedList<String> solution(String str, int n){
        LinkedList<String> wordList = new LinkedList<String>(); // this is the final output
        Map<String, Integer> map = new HashMap<String, Integer>(); // hashmap is used to track the frequency

        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(n);
        //priorityqueue is used to keep the n words which have largest frequency.

        if(str != null){
            for(String s : str.split("[\\s\\,\\.\\\"\\\']+")){ // you can add more punctuation to the regex
                Node node;
                if(map.containsKey(s)){
                    //if word already exists, increase the hash value.
                    int cnt = map.get(s)+1;
                    node = new Node(map.get(s)+1, s);
                    map.put(s, cnt);
                }
                else{
                    node = new Node(1, s);
                    map.put(s, 1);
                }

                Node existingNode = new Node(node.cnt-1, s);
                if(priorityQueue.contains(existingNode)){
                    priorityQueue.remove(existingNode); // replace the existing node with the new one
                }

                priorityQueue.offer(node);

                if(priorityQueue.size() > n){
                    priorityQueue.poll();
                }
            }

            while (priorityQueue.size()>0){
                wordList.offer(priorityQueue.poll().value);
            }


            //reverse the list
            int i=0;
            int j=wordList.size()-1;
            while(i<j){
                String tmp = wordList.get(i);
                wordList.set(i, wordList.get(j));
                wordList.set(j, tmp);
                i++;
                j--;
            }
        }

        return wordList;
    }

    public class Node implements Comparable{

        private int cnt;
        private String value;

        public Node(int nodeCnt, String nodeValue){
            cnt = nodeCnt;
            value = nodeValue;
        }

        @Override
        public boolean equals(Object node){
            //this is used to compare the node in the priority queue
            return this.value.equals(((Node)node).value) && this.cnt == ((Node)node).cnt;
        }

        @Override
        public int compareTo(Object o) {
            Node node = (Node)o;
            return Integer.compare(cnt, node.cnt);
        }
    }

    public static void main (String[] args){
        EverNote en = new EverNote();
        LinkedList<String> list = en.solution("Evernote is a suite of software and services designed for notetaking and archiving. A \"note\" can be a piece of formatted text, a full webpage or webpage excerpt, a photograph, a voice memo, or a handwritten \"ink\" note. Notes can also have file attachments. Notes can be sorted into folders, then tagged, annotated, edited, given comments, searched and exported as part of a notebook.\n" +
                "\n" +
                "Evernote supports a number of operating system platforms (including OS X, iOS, Chrome OS, Android, Microsoft Windows, Windows Phone, BlackBerry, and webOS) and also offers online synchronisation and backup services.\n" +
                "\n" +
                "Founded by Stepan Pachikov, the Evernote web service launched into open beta on June 24, 2008[2] and reached 11 million users in July 2011.[3] In October 2010, under the present CEO Phil Libin, the company raised a US$ 20 million funding round led by DoCoMo Capital with participation from Morgenthaler Ventures and Sequoia Capital.[4] Since then, the company has raised an additional US$50 million in funding led by Sequoia Capital and Morgenthaler Ventures,[5] and another US$70 million in funding led by Meritech Capital and CBC Capital.[6] On November 30, 2012, Evernote raised another US$85 million, in funding led by AGC Equity Partners/m8 Capital and Valiant Capital Partners.[7] Cumulative Financing by all above fundings is US$225 million." , 5);
        System.out.println(list);
    }
}

package com.jianqing.interview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: jianqsun
 * Date: 11/20/13
 * Time: 6:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class LongestConsecutive {
    public void solution(int[] num){
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();

        for(int i = 0; i < num.length; i++){
            hashmap.put(num[i],i);
        }

        int maxlength = 0;

        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        for( int i = 0; i < num.length; i++ ){
            int j = num[i];
            int k = num[i];
            LinkedList<Integer> currentLinkedList = new LinkedList<Integer>();
            currentLinkedList.add(j);
            int currentmMaxLength = 1;

            while(hashmap.containsKey(j+1)){
                currentLinkedList.offerLast(j+1);
                currentmMaxLength ++ ;
                hashmap.remove(j+1);
                j++;
            }
            while(hashmap.containsKey(k - 1)){
                currentLinkedList.offerFirst(k - 1);
                currentmMaxLength ++;
                hashmap.remove(k-1);
                k--;
            }

            if(currentmMaxLength > maxlength)
            {
                maxlength = currentmMaxLength;
                linkedList = (LinkedList<Integer>) currentLinkedList.clone();
            }

            currentLinkedList.clear();

        }

        System.out.println("The length is "+ String.valueOf(maxlength));
        Iterator<Integer> it = linkedList.iterator();
        while (it.hasNext()){
            System.out.print(it.next() + ",") ;
        }
    }

    public static void main(String[] args){
        LongestConsecutive lc = new LongestConsecutive();
        int[] data = new int[]{100,2,200,3,4,132, 101,102};
        lc.solution(data);

    }

}

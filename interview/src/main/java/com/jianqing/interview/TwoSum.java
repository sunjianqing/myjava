package com.jianqing.interview;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: jianqsun
 * Date: 12/15/13
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class TwoSum {

    public void solution(int[] arr, int sum){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0 ; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }
            else
                map.put(arr[i], 1);
        }

        for(int i=0;i<arr.length;i++){
            if(map.containsKey(sum-arr[i])){
                if(arr[i] == sum-arr[i] && map.get(arr[i]) < 2){
                    continue;
                }
                System.out.print("Found pair: ");
                System.out.print(arr[i]);
                System.out.print(",");
                System.out.print(sum-arr[i]);
                System.out.println();
                map.remove(sum-arr[i]);
                map.remove(arr[i]);
            }
        }
    }

    public static void main (String[] args){
        int[] a = new int[]{2,3,4,1,6,7,5};
        int sum = 8;
        TwoSum ts = new TwoSum();
        ts.solution(a, 8);
    }
}

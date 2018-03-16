package com.jianqing.interview.company;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by jianqingsun on 3/9/18.
 */
public class Adobe {

    /*
        Sorted Array , find occurrences
        1. given a sorted integer array
        {1,1,1,1,1,2,2,5,5,5,5,8,8,8,9,9}
        output occurrences
        {1,5}
        {2,2}
        {5,4}
        {8,3}
        {9,2}
        2. number of unique value is k  k < 10
        3. size of the array is n

        less than O(n)
     */

    public static void main(String[] args) {
        Adobe adobe = new Adobe();
        adobe.solution(new int[]{1,1,1,1,1,2,2,5,5,5,5,8,8,8,9,9});
    }
    public void solution(int[] nums){

        Map<Integer, Integer> map =  new TreeMap<>();

        // binary search
        search(0, nums.length-1, map, nums);

        // print out result
        int pre = -1;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int occur = entry.getValue() - pre;
            System.out.println("value " + entry.getKey() + " freq " + occur);
            pre = entry.getValue();
        }
    }

    private void search(int start, int end, Map<Integer, Integer>  map, int[] nums){
        if(start > end){
            return;
        }

        int mid = start + (end - start)/2;

        if(nums[start] == nums[mid]) {
            map.put(nums[mid], mid);
            search(mid+1, end, map, nums);
            return;
        }
        else if(nums[mid] == nums[end]){
            map.put(nums[mid], end);
            search(start, mid-1, map, nums);
            return;
        }
        else{
            map.put(nums[mid], mid);

            search(start, mid-1, map, nums);
            search(mid+1, end, map, nums);
        }

    }

}

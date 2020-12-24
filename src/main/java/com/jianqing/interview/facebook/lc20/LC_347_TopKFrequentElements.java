package com.jianqing.interview.facebook.lc20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 桶排序
 */
public class LC_347_TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        // build bucket
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();
            int num = entry.getKey();

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<Integer>();
            }

            bucket[freq].add(num);
        }

        List<Integer> res = new ArrayList<>();
        // loop from the top frequent element
        for (int f = bucket.length - 1; res.size() < k && f >=0 ; f--) {
            if(bucket[f] != null) {
                res.addAll(bucket[f]);
            }
        }

        int[] resArray = res.stream().mapToInt(i->i).toArray();
        return resArray;
    }

}

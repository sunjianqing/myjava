package com.jianqing.interview.facebook.lc20;

import java.util.HashMap;
import java.util.Map;

public class LC_ReorganizeString {
    public String reorganizeString(String S) {

        if (S == null || S.length() == 0) {
            return "";
        }


        Map<Character, Integer> map = new HashMap();

        int max = 0;
        char maxChar = 0;

        for (int i = 0; i < S.length(); i++) {
            char tmp = S.charAt(i);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            if (map.get(tmp) > max) {
                maxChar = tmp;
                max = map.get(tmp);
            }
        }

        if (map.get(maxChar) > (S.length() + 1) / 2) return "";

        // add maxChar to 0,2,4...
        int idx = 0;
        int n = S.length();
        char[] res = new char[n];
        while (max > 0) { // 把 最大的char 填上
            res[idx] = maxChar;
            idx += 2;
            max --;
        }
        map.remove(maxChar);

        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            for (int j = 0; j < entry.getValue(); j++) {
                if(idx >= n) idx = 1; // 这里比较关键， 如果最大的char没有把0,2,4...全部填满 （整个的一半）,
                // index可以继续往前走，直到第一次到头，以后再填所有奇数位置
                res[idx] = entry.getKey();
                idx += 2;
            }
        }

        return new String(res);

    }

}

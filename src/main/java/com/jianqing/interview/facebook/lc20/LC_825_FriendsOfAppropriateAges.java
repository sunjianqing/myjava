package com.jianqing.interview.facebook.lc20;

import java.util.HashMap;
import java.util.Map;

/**
 * Friends Of Appropriate Ages
 */
public class LC_825_FriendsOfAppropriateAges {

    public int numFriendRequests(int[] ages) {

        if (ages == null || ages.length == 0) {
            return 0;
        }

        Map<Integer, Integer> ageMap = new HashMap<>();

        for (int age : ages) {
            ageMap.put(age, ageMap.getOrDefault(age, 0) + 1);
        }

        int res = 0;
        for (int a1 : ageMap.keySet()) {
            for (int a2 : ageMap.keySet()) {
                if (isValid(a1, a2)) {
                    int cnt1 = ageMap.get(a1);
                    int cnt2 = ageMap.get(a2);
                    if (a1 == a2) {  // 因为年龄相等的时候， 自己跟自己不能make request
                        res += cnt1 * (cnt2 - 1);
                    }
                    else {
                        res += cnt1 * cnt2;
                    }
                }
            }
        }


        return res;
    }

    private boolean isValid(int a1, int a2) {
        if (0.5 * a1 + 7 >= a2) {
            return false;
        }
        else if (a2 > a1) {
            return false;
        }
        else {
            return true;
        }
    }

}

package com.jianqing.interview.facebook.lc20;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * You are given some lists of regions where the first region of each list includes all other regions in that list.
 *
 * Naturally, if a region X contains another region Y then X is bigger than Y. Also by definition a region X contains itself.
 *
 * Given two regions region1, region2, find out the smallest region that contains both of them.
 *
 * If you are given regions r1, r2 and r3 such that r1 includes r3, it is guaranteed there is no r2 such that r2 includes r3.
 *
 * It's guaranteed the smallest region exists.
 *
 * Example 1:
 *
 * Input:
 * regions = [["Earth","North America","South America"],
 * ["North America","United States","Canada"],
 * ["United States","New York","Boston"],
 * ["Canada","Ontario","Quebec"],
 * ["South America","Brazil"]],
 * region1 = "Quebec",
 * region2 = "New York"
 * Output: "North America"
 * Constraints:
 *
 * 2 <= regions.length <= 10^4
 * region1 != region2
 * All strings consist of English letters and spaces with at most 20 letters.
 *
 * 其实就是个树， 找最小公共祖先
 * 可以build 一个从child指向parent的map
 * 然后build 从region1 有个路径一直到root
 * 最后找regions2 回root的路径什么时候最早的交集
 *
 */
public class LC_1257_SmallestCommonRegion {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        HashMap<String, String> hm = new HashMap<>();
        for(List<String> item : regions){
            String parent = item.get(0);
            for(int i = 1; i<item.size(); i++){
                hm.put(item.get(i), parent);  // 指向parent 的 pointer
            }
        }

        // loop region1 回root 的路径
        HashSet<String> used = new HashSet<>();
        while(region1 != null){
            used.add(region1);
            region1 = hm.get(region1);
        }

        // 拿 region2 去验证
        while(!used.contains(region2)){
            region2 = hm.get(region2);
        }

        return region2;
    }
}

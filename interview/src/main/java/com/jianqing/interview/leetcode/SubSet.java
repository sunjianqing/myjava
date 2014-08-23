package com.jianqing.interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jianqsun on 8/6/14.
 */
public class SubSet {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        public List<List<Integer>> subsets(int[] s) {
            if(s == null || s.length== 0) return res;
            Arrays.sort(s);
            List<Integer> list = new ArrayList<Integer>();
            dfs(list,0,0,s);
            return res;
        }
        private void dfs(List<Integer> list,int k,int count,int[] s){
            if(count > s.length) return;
            if(count <= s.length){
                res.add(new ArrayList<Integer>(list));
            }
            for(int i = k; i < s.length; i++){
                list.add(s[i]);
                dfs(list,i + 1,count+1,s);
                list.remove(list.size() - 1);
            }
        }

        public static void main(String[] args){
            int[] data  = new int[]{1,2,3};
            SubSet ss = new SubSet();
            ss.subsets(data);


        }


}

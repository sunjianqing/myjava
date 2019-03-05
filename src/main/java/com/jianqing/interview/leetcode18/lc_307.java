package com.jianqing.interview.leetcode18;

/**
 * Range Sum Query - Mutable
 */
public class lc_307 {

    BinaryIndexTree tree = new BinaryIndexTree();
    int[] arr = null;
    public lc_307(int[] nums) {
        arr = nums;
        tree.buildTree(nums);
    }

    public void update(int i, int val) {
        int delta = val - arr[i];
        arr[i] = val;
        tree.update(i+1, delta);
    }

    public int sumRange(int i, int j) {
        return tree.rangeSum(i , j);
    }

    public static void main(String[] args){
       int[] arr = new int[]{1,3,5};

       lc_307 code = new lc_307(arr);

       System.out.println(code.sumRange(0,2));

    }
}

/*
                    8
                /  /  /
               /  /  /
              4  6  7
            / / /
           2 3 5
          /
         1


*/
class BinaryIndexTree {

    int[] tree = null;

    void buildTree(int[] arr){

        int n = arr.length;
        tree = new int[n + 1];

        /* 对数组中每一个元素， 累加上去, 比如，arr[0] (第一个)元素要加到tree[] 的 1，2，4，8 上
            arr第3个元素要加到4 和 8 上
            因为 11 lowbit 是 1 , 所以， 11+01  -> 100， 100 的lowbit 是 100, 所以， 100+100 -> 1000
        */
        for(int i = 1; i < n+1; i++){
            update(i, arr[i-1]);
        }
    }

    void update(int i, int delta){
        while(i < tree.length){
            tree[i] += delta;
            i = i + lowbit(i);
        }

    }

    //最有一个1 的位置， 其后置0
    int lowbit(int x){
        return (x & (-x));
    }

    // prefix sum 前i项和 (包含i)， 比如 i = 5 (101), 就先拿tree[5] 的值， 然后， 101-001 = 100,
    // 再拿前4项和， 已经存在tree[4]
    int query(int i) {
        int sum = 0;

        while(i > 0){
            sum += tree[i];
            i = i - lowbit(i);
        }

        return sum;
    }

    int rangeSum(int start, int end) {
        return query(end+1) - query(start);
    }
}


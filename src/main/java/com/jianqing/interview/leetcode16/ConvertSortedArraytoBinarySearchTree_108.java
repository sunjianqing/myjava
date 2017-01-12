package com.jianqing.interview.leetcode16;

import com.jianqing.interview.leetcode.TreeNode;

/**
 * Created by jianqingsun on 12/29/16.
 */
public class ConvertSortedArraytoBinarySearchTree_108 implements Solution {
    @Override
    public void solution() {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return BuildTree(nums, 0, nums.length-1);
    }

    private TreeNode BuildTree(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = (int) Math.ceil((end - start) / 2.0) + start;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = BuildTree(nums, start, mid - 1);
        root.right = BuildTree(nums, mid + 1, end);

        return root;
    }
}

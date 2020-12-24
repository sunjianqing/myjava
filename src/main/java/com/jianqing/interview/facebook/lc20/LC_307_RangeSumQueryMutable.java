package com.jianqing.interview.facebook.lc20;

/**
 * Segment tree
 * 线段树
 *
 * 在线段树上search sumRange
 *
 */
public class LC_307_RangeSumQueryMutable {

    SegmentTreeNode root = null;
    int[] nums;


    public static void main(String[] args) {
        LC_307_RangeSumQueryMutable lc = new LC_307_RangeSumQueryMutable();
        lc.buildSegmentTree(new int[]{1,3,5});
        int res = lc.sumRange(0,2);
        lc.update(1,2);
//        lc.update(2,3);
//        lc.update(0,5);
//        lc.update(0,-4);
        res = lc.sumRange(0,2);
        System.out.println(res);

    }

    public void buildSegmentTree(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        root = build(nums, start, end);
        this.nums = nums;
    }

    public SegmentTreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            root.val = nums[start];
        }
        else {
            SegmentTreeNode leftNode = build(nums, start, mid);
            SegmentTreeNode rightNode = build(nums, mid + 1, end);
            root.val += leftNode.val + rightNode.val;
            root.left = leftNode;
            root.right = rightNode;
        }

        return root;
    }

    public void update(int i, int val) {
        update(i, val, root);
    }

    public void update(int i, int val, SegmentTreeNode node) {
        if (node.start == node.end) {
            node.val = val;
            return;
        }

        // 递归下去更新，最后回来再更新root
        int mid = node.start + (node.end - node.start) / 2;
        if (i <= mid) {
            update(i, val, node.left);
        }
        else {
            update(i, val, node.right);
        }

        node.val = node.left.val + node.right.val;
    }

    public int sumRange(int i, int j) {
        return sumRange(i, j, root);
    }

    public int sumRange(int i, int j, SegmentTreeNode node) {
        if (node.start == i && node.end == j) {
            return node.val;
        }

        int mid = node.start + (node.end - node.start) / 2;
        if (mid < j && mid >= i) {
            return sumRange(i, mid, node.left) + sumRange(mid+1, j, node.right);
        }
        else {
            if (mid < i) {
                return sumRange(i, j, node.right);
            }
            else {
                return sumRange(i, j, node.left);
            }
        }
    }

    class SegmentTreeNode {
        int start;
        int end;
        int val;
        SegmentTreeNode left;
        SegmentTreeNode right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.val = 0;
        }

    }

}

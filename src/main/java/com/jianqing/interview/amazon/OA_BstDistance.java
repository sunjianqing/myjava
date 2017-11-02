package com.jianqing.interview.amazon;


import com.jianqing.interview.base.TreeNode;

/**
 * Created by jianqingsun on 10/18/17.
 */
public class OA_BstDistance {public static void main(String[] args) {
    OA_BstDistance s = new OA_BstDistance();
    s.bstDistance(new int[]{5, 6, 3, 1, 2, 4}, 6, 2, 4);
}

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int bstDistance(int[] values, int n,
                           int node1, int node2) {

        // Build Tree
        TreeNode root = buildTree(values, 0, n - 1);
        // Find LCA
        TreeNode lcaNode = findLCA(root, node1, node2);

        // Find root path
        int l1 = rootLen(root, node1) - 1;
        int l2 = rootLen(root, node2) - 1;
        int lcalen = rootLen(root, lcaNode.val) - 1;

        return l1 + l2 - 2 * lcalen;

    }

    public int rootLen(TreeNode root, int n1) {
        if (root != null) {
            int x = 0;
            if ((root.val == n1)
                    || (x = rootLen(root.left, n1)) > 0
                    || (x = rootLen(root.right, n1)) > 0) {

                return x + 1;
            }
            return 0;
        }
        return 0;
    }


    public TreeNode findLCA(TreeNode root, int n1, int n2) {
        if (root != null) {
            if (root.val == n1 || root.val == n2) {
                return root;
            }
            TreeNode left = findLCA(root.left, n1, n2);
            TreeNode right = findLCA(root.right, n1, n2);

            if (left != null && right != null) {
                return root;
            }
            if (left != null) {
                return left;
            }
            if (right != null) {
                return right;
            }
        }
        return null;
    }

    public TreeNode buildTree(int[] values, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(values[start]);
        if (start == end)
            return root;
        int leftstart = start + 1;
        int rightstart = start + 1;
        int leftend = end;
        int rightend = end;


        if (values[start + 1] < root.val) {
            int i = start + 1;
            while (i < end) {
                if (values[i] > root.val) {
                    break;
                }
                i++;
            }
            leftend = i - 1;
            rightstart = i;
        } else {
            int i = start + 1;
            while (i < end) {
                if (values[i] < root.val) {
                    break;
                }
                i++;
            }
            rightend = i - 1;
            leftstart = i;
        }


        root.right = buildTree(values, rightstart, rightend);
        root.left = buildTree(values, leftstart, leftend);
        return root;

    }
    // METHOD SIGNATURE ENDS
}

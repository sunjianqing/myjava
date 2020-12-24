package com.jianqing.interview.facebook.lc20;

import com.jianqing.interview.base.TreeNode;

/**
 * Input: "4(2(3)(1))(6(5))"
 * Output: return the tree root node representing the following tree:
 * <p>
 *     4
 *   /   \
 *  2    6
 * / \   /
 * 3 1  5
 */
public class LC_536_ConstructBinaryTreeFromString {

    private int i = 0;

    public TreeNode str2tree(String s) {
        if (s.equals("")) return null;
        return dfs(s);
    }

    private TreeNode dfs(String s) {
        TreeNode root = null;
        if (s.charAt(i) != '(') {
            root = new TreeNode(getIntVal(s));
        }

        TreeNode leftNode = null, rightNode = null;
        if (i < s.length() && s.charAt(i) == '(') {
            i++;
            leftNode = dfs(s);
        }

        if (i < s.length() && s.charAt(i) == '(') {
            i++;
            rightNode = dfs(s);
        }

        // if not '(' it must be ')' or i==s.length()
        // so we return the current stack
        root.left = leftNode;
        root.right = rightNode;
        i++;
        return root;
    }

    private int getIntVal(String s) {
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')')
                break;
            sb.append(s.charAt(i));
            i++;
        }
        int val = Integer.valueOf(sb.toString());
        return val;
    }


}

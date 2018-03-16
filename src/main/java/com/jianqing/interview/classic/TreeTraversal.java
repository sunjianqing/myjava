package com.jianqing.interview.classic;

import com.jianqing.interview.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jianqing_sun on 5/8/17.
 */
public class TreeTraversal {

    public static void main(String[] args) {

    }

    public void PostOrder(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            TreeNode current = nodes.peek();
            if (current.left == null && current.right == null) { // is Leaf
                TreeNode node = nodes.pop();
                System.out.printf("%s ", node.val);
            } else {
                if (current.right != null) {
                    nodes.push(current.right);
                    current.right = null; // 修改了原数据
                }
                if (current.left != null) {
                    nodes.push(current.left);
                    current.left = null; // 修改了原数据
                }
            }
        }

    }


    public void PostOrder2(TreeNode root) {
        if(root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        // 模板跟 inorder 差不多
        while(root != null || !stack.isEmpty()){
            if(root != null) {
                stack.push(root);
                root = root.left;
            }
            else{
                TreeNode peekNode = stack.peek();
                if(peekNode.right != null && pre != peekNode.right){
                    // 如果当前栈顶元素的右结点存在并且还没访问过（也就是右结点不等于上一个访问结点），那么就把当前结点移到右结点继续循环
                    root = peekNode.right;
                }
                else{
                    // 如果栈顶元素右结点是空或者已经访问过，那么说明栈顶元素的左右子树都访问完毕，应该访问自己继续回溯了
                    stack.pop();
                    System.out.println(peekNode.val);
                    pre = peekNode;
                }

            }
        }
    }

    /*
        Inorder Traversal 模板 可用于 validate bst， 找kth smallest number
     */
    public List Inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }

    public List Inorder2(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while( root != null || !stack.isEmpty()) {
            if(current != null) {
                stack.push(current);
                current = current.left;
            }
            else {
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                current = tmp.right;
            }
        }

        return res;
    }

    // Morris 利用了 叶子节点的 右指针是空
    public List MorrisTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        TreeNode temp = null;
        while(root != null) {
            if(root.left != null){

                temp = root.left;
                // 一路找到最右的节点， 或者最右的节点的右指针已经指向root了
                while(temp.right !=null && temp.right != root){
                    temp = temp.right;
                }

                if(temp.right != null){
                    // 改回来
                    temp.right = null;
                    System.out.println(root.val);
                    res.add(root.val);
                    root = root.right;
                }
                else{
                    // 把右指针接到root 上
                    temp.right = root;
                    root = root.left; // 可以traverse 左子树了
                }
            }
            else{
                res.add(root.val);
                root = root.right;
            }
        }

        return res;

    }
}

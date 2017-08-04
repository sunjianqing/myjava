package com.jianqing.interview.classic;

import com.jianqing.interview.base.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jianqing_sun on 6/28/17.
 */
public class SerializeDeserializeBinaryTree {
    private static final String dummy = "#";

    public static void main(String[] args) {
        SerializeDeserializeBinaryTree sdbt = new SerializeDeserializeBinaryTree();
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;

        String serialize = sdbt.serialize(root);
        System.out.println(serialize);

        TreeNode droot = sdbt.deserialize(serialize);
        System.out.println(droot.val);

    }
    public String serialize(TreeNode root) {
        StringBuffer buffer = new StringBuffer();
        serialize(root, buffer);
        return buffer.toString();
    }

    private void serialize(TreeNode node, StringBuffer sb){
        if(node == null) {
            sb.append((sb.length() == 0 ? "" : ",") + dummy);
            return;
        }
        if(sb.length() !=0){
            sb.append(",");
        }
        sb.append(node.val);
        serialize(node.left, sb);
        serialize(node.right, sb);
        return;
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue){
        String v = queue.poll();
        if(v.equals(dummy)){
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(v));
        root.left = deserialize(queue);
        root.right = deserialize(queue);

        return root;
    }

}

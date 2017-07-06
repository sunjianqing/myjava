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

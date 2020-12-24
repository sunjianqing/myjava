package com.jianqing.interview.facebook.lc20;

import com.jianqing.interview.base.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jianqing_sun on 8/9/17.
 */
public class SerializeDeserializeTree_F {
    public static void main(String[] args) {
        SerializeDeserializeTree_F sd = new SerializeDeserializeTree_F();
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;

        String serialize = sd.serialize(root);
        System.out.println(serialize);

        String serialize1 = sd.serialize(sd.deserialize(serialize));
        System.out.println(serialize1);
    }

    public static final String dummy = "#" ;
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        shelper(root, sb);

        return sb.toString();
    }

    private void shelper(TreeNode root, StringBuilder sb) {
        if(root == null) {
            if(sb.length() == 0){
                sb.append(dummy);
            }
            else{
                sb.append("," + dummy);
            }
            return;
        }

        if(sb.length() != 0)
            sb.append(",");
        sb.append(root.val);

        shelper(root.left, sb);
        shelper(root.right, sb);
    }

    public TreeNode deserialize(String str){
        Queue<String> queue = new LinkedList<>(Arrays.asList(str.split(",")));

        return dhelper(queue);
    }

    private TreeNode dhelper(Queue<String> queue) {
        String val = queue.poll();
        if(val.equals(dummy))
            return null;

        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = dhelper(queue);
        root.right = dhelper(queue);

        return root;
    }



}
